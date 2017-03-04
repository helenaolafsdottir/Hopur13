package project.controller.MobileController;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import project.CreateRecipeValidator;
import project.persistence.entities.Recipe;
import project.persistence.entities.RecipeGroup;
import project.service.RecipeService;

@RestController
public class RecipeMobileController {
	//Initialization of the classes that will be used
		RecipeService recipeService;
		CreateRecipeValidator recipeValidator;
		
		// Dependency Injection
		@Autowired
		public RecipeMobileController(RecipeService recipeService, CreateRecipeValidator recipeValidator){
			this.recipeValidator = recipeValidator;
			this.recipeService = recipeService;
		}
	
	
	
	
	@RequestMapping(value="/m/", method = RequestMethod.GET)
	public String indexViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findTop6ByOrderByCounterDesc());
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipes", method = RequestMethod.GET)
	public String recipeViewGet(Model model){
		
    	//Add all the recipes to the model
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
	
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	

    @RequestMapping(value = "/m/recipeGroupsList", method = RequestMethod.GET)
    public List<RecipeGroup> recipesGetGroups(Model model){
    	
    	List<RecipeGroup> listRecipeGroups = new ArrayList<RecipeGroup>();
    	
    	
    	RecipeGroup recipeGroup1 = new RecipeGroup();
    	RecipeGroup recipeGroup2 = new RecipeGroup();
    	RecipeGroup recipeGroup3= new RecipeGroup();
    	RecipeGroup recipeGroup4 = new RecipeGroup();
    	RecipeGroup recipeGroup5 = new RecipeGroup();
    	RecipeGroup recipeGroup6 = new RecipeGroup();
    	
    	recipeGroup1.setGroupName("Appetizers");
    	recipeGroup2.setGroupName("Baking");
    	recipeGroup3.setGroupName("Breakfast");
    	recipeGroup4.setGroupName("Desserts");
    	recipeGroup5.setGroupName("Dinner");
    	recipeGroup6.setGroupName("Raw");
    	
    	listRecipeGroups.add(recipeGroup1);
    	listRecipeGroups.add(recipeGroup2);
    	listRecipeGroups.add(recipeGroup3);
    	listRecipeGroups.add(recipeGroup4);
    	listRecipeGroups.add(recipeGroup5);
    	listRecipeGroups.add(recipeGroup6);
    	
    	return listRecipeGroups;
    	
    }


	@RequestMapping(value="/m/recipes/{id}", method = RequestMethod.GET)
	public Recipe recipesGetRecipeFromId(@PathVariable Long id,
            Model model){
/*
	// Get all recipes with this name and add them to the model
	model.addAttribute("recipes", recipeService.findById(id));
	
	//Update hitsCounter for this recipe
	Recipe recipehitscounter = recipeService.findById(id);
	recipehitscounter.counter++;
	recipeService.save(recipehitscounter);
	*/
		
	//This functionality is for the login/logout button
	//Get the logged in username so we can see if the user has logged in or not
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String loggedInUser = auth.getName(); //get logged in username
	model.addAttribute("loggedInUser", loggedInUser);
	
	return recipeService.findById(id);
	}
	
	@RequestMapping(value="/m/createRecipe", method = RequestMethod.GET)
	public String createRecipeViewGet(Model model){
		
		//Add a new recipe to the model for the form
		model.addAttribute("recipe", new Recipe());
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="m/createRecipe", method = RequestMethod.POST)
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
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeAppetizers", method = RequestMethod.GET)
	public String recipeApetizersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("appetizers"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeBaking", method = RequestMethod.GET)
	public String recipeBakingViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("baking"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeBreakfast", method = RequestMethod.GET)
	public String recipeBreakfastViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("breakfast"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeDesserts", method = RequestMethod.GET)
	public String recipeDessertsViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("desserts"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeDinners", method = RequestMethod.GET)
	public String recipeDinnersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("dinner"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
	
	@RequestMapping(value="/m/recipeRaw", method = RequestMethod.GET)
	public String recipeRawViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("raw"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return "[]";
	}
}
