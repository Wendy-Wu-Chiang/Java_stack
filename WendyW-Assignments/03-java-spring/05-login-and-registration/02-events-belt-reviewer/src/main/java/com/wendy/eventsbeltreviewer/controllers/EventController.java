package com.wendy.eventsbeltreviewer.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.wendy.eventsbeltreviewer.models.Event;
import com.wendy.eventsbeltreviewer.models.Message;
import com.wendy.eventsbeltreviewer.models.User;
import com.wendy.eventsbeltreviewer.services.EventService;
import com.wendy.eventsbeltreviewer.services.MessageService;
import com.wendy.eventsbeltreviewer.services.UserService;
import com.wendy.eventsbeltreviewer.validators.UserValidator;

@Controller
public class EventController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private MessageService mService;
	
	@Autowired
	private EventService eService;
	
	@Autowired
	private UserValidator uVal;
	
	@GetMapping("/")
	public String home(@ModelAttribute("user") User user) {
		return "home.jsp";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		
		this.uVal.validate(user, result);
		
		if(result.hasErrors()) {
			return "home.jsp";
		}
		User newUser = this.uService.registration(user);
		System.out.println(user.getFirstName() + " has been registered as a user.");
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes reAtts, Model model, HttpSession session) {
		
		if(!this.uService.authenticateUser(email, password)) {
			reAtts.addFlashAttribute("error", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uService.findByEmail(email);
		session.setAttribute("user_id", user.getId());
		System.out.println(user.getFirstName() + " has been logged in.");
		return "redirect:/events";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		System.out.println("You have been logged out");
		return "redirect:/";
	}
	
	//user session
	public Long userSessionId(HttpSession session) {
		if(session.getAttribute("userId") == null)
			return null;
		
		return (Long)session.getAttribute("userId");
	}
	
	//format date
	private String now() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	//events
	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		//needed for re-rendering page
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.getOneUser(userId);
		if(userId == null) {
			return "redirect:/";
		}
		
		List<Event> userEvents = this.eService.allEventsWithState(user.getState());
		List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
		model.addAttribute("userEvents", userEvents);
		model.addAttribute("otherEvents", otherEvents);
		model.addAttribute("event", event);
		model.addAttribute("user", user);
		return "events.jsp";
		
	}
	
	@PostMapping("/events/new")
	public String events(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.getOneUser(userId);
		if(user == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			List<Event> userEvents = this.eService.allEventsWithState(user.getState());
			List<Event> otherEvents = this.eService.allEventsNotState(user.getState());
			model.addAttribute("userEvents", userEvents);
			model.addAttribute("otherEvents", otherEvents);
			model.addAttribute("user", user);
			model.addAttribute("eventDate", now());
			return "events.jsp";
		}
		
		event.setHost(user);
		this.eService.createEvent(event);
		return "redirect:/events";
	}
	
	//join event
	@GetMapping("/join/{id}")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event joinedEvent = this.eService.getOneEvent(id);
		User joinedUser = this.uService.getOneUser((Long)session.getAttribute("user_id"));
		System.out.println(joinedEvent);
		this.eService.joinedEvent(joinedUser, joinedEvent);
		return "redirect:/events";
	}
	
	//cancel event
	@GetMapping("/events/cancel/{id}")
	public String cancelEvents(@PathVariable("id") Long id, HttpSession session) {
		Event joinedEvent = this.eService.getOneEvent(id);
		User joinedUser = this.uService.getOneUser((Long)session.getAttribute("user_id"));
		this.eService.cancelEvent(joinedUser, joinedEvent);
		return "redirect:/events";
	}
	
	//delete
	@GetMapping("/events/delete/{id}")
	public String deleteEvents(@PathVariable("id") Long id) {
		this.eService.deleteEvent(id);
		return "redirect:/events";
	}
	
	//update
	@GetMapping("/events/edit/{id}")
	public String events(@ModelAttribute("updateEvent") Event event, @PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		Event thisEvent = this.eService.getOneEvent(id);
		if(userId == null) {
			return "redirect:/";
		}
		
		if(!thisEvent.getHost().getId().equals(userId)) {
			return "redirect:/events";
		}
		
		User user = this.uService.getOneUser(userId);
		model.addAttribute("thisEvent", thisEvent);
		model.addAttribute("user", user);
		return "edit.jsp";
		
	}
	
	@PostMapping("/events/edit/{id}")
	public String editEvents(@Valid @ModelAttribute("udateEvent") Event updatedEvent, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession  session) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.getOneUser(userId);
		Event thisEvent = this.eService.getOneEvent(id);
		if(result.hasErrors()) {
			model.addAttribute("updateEvent", this.eService.getOneEvent(id));
			return "edit.jsp";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("updatedEvent", thisEvent);
		updatedEvent.setHost(user);
		this.eService.updateEvent(updatedEvent);
		return "redirect:/events";
		
	}
	
	//show event
	@GetMapping("/events/{id}")
	public String showEvent(@ModelAttribute("message") Message message, @PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		User user = this.uService.findById(userId);
		Event event = this.eService.getOneEvent(id);
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		
		if(event == null) {
			return "redirect:/events";
		}
		
		model.addAttribute("user", user);
		model.addAttribute("event", event);
		return "show.jsp";
		
	}
	
	@PostMapping("/events/{id}/messages")
	public String postMessages(@Valid @ModelAttribute("message") Message message, BindingResult result, @PathVariable("id") Long id, HttpSession session) {
		System.out.println(message.getComment());
		Long userId = (Long) session.getAttribute("user_id");
		User thisUser = this.uService.getOneUser(userId);
		Event event = this.eService.getOneEvent(id);
		if(result.hasErrors()) {
			return "redirect:/events/{id}";
		}
		
		message.setAuthor(thisUser);
		message.setCommentEvent(event);
		this.mService.addMessage(message);
		return "redirect:/events/{id}";
		
	}
}