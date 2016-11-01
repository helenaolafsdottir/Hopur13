package project.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Recipe;
import project.persistence.entities.User;
import project.persistence.repositories.RecipeRepository;


public interface SearchService {

	/**
	 * Vistar notandann í grunni
	 * @param user
	 * @return
	 */
	Recipe save(Recipe recipe);
	
	void delete(Recipe recipe);
	
	List<Recipe> findAll();
	
	List<Recipe> findAllReverseOrder();
	
	Recipe findOne(Long id);
	
	//List<Recipe> findBySearchconditionAndSearchtype(String searchCondition, String searchType);
	
   
}
