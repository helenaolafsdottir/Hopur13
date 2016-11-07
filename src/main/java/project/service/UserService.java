package project.service;

import java.util.List;

import project.persistence.entities.User;
import project.persistence.entities.UserRole;

public interface UserService {
	/**
	 * Saves a user into the database
	 * @param user is the user that is saved
	 * @return the saved user with database id
	 */
	User save(User user);
	
	/**
	 * Deletes a user from the database
	 * @param user is the user that is deleted
	 */
	void delete(User user);
	
	/**
	 * Finds all users in the db
	 * @return list of users
	 */
	List<User> findAll();
	
	/**
	 * This method finds all the users and returns them in reverse order
	 * @return list of users in reverse order
	 */
	List<User> findAllReverseOrder();
	
	/**
	 * Finds the user with a specific id
	 * @param the specific id
	 * @return user with the id if it exists, else null
	 */
	User findOne(Long id);
	
	/**
	 * Finds all users with a specific name
	 * @param the specific name
	 * @return list of users with the name if it exists, else empty list
	 */
	List<User> findByName(String name);
	
	/**
	 * This method saves the userRole
	 * @param the userRole to be saved
	 * @return the specific UserRole that was saved
	 */
	UserRole save(UserRole userRole);
	
}