package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.User;
/**
 * This interface accesses the user database tables. 
 * @author sandragunnarsdottir
 *
 */
public interface UserRepository extends JpaRepository<User, Long>{
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
	 * Finds a user by a specific username
	 * @param the specific username
	 * @return user with the username if it exists, else null
	 */
	User findByUserName(String username);
}
