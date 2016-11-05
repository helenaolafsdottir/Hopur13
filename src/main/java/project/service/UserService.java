package project.service;

import java.util.List;

import project.persistence.entities.User;
import project.persistence.entities.UserRole;

public interface UserService {
	/**
	 * Vistar notandann í grunni
	 * @param user
	 * @return
	 */
	User save(User user);
	
	void delete(User user);
	
	List<User> findAll();
	
	List<User> findAllReverseOrder();
	
	User findOne(Long id);
	
	List<User> findByName(String name);
	
	UserRole save(UserRole userRole);
	
}