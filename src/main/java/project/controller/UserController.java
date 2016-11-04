package project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.UserValidator;
import project.persistence.entities.User;
import project.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {

	UserService userService;
	BCryptPasswordEncoder passwordEncoder;
	UserValidator userValidator;
	
	@Autowired
	public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder, UserValidator userValidator){
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.userValidator = userValidator;
	}
	
	@RequestMapping(value = "/userbla", method = RequestMethod.GET)
	public String userViewGet(Model model){
		model.addAttribute("user", new User());
		
		return "user/Users";
	}
	
	@RequestMapping(value = "/userbla", method = RequestMethod.POST)
	public String userViewPost(@ModelAttribute("user") User formUser, BindingResult bindingResult, Model model){
		Date createDate = new Date();
		formUser.setCreateDate(createDate);
		userValidator.validate(formUser, bindingResult);
		if(bindingResult.hasErrors()){
			return "user/Users";
		}
		String unencodedPassword = formUser.getPassword();
		String encodedPassword = passwordEncoder.encode(unencodedPassword);
		formUser.setPassword(encodedPassword);
		
		userService.save(formUser);
		
		model.addAttribute("user", new User());
		
		return "user/Users";
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//		public String login(Model model, String error, String logout) {
//			if(error != null){
//				model.addAttribute("error", "Your username and password is invalid.");
//			}
//			if(logout != null){
//				model.addAttribute("message", "You have been logged out successfully");
//				return "login";
//		}
//			return logout;
//	}
}