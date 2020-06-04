package com.cschoolproject.InvestmentPanel2.Service;

import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.cschoolproject.InvestmentPanel2.Entity.Property;
import com.cschoolproject.InvestmentPanel2.Entity.PropertyRepository;
import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;
import com.cschoolproject.InvestmentPanel2.Entity.UserRoleRepository;

@Service
public class PropertyService {
	
	private UserRepository userRepository;
	private PropertyRepository propertyRepository;
	
	@Autowired
	public PropertyService(UserRepository userRepository, PropertyRepository propertyRepository) {
		this.userRepository = userRepository;
		this.propertyRepository = propertyRepository;

	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setPropertyRepository(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
	}
	
	public void addProperty(Property property) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
//        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            User user = userRepository.findByEmailAddress(username);
        System.out.println(username);
        System.out.println("Jestem w ADD PROPERTY");
        System.out.println(user);

//    } 
//        else 
//    {
//        String username = principal.toString();
//        System.out.println(username);
//    
		//property.setOwner(user.getId());
        user.getProperties().add(property);
		propertyRepository.save(property);
	}
	
//	public void removeProperty(Property property) {
//		
//		System.out.println(property.getName());
//		//propertyRepository.delete(property);
//		System.out.println("     USUNIETO NIERUCHOMOSC     ");
//	}

}
