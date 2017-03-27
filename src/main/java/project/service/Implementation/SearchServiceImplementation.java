package project.service.Implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Recipe;
import project.persistence.repositories.RecipeRepository;
import project.service.SearchService;

@Service
public class SearchServiceImplementation implements SearchService {
	 // Instance Variables
	 
	RecipeRepository repository;
    
    // Dependency Injection
	@Autowired
    public SearchServiceImplementation(RecipeRepository repository) {
        this.repository = repository;
    }
	
	/**
	 * Finds all recipes according to specific search conditions.
	 * @param the search condition to specify what to search by
	 * @param the search itself
	 * @return list of recipes following the search if it exists, else empty list
	 */
	@Override
	public List<Recipe> findAllWithCond(String searchcond, String search) {
		Set<Recipe> recipeSet = new HashSet<Recipe>();
		if(!("".equals(search))){
			recipeSet.addAll(repository.findByUsername(search));
			recipeSet.addAll(repository.findByRecipeNameContaining(search));
			recipeSet.addAll(repository.findByIngredientsContaining(search));
			List<Recipe> recipeList = new ArrayList<Recipe>();
			recipeList.addAll(recipeSet);
			return recipeList;
		}
		/*if (searchcond.equals("username")) {
			List<Recipe> recipes = repository.findByUsername(search);
			return recipes;
	
		}else if (searchcond.equals("recipe_name")) {
			List<Recipe> recipes = repository.findByRecipeNameContaining(search);
			return recipes;
			
		}else if (searchcond.equals("ingredients")) {
			List<Recipe> recipes = repository.findByIngredientsContaining(search);
			return recipes;
			
		}*/ else {
			List<Recipe> recipes = null;
			return recipes;
		}
	}
	
}