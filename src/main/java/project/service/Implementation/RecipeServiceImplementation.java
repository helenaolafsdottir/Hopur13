package project.service.Implementation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Recipe;
import project.persistence.repositories.RecipeRepository;
import project.service.RecipeService;

@Service
public class RecipeServiceImplementation implements RecipeService{
	 
		//Instance variable
		RecipeRepository repository;

	    
	    // Dependency Injection
		@Autowired
	    public RecipeServiceImplementation(RecipeRepository repository) {
	        this.repository = repository;
	    }
	 
	    public Recipe save(Recipe recipe) {
	        return repository.save(recipe);
	    }

	    public void delete(Recipe recipe) {
	        repository.delete(recipe);
	    }

	 
	    public List<Recipe> findAll() {
	        return repository.findAll();
	    }

	    
	    public List<Recipe> findAllReverseOrder() {
	        // Get all the Postit notes
	        List<Recipe> recipes = repository.findAll();

	        // Reverse the list
	        Collections.reverse(recipes);

	        return recipes;
	    }

	    public Recipe findOne(Long id) {
	        return repository.findOne(id);
	    }
		
	    public Recipe findByRecipeName(String recipeName) {
			return repository.findByRecipeName(recipeName);
		}
	    
	    public Recipe findById(Long id) {
			return repository.findById(id);
		}

		@Override
		public List<Recipe> findByUsername(String search) {
			return repository.findByUsername(search);
		}
		@Override
		public List<Recipe> findByRecipeGroup(String search) {
			return repository.findByRecipeGroup(search);
		}

		@Override
		public List<Recipe> findTop6ByOrderByCounterDesc() {
			return repository.findTop6ByOrderByCounterDesc();
		}
}
