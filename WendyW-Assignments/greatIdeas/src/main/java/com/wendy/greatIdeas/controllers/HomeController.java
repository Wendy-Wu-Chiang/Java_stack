package com.wendy.greatIdeas.controllers;


import javax.servlet.http.HttpSession;
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

import com.wendy.greatIdeas.models.Idea;
import com.wendy.greatIdeas.models.User;
import com.wendy.greatIdeas.services.IdeaService;
import com.wendy.greatIdeas.services.UserService;
import com.wendy.greatIdeas.validators.UserValidator;

@Controller
public class HomeController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private IdeaService iService;
	
	@Autowired
	private UserValidator uValidator;
	
	@GetMapping("/")
	public String register(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		this.uValidator.validate(user, result);
		
		if(result.hasErrors()) {
			return "registration.jsp";
		}
		User newUser = this.uService.registration(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/ideas";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, 
			RedirectAttributes reAtts, Model model, HttpSession session) {
		
		if(!this.uService.authenticateUser(email, password)) {
			reAtts.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uService.findByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/ideas";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/ideas")
	public String dashboard(@ModelAttribute("idea") Idea idea,HttpSession session, Model viewModel) {
		Long userId = (Long) session.getAttribute("user_id");
		User thisUser = this.uService.getOneUser(userId);
		if(userId == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("allUsers",this.uService.getAllUsers());
		viewModel.addAttribute("allIdeas", this.iService.getAllIdeas());
		viewModel.addAttribute("user", thisUser);
		viewModel.addAttribute("idea",idea);
//		viewModel.addAttribute("thisUser", this.uService.getOneUser(userId));
		return "dashboard.jsp";
	}
	
	@GetMapping("/ideas/new")
	public String add(@ModelAttribute("idea") Idea idea,HttpSession session, Model viewModel) {
		Long userId = (Long) session.getAttribute("user_id");
		User thisUser = this.uService.getOneUser(userId);
		if(userId == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", thisUser);
		return "new.jsp";
	}
	
	@PostMapping("/ideas/newIdea")
	public String addIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session,@ModelAttribute("user") User user) {
		Long userId = (Long) session.getAttribute("user_id");
		User thisUser = this.uService.getOneUser(userId);
		if(result.hasErrors()) {
			return "new.jsp";
		}	
		Idea newIdea = this.iService.createIdea(idea);
		newIdea.setUser(thisUser);
		return "redirect:/ideas";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Idea ideaThatsLiked = this.iService.getOneIdea(id);
		User personWhoLiked = this.uService.getOneUser((Long)session.getAttribute("user_id"));
		this.uService.likeIdea(personWhoLiked, ideaThatsLiked);
		return "redirect:/ideas";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Idea ideaThatsLiked = this.iService.getOneIdea(id);
		User personWhoLiked = this.uService.getOneUser((Long)session.getAttribute("user_id"));
		this.uService.unlikeIdea(personWhoLiked, ideaThatsLiked);
		return "redirect:/ideas";
	}
	
	@GetMapping("/ideas/{id}")
	public String showIdea( @ModelAttribute("idea") Idea idea, @PathVariable("id") Long id, HttpSession session, Model viewModel) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.getOneUser(userId);
		Idea thisIdea = this.iService.getOneIdea(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("idea",thisIdea);
		return "show.jsp";
	}

	@GetMapping("/ideas/{id}/edit")
	public String edit(@ModelAttribute("idea") Idea idea, @PathVariable("id") Long id, Model viewModel, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		Idea thisIdea = this.iService.getOneIdea(id);
		System.out.println(userId);
		System.out.println(thisIdea);
		
		if(userId.equals(thisIdea.getUser().getId())){
			
		
			User user = this.uService.getOneUser(userId);
			viewModel.addAttribute("idea", thisIdea);
			viewModel.addAttribute("user", user);
			return "edit.jsp";
		}
		return "redirect:/ideas";
		
	}
	
	@PostMapping("/ideas/{id}/edit")
	public String editIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @PathVariable("id") Long id, Model viewModel, HttpSession  session) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.getOneUser(userId);
		Idea thisIdea = this.iService.getOneIdea(id);
		if(result.hasErrors()) {
			viewModel.addAttribute("updateEvent", this.iService.getOneIdea(id));
			return "edit.jsp";
		}
		
		viewModel.addAttribute("user", user);
		viewModel.addAttribute("idea", thisIdea);
		idea.getUser();
		this.iService.updateIdea(thisIdea);
		return "redirect:/ideas";
		
	}
	
	
}
