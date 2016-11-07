package project.service;

import java.util.List;

import project.persistence.entities.Recipe;

public interface RecipeService {
	/**
	 * Save a {@link Recipe}
	 * @param recipe {@link Recipe} to be saved
	 * @return {@link Recipe} that was saved
	 */
	Recipe save(Recipe recipe);
	
	/**
	 * delete {@link Recipe}
	 * @param recipe {@link Recipe} to be deleted
	 */
	void delete(Recipe recipe);
	
	/**
	 * find all recipes from db
	 * @return A list of {@link Recipe}s
	 */
	List<Recipe> findAll();
	
	/**
	 * Get all {@link Recipe}s in a reverse order
	 * @return A list of {@link Recipe}s
	 */
	List<Recipe> findAllReverseOrder();
	
	/**
	 * Find all {@link Recipe}s with {@link String recipeName}
	 * @param recipeName {@link String}
	 * @return All {@link Recipe}s with the {@link String recipeName} passed
	 */
	Recipe findByRecipeName(String recipeName);
	
	/**
	 * Find all {@link Recipe}s with {@link Long id}
	 * @param id {@link Long}
	 * @return All {@link Recipe}s with the {@link Long id} passed
	 */
	Recipe findById(Long id);
	
	/**
	 * Find all {@link Recipe}s with {@link Long id}
	 * @param id {@link Long}
	 * @return All {@link Recipe}s with the {@link Long id} passed
	 */
	Recipe findOne(Long id);
	
	/**
     * Find all {@link Recipe}s with {@link String search}
     * @param search {@link String}
     * @return All {@link Recipe}s with the {@link String search} passed
     */
	List<Recipe> findByUsername(String search);
	
	/**
     * Find top 6 {@link Recipe}s order by counter value
     * @return A list of the top 6 {@link Recipe}s ordered by counter value
     */
	List<Recipe> findTop6ByOrderByCounterDesc();
}
