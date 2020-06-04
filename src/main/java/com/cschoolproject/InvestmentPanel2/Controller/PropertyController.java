package com.cschoolproject.InvestmentPanel2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

	
	@Autowired
	public PropertyController(PropertyRepository propertyRepository) {
		this.propertyRepository = propertyRepository;
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
		
		if(bindResult.hasErrors()) {
			return "addProperty";
		}
		else {

			System.err.println(property);
			propertyService.addProperty(property);
			return "redirect:raport";
		}
		
//		propertyRepository.save(property);
//		
	}
	
	@GetMapping("/removeProperty")
	public String removeProperty(@ModelAttribute() Property property, BindingResult bindResult) {
		
		if(bindResult.hasErrors()) {
			return "removeProperty";
		}
		else {

			System.err.println(property);
//			propertyService.removeProperty(property);
			return "redirect:raport";
		}
	}
	


}
