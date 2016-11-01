package project.service.Implementation;

import java.util.Collections;
import java.util.List;

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
 
    @Override
    public Recipe save(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public void delete(Recipe recipe) {
        repository.delete(recipe);
    }

    @Override
    public List<Recipe> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Recipe> findAllReverseOrder() {
        // Get all the Postit notes
        List<Recipe> recipes = repository.findAll();

        // Reverse the list
        Collections.reverse(recipes);

        return recipes;
    }

    @Override
    public Recipe findOne(Long id) {
        return repository.findOne(id);
    }
    /*
    @Override
    public List<Recipe> findBySearchconditionAndSearchtype(String searchCondition, String searchType) {
        return repository.findBySearchconditionAndSearchtype(searchCondition, searchType);
    }
    */
}
