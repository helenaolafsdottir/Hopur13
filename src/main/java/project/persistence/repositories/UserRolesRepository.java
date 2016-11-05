package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.UserRole;

public interface UserRolesRepository extends JpaRepository<UserRole, Long>{
	@Query("select a.role from UserRole a, User b where b.userName=?1 and a.userid=b.id")
	public List<String> findRoleByUserName(String username);
	public UserRole save(UserRole userRole);
}
