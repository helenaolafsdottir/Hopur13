package project.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.List;
import project.persistence.entities.PostitNote;
import project.persistence.entities.Recipe;
import project.persistence.entities.User;
import project.service.RecipeService;
import project.service.StringManipulationService;

@Controller
public class RecipeController {

	
	RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService){
		
		this.recipeService = recipeService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexViewGet(Model model){
		
	//	model.addAttribute("recipes", recipeService.findFirstThreeRecipes());
		model.addAttribute("recipe1", recipeService.findById(1L));
		model.addAttribute("recipe2", recipeService.findById(2L));
		model.addAttribute("recipe3", recipeService.findById(3L));
		model.addAttribute("recipe4", recipeService.findById(4L));
		model.addAttribute("recipe5", recipeService.findById(5L));
		model.addAttribute("recipe6", recipeService.findById(6L));
		
		return "Index";
	}
	
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public String recipeViewGet(Model model){
		
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		return "recipe/Recipes";
	}
    @RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
    public String recipesGetRecipeFromId(@PathVariable Long id,
                                             Model model){

        // Get all recipes with this name and add them to the model
        model.addAttribute("recipes", recipeService.findById(id));

        // Return the view
        return "recipe/OneRecipe"; //skjalið OneRecipe í möppunni recipe
    }

	@RequestMapping(value = "/createRecipe", method = RequestMethod.GET)
	public String createRecipeViewGet(Model model){
		model.addAttribute("recipe", new Recipe());
		
		//model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		return "recipe/CreateRecipe";
	}
	

	@RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
	public String createRecipeViewPost(@ModelAttribute("recipe") Recipe formRecipe, Model model){
	//	Date createDate = new Date();
	//	formRecipe.setCreateDate(createDate);
		recipeService.save(formRecipe);
		
		model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		model.addAttribute("recipe", new Recipe());
		
		return "recipe/CreateRecipe";
	}
	
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPageViewGet(Model model){
		//model.addAttribute("recipe", new Recipe());
		
		//model.addAttribute("recipes", recipeService.findAllReverseOrder());
		
		return "user/MyPage";
	}
	
}
