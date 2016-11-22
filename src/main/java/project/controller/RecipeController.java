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
import project.persistence.entities.Recipe;
import project.service.RecipeService;


@Controller
public class RecipeController {
	
	//Initialization of the classes that will be used
	RecipeService recipeService;
	CreateRecipeValidator recipeValidator;
	
	// Dependency Injection
	@Autowired
	public RecipeController(RecipeService recipeService, CreateRecipeValidator recipeValidator){
		this.recipeValidator = recipeValidator;
		this.recipeService = recipeService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findTop6ByOrderByCounterDesc());
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "Index";
	}
	
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String recipeViewGet(Model model){
		
    	//Add all the recipes to the model
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
	
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/Recipes";
	}
    
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public String recipesGetRecipeFromId(@PathVariable Long id,
                                             Model model){

        // Get all recipes with this name and add them to the model
        model.addAttribute("recipes", recipeService.findById(id));
        
        //Update hitsCounter for this recipe
        Recipe recipehitscounter = recipeService.findById(id);
        recipehitscounter.counter++;
        recipeService.save(recipehitscounter);
        
        //This functionality is for the login/logout button
        //Get the logged in username so we can see if the user has logged in or not
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
        
        // Return the view
        return "recipe/OneRecipe"; //skjalið OneRecipe í möppunni recipe
    }

	@RequestMapping(value = "/createRecipe", method = RequestMethod.GET)
	public String createRecipeViewGet(Model model){
		
		//Add a new recipe to the model for the form
		model.addAttribute("recipe", new Recipe());
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/CreateRecipe";
	}
	

	@RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
	public String createRecipeViewPost(@ModelAttribute("recipe") Recipe formRecipe, BindingResult bindingResult, Model model){
		
		//Validator for the createRecipe form
		recipeValidator.validate(formRecipe, bindingResult);
		if(bindingResult.hasErrors()){
			return "recipe/CreateRecipe";
		}
		
		//Add counter and username to the recipe and save it to the db
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
		formRecipe.username = username;
		formRecipe.counter = 0;
		recipeService.save(formRecipe);
		
		//Get the id of the recipe being saved
		String name = formRecipe.recipeName;
		Recipe recipe = recipeService.findByRecipeName(name);
		Long recipeId = recipe.id;
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		String loggedInUser = auth.getName(); 
		model.addAttribute("loggedInUser", loggedInUser);
		
		//return the new recipes page if the creation was successful
		return "redirect:/recipes/" + recipeId;
	}
	
	@RequestMapping(value = "/recipeAppetizers", method = RequestMethod.GET)
	public String recipeApetizersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("appetizers"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeAppetizers";
	}
	@RequestMapping(value = "/recipeBaking", method = RequestMethod.GET)
	public String recipeBakingViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("baking"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeBaking";
	}
	@RequestMapping(value = "/recipeBreakfast", method = RequestMethod.GET)
	public String recipeBreakfastViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("breakfast"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeBreakfast";
	}
	@RequestMapping(value = "/recipeDesserts", method = RequestMethod.GET)
	public String recipeDessertsViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("desserts"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeDesserts";
	}
	@RequestMapping(value = "/recipeDinners", method = RequestMethod.GET)
	public String recipeDinnersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("dinner"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeDinners";
	}
	@RequestMapping(value = "/recipeRaw", method = RequestMethod.GET)
	public String recipeRawViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("raw"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		//Return the view
		return "recipe/RecipeRaw";
	}
	
}
