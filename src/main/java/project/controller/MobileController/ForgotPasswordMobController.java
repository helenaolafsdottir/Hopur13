package project.controller.MobileController;

import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.persistence.entities.PasswordResetToken;
import project.persistence.entities.User;
import project.service.UserService;

@RestController
	public class ForgotPasswordMobController {
	UserService userService;
	private JavaMailSender mailSender;
	private final String emailFrom = "uppskriftabankinn@gmail.com";
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public ForgotPasswordMobController(UserService userService, JavaMailSender mailSender, BCryptPasswordEncoder passwordEncoder){
		this.userService = userService;
		this.mailSender = mailSender;
		this.passwordEncoder = passwordEncoder;
	}
	
	@RequestMapping(value="/m/forgotPassword", method=RequestMethod.POST)
	public String forgotViewPost(@RequestParam("emailForgot") String emailForgotPassword, Model model, HttpServletRequest request, RedirectAttributes redir){
		User user = userService.findByEmail(emailForgotPassword);
		if(user == null){
			model.addAttribute("resultMessage", "Email does not exist!");
		
			return "[]";
		}
		
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		String contextPath = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		SimpleMailMessage email = constructResetTokenEmail(contextPath, token, user);
		mailSender.send(email);
		model.addAttribute("resultMessage", "Password reset email sent!");
		System.out.println("sent");
		return "[]";
	}
	
	private SimpleMailMessage constructResetTokenEmail(String contextPath, String token, User user){
		String url = contextPath + "/resetPassword?id=" + user.getId() + "&token=" + token;
		String text = "Hello, if you requested a password reset, follow this link: \n" + url;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setFrom(this.emailFrom);
		email.setSubject("Reset password");
		email.setText(text);
		return email;
	}
	
	
	@RequestMapping(value="/m/resetPassword", method=RequestMethod.POST)
	public String resetPasswordPost(@RequestParam(value="id") Long urlId, @RequestParam(value="token") String urlToken, @RequestParam("resetPassword") String resetPassword,
			@RequestParam("resetPasswordAgain") String resetPasswordAgain, Model model, RedirectAttributes redir){
		System.out.println("post");
		PasswordResetToken passToken = userService.findPasswordResetTokenByToken(urlToken);
		User user = passToken.getUser();
		if(passToken == null || user.getId() != urlId) {
			redir.addFlashAttribute("resultMessage", "This user has not requested a password reset!");
			return "redirect:/userbla";
		}
		Calendar cal = Calendar.getInstance();
		
		if(cal.after(passToken.getExpiryDate())){
			redir.addFlashAttribute("resultMessage", "Password reset link has expired");
			return "redirect:/userbla";
		}
		if(!resetPassword.equals(resetPasswordAgain)){
			redir.addFlashAttribute("resultMessage", "Passwords do not match");
			return "redirect:/resetPassword?id=" + urlId + "&token=" + urlToken; 
		}
		if(resetPassword.length() < 8){
			redir.addFlashAttribute("resultMessage", "Password has to be longer than 7 letters!");
			return "redirect:/resetPassword?id=" + urlId + "&token=" + urlToken; 
		}
		String encodedResetPassword = passwordEncoder.encode(resetPassword);
		user.setPassword(encodedResetPassword);
		user.setPasswordConfirm(encodedResetPassword);
		userService.save(user);
		System.out.println("4");
		redir.addFlashAttribute("resultMessage", "Password reset successful");
		return "[]";
	}
	
	
}
