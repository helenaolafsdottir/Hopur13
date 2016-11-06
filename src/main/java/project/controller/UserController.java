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
	
	@RequestMapping(value = "/userbla", method = RequestMethod.GET)
	public String userViewGet(Model model){
		model.addAttribute("user", new User());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "user/Users";
	}
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPageViewGet(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String loggedInUser = auth.getName(); //get logged in username
		System.out.println(loggedInUser);
		//System.out.println(recipeService.findByUsername(search));
		
		model.addAttribute("recipes", recipeService.findByUsername(loggedInUser));
		model.addAttribute("loggedInUser", loggedInUser);
		return "user/MyPage";
	}
	
	@RequestMapping(value = "/userbla", method = RequestMethod.POST) 
	public String userViewPost(@ModelAttribute("user") User formUser, BindingResult bindingResult, Model model){
		Date createDate = new Date();
		formUser.setCreateDate(createDate);
		formUser.setEnabled(1);
		userValidator.validate(formUser, bindingResult);
		if(bindingResult.hasErrors()){
			return "user/Users";
		}
		String unencodedPassword = formUser.getPassword();
		String encodedPassword = passwordEncoder.encode(unencodedPassword);
		formUser.setPassword(encodedPassword);
		
		User savedUser = userService.save(formUser);
		Long savedId = savedUser.getId();
		String role = "ROLE_USER";
		UserRole userRole = new UserRole(savedId, role);
		UserRole savedUserRole = userService.save(userRole);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		model.addAttribute("user", new User());
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
			
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "user/Login";
	}
}