package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.User;
// Save,delete,findAll,findOne og findByName eru allt
// aðferðir sem koma úr JpaRepository
public interface UserRepository extends JpaRepository<User, Long>{
	User save(User user);
	
	void delete(User user);
	
	List<User> findAll();
	
	
	User findOne(Long id);
	
	List<User> findByName(String name);
}
