package com.wendy.dogs.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wendy.dogs.models.Dog;
import com.wendy.dogs.models.Tag;
import com.wendy.dogs.services.DogService;
import com.wendy.dogs.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	
	@GetMapping("/")
	public String dashboard(Model viewModel) {
		viewModel.addAttribute("allDogs", this.dService.getAllDogs());
		return "dashboard.jsp";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag) {
		Dog dogToShow = this.dService.getSingleDog(id);
		viewModel.addAttribute("dog", dogToShow);
		return "show.jsp";
	}
	
	@PostMapping("/tag/{id}")
	public String addTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		Dog dogToShow = this.dService.getSingleDog(id);
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", dogToShow);
			return "show.jsp";
		}
		tag.setDog(dogToShow);
		this.tService.createTag(tag);
		return "redirect:/show/{id}";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("dog", this.dService.getSingleDog(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String editDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(id));
			return "edit.jsp";
		}
		this.dService.updateDog(dog);
		return "redirect:/show/{id}";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("dog") Dog dog) {
		return "new.jsp";
	}
	
	@PostMapping("/add")
	public String addDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.dService.createDog(dog);
		return "redirect:/";
	}
	
	@PostMapping("/htmlway")
	public String addDogHTML(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey there, dont forget to add a name");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.dService.createDogTwo(name, breed, age);
		return "redirect:/";
	}
}