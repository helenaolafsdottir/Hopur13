package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Recipe;
import project.service.SearchService;
import project.persistence.repositories.RecipeRepository;

@Controller
public class SearchController {

	// Instance Variables
	SearchService searchService;

	// Dependency Injection
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchViewPost(@RequestParam("searchcond") String searchcond, @RequestParam("search") String search,
			Model model) {
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); // get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Add all recipes found using specific search conditions to the model.
		model.addAttribute("recipes", searchService.findAllWithCond(searchcond, search));

		//Return the view
		return "search/Search";
	}
}
