package project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.User;
import project.service.UserService;

@Controller
public class UserController {

	UserService userService;
	
	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}
	
	@RequestMapping(value = "/userbla", method = RequestMethod.GET)
	public String userViewGet(Model model){
		model.addAttribute("user", new User());
		
		model.addAttribute("users", userService.findAllReverseOrder());
		
		return "user/Users";
	}
	
	@RequestMapping(value = "/userbla", method = RequestMethod.POST)
	public String userViewPost(@ModelAttribute("user") User formUser, Model model){
		Date createDate = new Date();
		formUser.setCreateDate(createDate);
		userService.save(formUser);
		
		model.addAttribute("users", userService.findAllReverseOrder());
		
		model.addAttribute("user", new User());
		
		return "user/Users";
	}
}