package project.service;

import java.util.List;

import project.persistence.entities.Recipe;


public interface SearchService {
	
	/**
	 * Finds all recipes according to specific search conditions.
	 * @param the search condition to specify what to search by
	 * @param the search itself
	 * @return list of recipes following the search if it exists, else empty list
	 */
	List<Recipe> findAllWithCond(String searchcond, String search);
		
   
}
