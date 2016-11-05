package project.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles")
public class UserRole {
	@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="user_role_id")
	private Long userroleid;
	
	@Column(name="userid")
	private Long userid;
	
	@Column(name="role")
	private String role;
	
	public UserRole(Long userid, String role){
		this.userid = userid;
		this.role = role;
	}
	
	public UserRole(){
		
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role){
		this.role = role;
	}
	
	public Long getUserId(){
		return userid;
	}
	
	public void setUserid(Long userid){
		this.userid = userid;
	}
	
	public Long getUserroleid(){
		return userid;
	}
	
	public void setUserroleid(Long userroleid){
		this.userroleid = userroleid;
	}
	
}
