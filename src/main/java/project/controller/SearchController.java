package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
    
  /*  @RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchViewGet(Model model){
		//model.addAttribute("recipe", new Recipe());
		
		//model.addAttribute("recipes", searchService.findAllReverseOrder());
		
		return "Index";
	}*/ 
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchViewPost(@RequestParam("searchcond") String searchcond,@RequestParam("search") String search, Model model){
    	
		//model.addAttribute("recipe", new Recipe());
		
		model.addAttribute("recipes", searchService.findAllWithCond(searchcond, search));
		
		return "search/Search";
	}
}
