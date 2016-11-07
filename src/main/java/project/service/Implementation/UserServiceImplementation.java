package project.service.Implementation;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.User;
import project.persistence.entities.UserRole;
import project.persistence.repositories.UserRepository;
import project.persistence.repositories.UserRolesRepository;
import project.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	UserRepository repository;
	UserRolesRepository userRolesRepository;
	
	@Autowired
	public UserServiceImplementation(UserRepository repository, UserRolesRepository userRolesRepository){
		this.repository = repository;
		this.userRolesRepository = userRolesRepository;
	}
	
	@Override
	public User save(User user){
		return repository.save(user);
	}
	
	@Override
	public void delete(User user){
		repository.delete(user);
	}
	
	@Override
	public List<User> findAll(){
		return repository.findAll();
	}
	
	/**
	 * This method finds all the users and returns them in reverse order
	 * @return list of users in reverse order
	 */
	@Override
	public List<User> findAllReverseOrder(){
		List<User> users = repository.findAll();
		
		//Reverse the list
		Collections.reverse(users);
		return users;
	}
	
	@Override
	public User findOne(Long id){
		return repository.findOne(id);
	}
	
	@Override
	public List<User> findByName(String name){
		return repository.findByName(name);
	}
	
	/**
	 * This method saves the userRole
	 * @param the userRole to be saved
	 * @return the specific UserRole that was saved
	 */
	@Override
	public UserRole save(UserRole userRole){
		return userRolesRepository.save(userRole);
	}
}
