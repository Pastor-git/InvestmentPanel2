package com.cschoolproject.InvestmentPanel2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/registration")
	public String toRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute()  User user, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "registration";
		}
		else {
			userService.addWithDefaultRole(user);
			return "redirect:registerSuccess";
//			userRepo.save(user);
//			System.err.println(user);
//			return "redirect:registerSuccess";
		}

	}

}
