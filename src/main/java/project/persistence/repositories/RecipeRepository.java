package project.persistence.repositories;

import java.util.List;

import project.persistence.entities.Recipe;

public interface RecipeRepository {

    Recipe save(Recipe recipe);
    void delete(Recipe recipe);
    
    List<Recipe> findAll();
    
    Recipe findOne(Long id);
    
    List<Recipe> findBySearchconditionAndSearchtype(String searchcondition, String searchtype);
	
}
