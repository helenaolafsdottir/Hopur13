package project.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Recipe;
import project.persistence.repositories.RecipeRepository;

@Service
public class SearchService {

	
    // Instance Variables
    RecipeRepository repository;
    
    // Dependency Injection
    @Autowired
    public SearchService(RecipeRepository repository) {
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

    public List<Recipe> findBySearchconditionAndSearchtype(String searchCondition, String searchType) {
        return repository.findBySearchconditionAndSearchtype(searchCondition, searchType);
    }
}
