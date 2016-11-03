package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.PostitNote;
import project.persistence.entities.Recipe;
import project.persistence.entities.User;

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
    
    //Custom queries
   // @Query("INSERT INTO recipes(id, image, ingredients, instructions, recipe_group, recipe_name, username) VALUES (1L, 'http://cdn.skim.gs/image/upload/v1456339212/msi/dog-6_wh8l7p.jpg','sykur, hveiti, mjólk','just do it','kaka','Rjómaterta','Helena')")
    //Recipe insertFirstRecipe();
   
    
    //@Query(value = "SELECT p FROM PostitNote p where length(p.name) >= 3 ")
    //List<PostitNote> findAllWithNameLongerThan3Chars();
}
