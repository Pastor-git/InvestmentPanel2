package com.cschoolproject.InvestmentPanel2.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cschoolproject.InvestmentPanel2.Entity.Property;
import com.cschoolproject.InvestmentPanel2.Entity.PropertyRepository;
import com.cschoolproject.InvestmentPanel2.Entity.User;
import com.cschoolproject.InvestmentPanel2.Entity.UserRepository;
import com.cschoolproject.InvestmentPanel2.Service.PropertyService;
import com.cschoolproject.InvestmentPanel2.Service.UserService;

@Controller
public class PropertyController {

	private PropertyService propertyService;
	private PropertyRepository propertyRepository;
	private UserRepository userRepository;

	@Autowired
	public PropertyController(PropertyRepository propertyRepository, UserRepository userRepository) {
		this.propertyRepository = propertyRepository;
		this.userRepository = userRepository;
	}

	@Autowired
	public void setPropertyService(PropertyService propertyService) {
		this.propertyService = propertyService;
	}

	@GetMapping("/propertyForm")
	public String toRegistration(Model model) {
		model.addAttribute("property", new Property());
		return "propertyForm";
	}

	@PostMapping("/addProperty")
	public String addProperty(@ModelAttribute() Property property, BindingResult bindResult) {

		if (bindResult.hasErrors()) {
			return "addProperty";
		} else {

			System.err.println(property);
			propertyService.addProperty(property);
			return "redirect:raport";
		}

//		propertyRepository.save(property);
//		
	}

	@RequestMapping("/deleteProperty")
	public String deleteProperty(@ModelAttribute(value = "delProp") Property property, BindingResult bindResult) {

		if (bindResult.hasErrors()) {
			return "deleteProperty";
		} else {

			System.err.println(property);
			System.out.println("Jestem w mappingu");
			System.out.println(property.toString());
			propertyService.deleteProperty(property);
			return "redirect:raport";
		}
	}
	
	@RequestMapping("/deleteProperty2")
	public String deleteProperty2(@ModelAttribute(value = "property") Property property, BindingResult bindResult) {
		System.out.println("Jestem w Delete PROPERTY service");
		if (bindResult.hasErrors()) {
			return "deleteProperty";
		} else {

			System.err.println(property);
			System.out.println("Jestem w mappingu");
			propertyService.deleteProperty(property);
			return "redirect:raport";
		}
	}
	
//	@GetMapping("/usun")
//	public String usun() {
//		User user=userRepository.findOneById(6L);
//		userRepository.delete(user);
//		Iterable<Property> properties =user.getProperties();
//		propertyRepository.deleteAll(properties);
////		for(Property prop : properties) {
////			propertyRepository.delete(prop);
////		}
//		System.out.println(properties);
//		//propertyRepository.deleteAll(properties);
//		userRepository.delete(user);
//		return "raport";
//	}

}
