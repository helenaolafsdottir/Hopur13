package project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;
import project.UserValidator;
import project.persistence.entities.Recipe;
import project.persistence.entities.User;
import project.persistence.entities.UserRole;
import project.service.RecipeService;
import project.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class UserController {

	UserService userService;
	RecipeService recipeService;
	BCryptPasswordEncoder passwordEncoder;
	UserValidator userValidator;
	
	
	@Autowired
	public UserController(UserService userService, BCryptPasswordEncoder passwordEncoder, UserValidator userValidator, RecipeService recipeService){
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.userValidator = userValidator;
		this.recipeService = recipeService;
	}
	
	/**
	 * Is called when the Request Mapping url is accessed with a GET
	 * New empty user put in variable user and is added to model to be used in form
	 * @param model
	 * @return String where jsp page is
	 */
	@RequestMapping(value = "/userbla", method = RequestMethod.GET)
	public String userViewGet(Model model){
		model.addAttribute("user", new User());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "user/Users";
	}
	/**
	 * Is called when Request mapping url is accessed with GET
	 * Finds all recipes with a specific username
	 * @param model
	 * @return Mypage jsp
	 */
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPageViewGet(Model model){
		//get logged in user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String loggedInUser = auth.getName(); //get logged in username
		
	    //adds all recipes with a specific username to variable recipes in model
		model.addAttribute("recipes", recipeService.findByUsername(loggedInUser));
		model.addAttribute("loggedInUser", loggedInUser);
		return "user/MyPage";
	}
	
	/**
	 * Is called when Request Mapping url is accessed with POST
	 * 
	 * @param formUser
	 * @param bindingResult
	 * @param model
	 * @return redirection to login page
	 */
	@RequestMapping(value = "/userbla", method = RequestMethod.POST) 
	public String userViewPost(@ModelAttribute("user") User formUser, BindingResult bindingResult, Model model){
		//create date
		Date createDate = new Date();
		//set create date in formUser
		formUser.setCreateDate(createDate);
		//the user starts as enabled user
		formUser.setEnabled(1);
		//validates the user
		userValidator.validate(formUser, bindingResult);
		//if validation fails, return to form
		if(bindingResult.hasErrors()){
			return "user/Users";
		}
		//get password
		String unencodedPassword = formUser.getPassword();
		//password is encoded
		String encodedPassword = passwordEncoder.encode(unencodedPassword);
		//the encoded password is put into formUser
		formUser.setPassword(encodedPassword);
		formUser.setPasswordConfirm(encodedPassword);
		
		if(userService.findByEmail(formUser.getEmail()) != null){
			model.addAttribute("resultMessage", "Email already exists");
			return "user/Users";
		}
		if(userService.findByUserName(formUser.getUserName()) != null){
			model.addAttribute("resultMessage", "Username already exists");
		}
		//the formUser is saved and the saved user returned
		User savedUser = userService.save(formUser);
		//get id from the saved user
		Long savedId = savedUser.getId();
		//role is set as ROLE_USER
		String role = "ROLE_USER";
		//userRole for saved user is created
		UserRole userRole = new UserRole(savedId, role);
		//userRole for saved user is saved
		UserRole savedUserRole = userService.save(userRole);
		
		//get username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		//loggedInUser is added to model
		model.addAttribute("loggedInUser", loggedInUser);
		//user is directed to login page
		return "redirect:/login";
	}
	
	/**
	 * Is called when Request mapping url is accessed with GET
	 * @param model
	 * @param error
	 * @param logout
	 * @return Login jsp
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		//get username
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		//logged in user is added to model
		model.addAttribute("loggedInUser", loggedInUser);
		//login jsp is returned
		return "user/Login";
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.GET)
	public String changePasswordViewGet(Model model){
		return "user/ChangePassword";
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePasswordViewPost(Model model, @RequestParam("resetPassword") String resetPassword, @RequestParam("resetPasswordAgain") String resetPasswordAgain){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName();
		model.addAttribute("loggedInUser", loggedInUser);
		User user = userService.findByUserName(loggedInUser);
		if(!resetPassword.equals(resetPasswordAgain)){
			model.addAttribute("resultMessage", "Passwords do not match!");
			return "user/ChangePassword";
		}
		if(resetPassword.length()<8){
			model.addAttribute("resultMessage", "Password has to be longer than 7 letters!");
			return "user/ChangePassword";
		}
		String encodedResetPassword = passwordEncoder.encode(resetPassword);
		user.setPassword(encodedResetPassword);
		user.setPasswordConfirm(encodedResetPassword);
		userService.save(user);
		model.addAttribute("resultMessage", "Password has been reset!");
		return "user/ChangePassword";
	}
}