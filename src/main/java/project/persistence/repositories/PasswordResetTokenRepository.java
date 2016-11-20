package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
	PasswordResetToken save(PasswordResetToken passwordResetToken);
	PasswordResetToken findByToken(String token);
	
}
