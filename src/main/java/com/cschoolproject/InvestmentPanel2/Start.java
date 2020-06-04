package com.cschoolproject.InvestmentPanel2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cschoolproject.InvestmentPanel2.Entity.Property;
import com.cschoolproject.InvestmentPanel2.Entity.PropertyRepository;
import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;
import com.cschoolproject.InvestmentPanel2.Entity.UserRole;
import com.cschoolproject.InvestmentPanel2.Entity.UserRoleRepository;
import com.cschoolproject.InvestmentPanel2.Security.SecurityConfiguration;
import com.cschoolproject.InvestmentPanel2.Service.UserService;

@Component
public class Start {
	
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	private PropertyRepository propertyRepository;
	private static final String DEFAULT_ROLE = "ROLE_USER";
	
	private UserService userService;
	
	@Autowired
	public Start(UserRepository userRepository,  UserRoleRepository userRoleRepo, PropertyRepository propertyRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepo;
		this.propertyRepository = propertyRepository;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runExample() {
		
//		userRoleRepository.save(new UserRole("ROLE_USER"));		
		
		
		User user1 = new User("a.nowak@wp.pl", "annna1");//, TypeOfUser.REGULAR);
		UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
//		System.out.println(defaultRole);
		user1.getRoles().add(defaultRole);
//		System.out.println(defaultRole);
//		System.out.println(user1);
		userRepository.save(user1);
		
//		userService.addWithDefaultRole(user1);
		userRepository.save(new User("a.kot@wp.pl", "ala11"));//, TypeOfUser.ADMIN));

		userRepository.save(new User("e.plot@wp.pl", "ela2"));//, TypeOfUser.ADMIN));
		userRepository.save(new User("u.ckowal@wp.pl", "ulalala"));//, TypeOfUser.REGULAR));
		userRepository.save(new User("h.bakus@wp.pl", "helazwesela"));//, TypeOfUser.REGULAR));
		
		propertyRepository.save(new Property( "abc", "gfh", "fgh", "dgfhgjh", 2, 3, 2014, 50.0F, 250000, 5000));
		
		
		
		
//		userRepo.deleteById(4L);
//		Iterable<User> all = userRepo.findAllByType(TypeOfUser.ADMIN);
//		all.forEach(System.out::println);
		
		for(User user : userRepository.findAll()) {
			System.out.println(user);	
		}
		

	}
}
