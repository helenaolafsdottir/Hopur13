package project.service;

import java.util.List;


import project.persistence.entities.Recipe;

public interface RecipeService {
	/**
	 * Vistar uppskrift í grunni
	 * @param recipe
	 * @return
	 */
	Recipe save(Recipe recipe);
	
	void delete(Recipe recipe);
	
	List<Recipe> findAll();
	
	List<Recipe> findAllReverseOrder();
	
	Recipe findByRecipeName(String recipeName);
	Recipe findById(Long id);
	
	Recipe findOne(Long id);
	
	
	//List<Recipe> findFirstThreeRecipes();
	//Recipe insertFirstRecipe();
	
	//List<Recipe> findBySearchconditionAndSearchtype(String searchCondition, String searchType);
	
   
}
