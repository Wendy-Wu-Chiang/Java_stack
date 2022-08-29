package com.wendy.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wendy.dojosandninjas.models.Dojo;
import com.wendy.dojosandninjas.models.Ninja;
import com.wendy.dojosandninjas.services.DojoService;
import com.wendy.dojosandninjas.services.NinjaService;

public class DojoController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/new/dojo")
		public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/create/dojo")
		public String newD(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		}else {
			this.dojoService.createDojo(dojo);
			System.out.println(dojo.getName() + " dojo has been added");
			return "redirect:/new/ninja";
			
		}
	}
	@GetMapping("/new/ninja")
		public String newNinja( @ModelAttribute("ninja") Ninja ninja, @Valid BindingResult result, Model model) {
		List<Dojo> allDojos = dojoService.getAll();
		model.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}
	@PostMapping("/add/ninja")
	public String addNinja(@ModelAttribute("ninja") Ninja ninja, @ModelAttribute("dojo") Dojo dojo) {
		
		this.ninjaService.createNinja(ninja);
		return "redirect:/show/dojo/" + dojo.getId();
	}
	@GetMapping("/show/dojo/{id}")
		public String newNinjas(@PathVariable("id") Long id, Model model) {
		List<Dojo> dojos = dojoService.getAll();
		
		Dojo dojo = dojoService.getSingleDojo(id);
		List<Ninja> ninja = dojo.getNinja();
		model.addAttribute("allDojos", dojos);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninja);
		
		return "dojo.jsp";
	}
//	@PostMapping("show/dojo/{id}") //Add option to view different dojos
//	public String changeDojo(@PathVariable("id") BindingResult result, Long id, Model model) {
//			List<Dojo> dojos = dojoService.getAll();
//			Dojo dojo = dojoService.getSingleDojo(id);
//			List<Ninja> ninja = dojo.getNinja();
//			model.addAttribute("allDojos", dojos);
//			model.addAttribute("dojo", dojo);
//			model.addAttribute("ninjas", ninja);
//			
//			return "redirect:/show/dojo/" + dojo.getId();
//	}
	
//	@GetMapping("/delete/ninja/{id}") //Delete ninja
//	public String deleteNinja(@PathVariable("id") @ModelAttribute("ninja") Long id, Ninja ninja, Dojo dojo){
//		this.ninjaService.deleteById(id);
//		System.out.println(ninja.getFirstName() + " has been removed from this dojo");
//		
//		return "redirect:/show/dojo/" + dojo.getId();
//	}
}