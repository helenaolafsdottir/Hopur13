package project;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.persistence.entities.Recipe;

import project.service.RecipeService;


@Component
public class CreateRecipeValidator implements Validator{
	@Autowired
	private RecipeService recipeService;
	
	@Override
	public boolean supports(Class<?> aClass){
		return Recipe.class.equals(aClass);
	}
	
	@Override
	public void validate(Object o, Errors errors) {
		Recipe recipe = (Recipe) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recipeName", "NotEmpty");
		if (recipe.getRecipeName().length() < 2) {
			errors.rejectValue("recipeName", "Size.recipe.recipeName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ingredients", "NotEmpty");
		if (recipe.getIngredients().length() < 3) {
			errors.rejectValue("ingredients", "Size.recipe.ingredients");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "instructions", "NotEmpty");
		if (recipe.getInstructions().length() < 10) {
			errors.rejectValue("instructions", "Size.recipe.instructions");
		}	
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "NotEmpty");
		if (recipe.getImage().length() < 10) {
			errors.rejectValue("image", "Size.recipe.image");
		}	
	}

}
