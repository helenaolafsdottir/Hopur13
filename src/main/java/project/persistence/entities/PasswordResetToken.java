package project.persistence.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordResetToken {
	private static final int EXPIRATION = 60*24;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String token;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name="user_id")
	private User user;
	
	private Date expiryDate;
	
	public PasswordResetToken(){
		
	}
	
	public PasswordResetToken(User user, String token){
		this.user = user;
		this.token = token;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//calendar.set(Calendar.MINUTE, this.EXPIRATION);
		calendar.add(Calendar.MINUTE, this.EXPIRATION);
		this.expiryDate = calendar.getTime();
	}

	public User getUser() {
		return this.user;
	}
	
	public Date getExpiryDate(){
		return this.expiryDate;
	}
}
