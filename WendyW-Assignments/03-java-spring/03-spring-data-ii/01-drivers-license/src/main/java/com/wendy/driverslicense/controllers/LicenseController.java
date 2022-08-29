package com.wendy.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wendy.driverslicense.models.License;
import com.wendy.driverslicense.services.LicenseService;
import com.wendy.driverslicense.services.PersonService;

@Controller
public class LicenseController {
	@Autowired
	private LicenseService lService;
	@Autowired
	private PersonService pService;
	
	
	@RequestMapping("/license/new")
	public String addLicense(@ModelAttribute("license") License license, Model viewModel) {
		viewModel.addAttribute("person",this.pService.getUnlicensedPerson());
		return "new_license.jsp";	
	}
	
	@RequestMapping(value="/newlicense", method=RequestMethod.POST)
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result,  Model viewModel) {
		viewModel.addAttribute("person",this.pService.getUnlicensedPerson());
		if(result.hasErrors()) {
			return "new_license.jsp";
		}
		License newLicense = this.lService.createLicense(license);

		return "redirect:/";
	}
	
}
	