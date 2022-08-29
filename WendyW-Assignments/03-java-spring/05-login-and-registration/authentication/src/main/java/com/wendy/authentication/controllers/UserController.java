package com.wendy.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wendy.authentication.models.User;
import com.wendy.authentication.services.UserService;
import com.wendy.authentication.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	UserService uService;
	
	@Autowired
	UserValidator validator;
	
	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registration.jsp";
	}
	
	@RequestMapping("/login")
	public String loginUser(@ModelAttribute("email") String email, @ModelAttribute("password") String passWord) {
		return "login.jsp";
	}
	
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		validator.validate(user, result);
		
		if(result.hasErrors()) {
			return "registration.jsp";
	}
	
	User newUser = this.uService.registerUser(user);
	session.setAttribute("userId" , newUser.getId());
	return "redirect:/dashboard";
		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAtts, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAtts.addFlashAttribute("loginError", "Invalid Credentials!");
			return "redirect:/";
		}
		
		User user = uService.findByEmail(email);
		session.setAttribute("user", user.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		if(session.getAttribute("user") == (null)) {
			return "redirect:/";
		}
		
		Long userId = (Long)session.getAttribute("user");
		User user = uService.findUserById(userId);
		model.addAttribute("user", user);
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}