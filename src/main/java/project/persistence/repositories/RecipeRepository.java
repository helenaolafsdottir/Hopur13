package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Recipe;
import project.persistence.entities.User;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe save(Recipe recipe);
    
    void delete(Recipe recipe);
    
    List<Recipe> findAll();
    
    Recipe findOne(Long id);
    
    Recipe findByRecipeName(String recipeName);
    Recipe findById(Long id);
    
   // List<Recipe> findByIngredientsAndRecipeName(String ingredients, String recipeName);
	
}
