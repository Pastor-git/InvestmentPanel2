package com.cschoolproject.InvestmentPanel2.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cschoolproject.InvestmentPanel2.Entity.Property;
import com.cschoolproject.InvestmentPanel2.Entity.PropertyRepository;
import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;


@Controller
public class HomeController {

	private UserRepository userRepository;
	private PropertyRepository propertyRepository;
	
	@Autowired
	public HomeController(UserRepository userRepository, PropertyRepository propertyRepository) {
		this.userRepository = userRepository;
		this.propertyRepository = propertyRepository;
	}
	
	
	
//	@Autowired
//	public HomeController(PropertyRepository propertyRepository) {
//		this.propertyRepository = propertyRepository;
//	}

	@GetMapping("/")
	public String toIndex() {

		return "index";
	}

	@GetMapping("/home")
	public String toHome() {
		return "home";
	}

	@GetMapping("/kontakt")
	public String toKontakt(Model model) {
		Iterable<User> allUsers = userRepository.findAll();
		model.addAttribute("allUsers", allUsers);
		return "showAll";
	}

	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}

	

//	@PostMapping("/registration")
//	public String registrerUser(@ModelAttribute User user) {
//		userRepo.save(user);
//		return "redirect:/";
//	}

	@GetMapping("/userPanel")
	public String toUserPanel(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
            User user = userRepository.findByEmailAddress(username);
        System.out.println(username);
        System.out.println(user);
        model.addAttribute("user", user);
        Iterable<Property> allUserProperties = propertyRepository.findByOwner(user.getId());
        model.addAttribute("allUserProperties",allUserProperties);

    } 
//        else 
//    {
//        String username = principal.toString();
//        System.out.println(username);
//    }
  
		return "userPanel";
	}


	@GetMapping("/loginform")
	public String toLoginForm() {
		return "loginform";
	}
	
	@GetMapping("/registerSuccess")
	public String toRegisterSuccess() {
		return "registerSuccess";
	}
	
	@GetMapping("/logout")
	public String toLogoutSuccess(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	
	@GetMapping("/logoutSuccess")
	public String toLogoutSuccess() {
		return "LogoutSuccess";
	}

//	@GetMapping("/show")
//	public String showAll(Model model) {
//		List<User> allUsers = (List<User>) userRepo.findAll();
//		model.addAttribute("allUsers", allUsers);
//	    return "showall";
//	}
//	
////
////	
////	@GetMapping("/add")
////	public String toAdd() {
////		return "add";
////	}
	

	
	@GetMapping("/raport")
	public String toRaport(Model model) {
		Iterable<Property> allProperties = propertyRepository.findAll();
		model.addAttribute("allProperties", allProperties);
		return "raport";
	}
	
	
	
	

//	@GetMapping("/propertyForm")
//	public String toRegistration(Model model) {
//		model.addAttribute("property", new Property());
//		return "propertyForm";
//	}
}

