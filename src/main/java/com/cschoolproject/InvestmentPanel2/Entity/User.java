package com.cschoolproject.InvestmentPanel2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "user_id", nullable = false)
	private Long id;
	
	@Column(name = "email_address", unique = true, nullable = false)
	private String emailAddress;
	
	@Column(name = "password", nullable = false)
	private String password;
//	
//	@Column(name = "user_type", nullable = false)
//	private TypeOfUser type;

	public User(String emailAddress, String password) { //, TypeOfUser type) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		//this.type = type;
	}

	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public TypeOfUser getType() {
//		return type;
//	}
//
//	public void setType(TypeOfUser type) {
//		this.type = type;
//	}
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", emailAddress=" + emailAddress + ", password=" + password + ", type=" + type + "]";
//	}
	
	

}

