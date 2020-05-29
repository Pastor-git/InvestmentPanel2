package com.cschoolproject.InvestmentPanel2.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_role")
public class UserRole {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "role_id", nullable = false)
	private Long id;
	
//	@Column(name = "role", nullable = false)
//	private String role;
//	
//	
//
//	public UserRole() {
//		super();
//	}
//
//	public UserRole(String role) {
//		super();
//		this.role = role;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}
//
//	@Override
//	public String toString() {
//		return "UserRole [id=" + id + ", role=" + role + "]";
//	}
//	
	
	
	
}

