package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {

	// Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
    public String recipeName;
    public String recipeGroup;
    public String ingredients;
    public String username;
    public String instructions;
    public String image;
    public int counter;
    

    // Notice the empty constructor, because we need to be able to create an empty PostitNote to add
    // to our model so we can use it with our form
    public Recipe() {
    }
/*
    public Recipe(String recipeName, String recipeGroup, String ingredients, String username, String instructions, String image) {
        this.recipeName = recipeName;
        this.recipeGroup = recipeGroup;
        this.ingredients = ingredients;
        this.username = username;
        this.instructions = instructions;
        this.image = image	;
    }
   */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeGroup() {
        return recipeGroup;
    }

    public void setRecipeGroup(String recipeGroup) {
        this.recipeGroup = recipeGroup;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public int getCounter() {
        return counter;
    }

    public void setImage(int counter) {
        this.counter = counter;
    }
    
  
}
