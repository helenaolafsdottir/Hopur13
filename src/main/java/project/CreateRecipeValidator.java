package project;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.persistence.entities.Recipe;
import project.persistence.entities.User;
import project.service.RecipeService;


@Component
public class CreateRecipeValidator implements Validator{
	
	@Autowired
	private RecipeService recipeService;
	
	@Override
	public boolean supports(Class<?> aClass){
		return Recipe.class.equals(aClass);
	}
	
	
	public JSONObject validateAndroid(Recipe recipe) throws JSONException{
		JSONObject jsonObject = new JSONObject();
		
		if (recipe.getRecipeName().length() == 0) {
			jsonObject.append("recipeName", "Recipe name can't be empty");
		}
		
		if(recipeService.findByRecipeName(recipe.getRecipeName())!= null){
			jsonObject.append("recipeName", "Recipe name is taken");
		}
		
		if (recipe.getIngredients().length() == 0) {
			jsonObject.append("ingredients", "Ingredients field can't be empty");
		}
		
		if (recipe.getInstructions().length() == 0) {
			jsonObject.append("instructions", "Instructions field can't be empty");
		}
		
		if (recipe.getImage().length() == 0) {
			jsonObject.append("image", "Image field can't be empty");
		}
		
		return jsonObject;
	}
	
	
	
	
	@Override
	public void validate(Object o, Errors errors) {
		
		Recipe recipe = (Recipe) o;
		
		//Validation for the field recipeName. This field has contain at least 2 characters
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipeName", "NotEmpty");
		if (recipe.getRecipeName().length() < 2) {
			errors.rejectValue("recipeName", "Size.recipe.recipeName");
		}
		
		//Validation for the field ingredients. This field has contain at least 3 characters
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ingredients", "NotEmpty");
		if (recipe.getIngredients().length() < 3) {
			errors.rejectValue("ingredients", "Size.recipe.ingredients");
		}
		
		//Validation for the field instructions. This field has contain at least 10 characters
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructions", "NotEmpty");
		if (recipe.getInstructions().length() < 10) {
			errors.rejectValue("instructions", "Size.recipe.instructions");
		}	
		
		//Validation for the field image. This field has contain at least 10 characters
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "NotEmpty");
		if (recipe.getImage().length() < 10) {
			errors.rejectValue("image", "Size.recipe.image");
		}	
	}

}
