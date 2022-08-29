package com.wendy.dogs.controllers;

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

import com.wendy.dogs.models.Toy;
import com.wendy.dogs.services.DogService;
import com.wendy.dogs.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService tService;
	@Autowired
	private DogService dService;
	
	@GetMapping("/new")
	public String newToy(Model viewModel, @ModelAttribute("toy") Toy toy) {
		viewModel.addAttribute("allDogs", this.dService.getAllDogs());
		return "toys/new.jsp";
	}
	
	@PostMapping("/newToy")
	public String createToy(@Valid @ModelAttribute("toy") Toy toy, BindingResult result, Model viewModel) {
		Long dogId = toy.getDog().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("allDogs", this.dService.getAllDogs());
			return "toys/new.jsp";
		}
		this.tService.createToy(toy);
		return "redirect:/show/" + dogId;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteToy(@PathVariable("id") Long id) {
		this.tService.deleteToy(id);
		return "redirect:/";
	}
}