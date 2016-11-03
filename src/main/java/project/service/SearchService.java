package project.service;

import java.util.List;

import project.persistence.entities.Recipe;


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

	List<Recipe> findAllWithCond(String searchcond, String search);
	
	//List<Recipe> findBySearchconditionAndSearchtype(String searchCondition, String searchType);
	
   
}
