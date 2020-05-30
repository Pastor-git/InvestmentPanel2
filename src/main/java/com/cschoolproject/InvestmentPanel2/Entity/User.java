package com.cschoolproject.InvestmentPanel2.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Users")
public class User {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "user_id", nullable = false)
	private Long id;
	
	@NotNull
	@Column(name = "email_address", unique = true, nullable = false)
	private String emailAddress;
	
	@NotNull
	@Column(name = "password", nullable = false)
	private String password;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<UserRole> roles = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Property> properties = new HashSet<>();

	
	public User(String emailAddress, String password, Set<UserRole> roles) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.roles = roles;
	}

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

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Set<Property> getProperties() {
		return properties;
	}

	public void setProperties(Set<Property> properties) {
		this.properties = properties;
	}

	
	
	

}

