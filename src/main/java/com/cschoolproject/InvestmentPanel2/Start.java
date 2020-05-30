package com.cschoolproject.InvestmentPanel2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;
import com.cschoolproject.InvestmentPanel2.Entity.UserRole;
import com.cschoolproject.InvestmentPanel2.Entity.UserRoleRepository;
import com.cschoolproject.InvestmentPanel2.Security.SecurityConfiguration;

@Component
public class Start {
	
	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	public Start(UserRepository userRepository,  UserRoleRepository userRoleRepo) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepo;
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runExample() {
		
		userRoleRepository.save(new UserRole("ROLE_USER"));		
		
		
		User user1 = new User("a.nowak@wp.pl", "annna1");//, TypeOfUser.REGULAR);
		userRepository.save(user1);
		userRepository.save(new User("a.kot@wp.pl", "ala11"));//, TypeOfUser.ADMIN));

		userRepository.save(new User("e.plot@wp.pl", "ela2"));//, TypeOfUser.ADMIN));
		userRepository.save(new User("u.ckowal@wp.pl", "ulalala"));//, TypeOfUser.REGULAR));
		userRepository.save(new User("h.bakus@wp.pl", "helazwesela"));//, TypeOfUser.REGULAR));
		
		
		
		
		
		
//		userRepo.deleteById(4L);
//		Iterable<User> all = userRepo.findAllByType(TypeOfUser.ADMIN);
//		all.forEach(System.out::println);
		

	}
}
