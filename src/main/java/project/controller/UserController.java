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

import project.UserValidator;
import project.persistence.entities.User;
import project.persistence.entities.UserRole;
import project.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPageViewGet(Model model){
		//model.addAttribute("recipe", new Recipe());
		
		//model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String name = auth.getName(); //get logged in username
	    
	    System.out.println(name);
	    
		return "user/MyPage";
	}
	
	@RequestMapping(value = "/myPage/{id}", method = RequestMethod.GET)
    public String myPageWithIdViewGet(@PathVariable Long id,
                                             Model model){

        // Get all recipes with this name and add them to the model
        model.addAttribute("user", userService.findOne(id));

        // Return the view
        return "recipe/OneRecipe"; //skjalið OneRecipe í möppunni recipe
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
		
		model.addAttribute("user", new User());
		
		return "redirect:/login";
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