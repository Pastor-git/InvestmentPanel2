package com.cschoolproject.InvestmentPanel2.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;
import com.cschoolproject.InvestmentPanel2.Entity.UserRole;
import com.cschoolproject.InvestmentPanel2.Entity.UserRoleRepository;

@Service
public class UserService {
	
	private static final String DEFAULT_ROLE = "ROLE_USER";
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	//private PasswordEncoder passwordEncoder;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
//	@Autowired
//	public UserService(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
		this.userRoleRepository = userRoleRepository;
	}
	
	public void addWithDefaultRole(User user) {
		
		UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
		user.getRoles().add(defaultRole);
		String passwordHash = passwordEncoder.encode(user.getPassword());
		user.setPassword(passwordHash);
		userRepository.save(user);
	}
	
}
