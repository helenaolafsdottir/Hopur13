package project.controller.MobileController;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import project.CreateRecipeValidator;
import project.persistence.entities.Recipe;
import project.persistence.entities.RecipeGroup;
import project.persistence.entities.User;
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
	
	
	@RequestMapping(value="/m/recipes/getId/{recipeName}", method = RequestMethod.GET)
	public Recipe recipeViewGet(@PathVariable String recipeName, Model model){
		
		System.out.println("Ég komst hingað!");	
		Recipe recipe = recipeService.findByRecipeName(recipeName);
		System.out.println(recipe.getRecipeName());
		
		return recipeService.findByRecipeName(recipeName);
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
    	
    	recipeGroup1.setImage("http://www.drodd.com/images15/appetizer17.jpg");
    	recipeGroup2.setImage("https://static.pexels.com/photos/9510/food-pizza-kitchen-recipe.jpg");
    	recipeGroup3.setImage("https://sites.psu.edu/siowfa16/files/2016/10/shutterstock_245938681.0.0-239e4it.jpg");
    	recipeGroup4.setImage("http://cdn-image.foodandwine.com/sites/default/files/HD-200912-r-raspberry-macarons.jpg");
    	recipeGroup5.setImage("http://del.h-cdn.co/assets/15/11/980x490/landscape-1426080236-135607296.jpg");
    	recipeGroup6.setImage("https://bornunderthesunblog.files.wordpress.com/2016/06/dsc_5793.jpg?w=816");
    	
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
	
	@RequestMapping(value="/m/createRecipe/{recipeName}/{recipeGroup}/{ingredients}/{instructions}/{image}", method = RequestMethod.GET)
	public Recipe createRecipeViewGet(@PathVariable String recipeName, @PathVariable String recipeGroup, @PathVariable String ingredients,
			@PathVariable String instructions, @PathVariable String image, Model model){
		
		//Add a new recipe to the model for the form
		//model.addAttribute("recipe", new Recipe());
		System.out.println("Aloha");
		//Save the recipe from the user
		Recipe formRecipe = new Recipe();
	    formRecipe.setRecipeName(recipeName);
	    formRecipe.setRecipeGroup(recipeGroup);
	    formRecipe.setIngredients(ingredients);
	    formRecipe.setInstructions(instructions);
	    formRecipe.setImage(image);
	    formRecipe.setUsername("helena");
	    recipeService.save(formRecipe);
	    System.out.println("Aloha2");
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//String loggedInUser = auth.getName(); //get logged in username
		//model.addAttribute("loggedInUser", loggedInUser);
	    
	    
	    //Find the recipe to display it for the user
	    Recipe newRecipe = recipeService.findByRecipeName(recipeName);
	    System.out.println("Aloha3");
	    Long newRecipeId = newRecipe.getId();
	    newRecipe.setId(newRecipeId);
	    System.out.println(newRecipe.getId());
	    
		return newRecipe;
	}
	
	public Recipe parseRecipeData(String jsonString) throws JSONException {
		System.out.println("jsonStr:  " + jsonString);
	    JSONObject jsonObject = new JSONObject(jsonString);
	    
	    System.out.println(jsonObject.getString("recipeName"));
	    System.out.println(jsonObject.getString("recipeGroup"));
	    System.out.println(jsonObject.getString("instructions"));
	    System.out.println(jsonObject.getString("ingredients"));
	    System.out.println(jsonObject.getString("image"));
	    
	    
		Recipe recipe = new Recipe();
		
		recipe.setRecipeName(jsonObject.getString("recipeName"));
		recipe.setRecipeGroup(jsonObject.getString("recipeGroup"));
		recipe.setIngredients(jsonObject.getString("ingredients"));
		recipe.setInstructions(jsonObject.getString("instructions"));
		recipe.setImage(jsonObject.getString("image"));
		recipe.setUsername(jsonObject.getString("username"));
		
		return recipe;
	}
	
	@RequestMapping(value = "/m/createRecipe", method=RequestMethod.POST)
	public ResponseEntity<String> createRecipe(@RequestBody String jsonString) throws JSONException {
	    System.out.println("jsonStr:  " + jsonString);
	    
	    Recipe formRecipe = this.parseRecipeData(jsonString);
	    
		JSONObject jsonObject = this.recipeValidator.validateAndroid(formRecipe);
		if(jsonObject.length() > 0){
			return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK); //returns the error message to the client side
		}
	    
	    /**
	    JSONObject jsonObject = new JSONObject(jsonStr);
	    
	    Recipe formRecipe = new Recipe();
	    formRecipe.setRecipeName(jsonObject.getString("recipeName"));
	    formRecipe.setRecipeGroup(jsonObject.getString("recipeGroup"));
	    formRecipe.setIngredients(jsonObject.getString("Ingredients"));
	    formRecipe.setInstructions(jsonObject.getString("Instructions"));
	    formRecipe.setImage(jsonObject.getString("Image"));
	    
	    System.out.println(formRecipe.recipeName);
	    
	    **/

		
		//Add counter and username to the recipe and save it to the db
		formRecipe.counter = 0;
		System.out.println(formRecipe.getUsername());
	    
		recipeService.save(formRecipe);
	    
	    return new ResponseEntity<String>("OK", HttpStatus.OK); //returns status "OK" to the client side
	    
	
	}  
	/*
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
	*/
	@RequestMapping(value="/m/recipe/appetizers", method = RequestMethod.GET)
	public List<Recipe> recipeApetizersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		//model.addAttribute("recipes", recipeService.findByRecipeGroup("appetizers"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		
		return recipeService.findByRecipeGroup("appetizers");
	}
	
	@RequestMapping(value="/m/recipe/baking", method = RequestMethod.GET)
	public List<Recipe> recipeBakingViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("baking"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return recipeService.findByRecipeGroup("baking");
	}
	
	@RequestMapping(value="/m/recipe/breakfast", method = RequestMethod.GET)
	public List<Recipe> recipeBreakfastViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("breakfast"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return recipeService.findByRecipeGroup("breakfast");
	}
	
	@RequestMapping(value="/m/recipe/desserts", method = RequestMethod.GET)
	public List<Recipe> recipeDessertsViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		model.addAttribute("recipes", recipeService.findByRecipeGroup("desserts"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return recipeService.findByRecipeGroup("desserts");
	}
	
	@RequestMapping(value="/m/recipe/dinners", method = RequestMethod.GET)
	public List<Recipe> recipeDinnersViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		//model.addAttribute("recipes", recipeService.findByRecipeGroup("dinner"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return recipeService.findByRecipeGroup("dinner");
	}
	
	@RequestMapping(value="/m/recipe/raw", method = RequestMethod.GET)
	public List<Recipe> recipeRawViewGet(Model model){
		
		//Add the 6 most popular recipes to the model
		//model.addAttribute("recipes", recipeService.findByRecipeGroup("raw"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);
		return recipeService.findByRecipeGroup("raw");
	}
	@RequestMapping(value="/m/recipeByUser/{user}", method = RequestMethod.GET)
	public List<Recipe> recipesFindByUserViewGet(@PathVariable String user, Model model){
		
		//Add the 6 most popular recipes to the model
		//model.addAttribute("recipes", recipeService.findByRecipeGroup("raw"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);*/
		return recipeService.findByUsername(user);
	}
	@RequestMapping(value="/m/recipes/delete/{id}", method = RequestMethod.GET)
	public String recipeDeleteViewGet(@PathVariable Long id, Model model){
		
		//Add the 6 most popular recipes to the model
		//model.addAttribute("recipes", recipeService.findByRecipeGroup("raw"));
		
		//This functionality is for the login/logout button
		//Get the logged in username so we can see if the user has logged in or not
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedInUser = auth.getName(); //get logged in username
		model.addAttribute("loggedInUser", loggedInUser);*/
		
		Recipe recipe = recipeService.findById(id);
		recipeService.delete(recipe);
		
		return "Ok";

	}
}
