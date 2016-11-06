package project.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.CreateRecipeValidator;
import project.persistence.entities.HitsCounter;
import project.persistence.entities.Recipe;
import project.service.HitsCounterService;
import project.service.RecipeService;


@Controller
public class RecipeController {
	
	RecipeService recipeService;
	CreateRecipeValidator recipeValidator;
	//HitsCounterService hitsCounterService;
	//HitsCounter hitscounter;
	int hitsCount = 0;
	//List<Integer> hitCounters = new ArrayList<Integer>();
	//int[][] multi = new int[99999999][];
	
	@Autowired
	public RecipeController(RecipeService recipeService, CreateRecipeValidator recipeValidator/*, HitsCounterService hitsCounterService*/){
		this.recipeValidator = recipeValidator;
		this.recipeService = recipeService;
	//	this.hitsCounterService = hitsCounterService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexViewGet(Model model){
		
		model.addAttribute("recipe1", recipeService.findById(1L));
		model.addAttribute("recipe2", recipeService.findById(2L));
		model.addAttribute("recipe3", recipeService.findById(3L));
		model.addAttribute("recipe4", recipeService.findById(4L));
		model.addAttribute("recipe5", recipeService.findById(5L));
		model.addAttribute("recipe6", recipeService.findById(6L));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
	    model.addAttribute("hitCounter", hitsCount);
	    
		return "Index";
	}
	
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String recipeViewGet(Model model){
		
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "recipe/Recipes";
	}
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public String recipesGetRecipeFromId(@PathVariable Long id,
                                             Model model){

        // Get all recipes with this name and add them to the model
        model.addAttribute("recipes", recipeService.findById(id));
        
        
        hitsCount++;
        model.addAttribute("hitCounter", hitsCount);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
        
        // Return the view
        return "recipe/OneRecipe"; //skjalið OneRecipe í möppunni recipe
    }

	@RequestMapping(value = "/createRecipe", method = RequestMethod.GET)
	public String createRecipeViewGet(Model model){
		model.addAttribute("recipe", new Recipe());
		
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return "recipe/CreateRecipe";
	}
	

	@RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
	public String createRecipeViewPost(@ModelAttribute("recipe") Recipe formRecipe, BindingResult bindingResult, Model model){
		
		recipeValidator.validate(formRecipe, bindingResult);
		if(bindingResult.hasErrors()){
			return "recipe/CreateRecipe";
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		formRecipe.username = username;
		recipeService.save(formRecipe);
		
		//Counter fyrir page hit count búinn til 
		//hitscounter.id = formRecipe.id;
		//hitscounter.counter = 0;
		//hitsCounterService.save(hitscounter);
		
		//Dót fyrir hitsCounter - gamalt
		String name = formRecipe.recipeName;
		Recipe recipe = recipeService.findByRecipeName(name);
		Long recipeId = recipe.id;
		int recipeIdint = recipeId.intValue();
		System.out.println(recipeIdint);
		
		//Fundið út hver er að vista uppskriftina
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//hitCounters.add(recipeIdint);
		//multi[recipeIdint] = new int[recipeIdint];
		//System.out.println(multi[recipeIdint]);
		
		return "redirect:/recipes/" + recipeId;
	}
	
	
	
}
