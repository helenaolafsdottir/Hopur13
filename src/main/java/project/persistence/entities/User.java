package project.persistence.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "userInformation")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String password;
	private String name;
	private String email;
	private Date createDate;
	
//	public User(String userName, String password, String name, String email){
//		this.userName = userName;
//		this.password = password;
//		this.name = name;
//		this.email = email;
//	}
	
	public User(){
		
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long newId) {
		this.id = newId;
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public void setUserName(String newUserName) {
		this.userName = newUserName;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public Date getCreateDate(){
		return this.createDate;
	}
	
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	
}