package com.wendy.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wendy.driverslicense.models.Person;
import com.wendy.driverslicense.services.PersonService;

@Controller
public class PersonController {
	@Autowired
	private PersonService pService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allPerson",this.pService.getAllPerson());
		return "index.jsp";
	}
	
	@RequestMapping("/person/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "new_person.jsp";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String processPerson(@Valid @ModelAttribute("person") Person person, BindingResult result){
		if(result.hasErrors()) {
			return "new_person.jsp";
		}
		this.pService.createPerson(person);
		return "redirect:/";
	}
	
	@RequestMapping("/people/{id}")
	public String findById(Model model, @PathVariable("id") Long id) {
		Person getOnePerson = this.pService.getOnePerson(id);
		model.addAttribute("person", getOnePerson);
		return "show_person.jsp";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("person", this.pService.getOnePerson(id));
		return "edit_person.jsp";
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public String editPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("person", this.pService.getOnePerson(id));
			return "edit_person.jsp";
		}
		this.pService.editPerson(person);
		return "show_person.jsp";
	}
	
	@RequestMapping("/delete/{id}")
	public String deletePerson(@PathVariable("id") Long id) {
		this.pService.deletePerson(id);
		return "redirect:/";
	}

}
