package com.cschoolproject.InvestmentPanel2.Controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;


@Controller
public class HomeController {

	private UserRepository userRepo;

	@Autowired
	public HomeController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

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
		Iterable<User> allUsers = userRepo.findAll();
		model.addAttribute("allUsers", allUsers);
		return "showAll";
	}

	@GetMapping("/login")
	public String toLogin() {
		return "login";
	}

	@GetMapping("/registration")
	public String toRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registrerUser(@ModelAttribute User user) {
		userRepo.save(user);
		return "redirect:/";
	}

	@GetMapping("/userPanel")
	public String toUserPanel() {
		return "userPanel";
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user) {
		userRepo.save(user);
		System.err.println(user);
		return "redirect:/";
	}

	@GetMapping("/loginform")
	public String toLoginForm() {
		return "loginform";
	}
//	
//		
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
}

