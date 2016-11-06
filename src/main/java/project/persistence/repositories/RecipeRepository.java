package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	
    Recipe save(Recipe recipe);
    
    void delete(Recipe recipe);
    
    List<Recipe> findByUsername(String search);
    List<Recipe> findByRecipeNameContaining(String search);
    List<Recipe> findByIngredientsContaining(String search);
    List<Recipe> findAll();
    
    Recipe findOne(Long id);
    
    Recipe findByRecipeName(String recipeName);
    Recipe findById(Long id);
    
    List<Recipe> findTop6ByOrderByCounterDesc();
}
