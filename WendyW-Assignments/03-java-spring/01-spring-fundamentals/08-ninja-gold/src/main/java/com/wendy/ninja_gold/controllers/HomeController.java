package com.wendy.ninja_gold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		ArrayList<String> activity = new ArrayList<String>();
		//Set gold attribute
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		//Set activity attribute.
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		model.addAttribute("totalGold", session.getAttribute("gold"));
		model.addAttribute("activity", session.getAttribute("activity"));
		return "index.jsp";
	}
	
	@RequestMapping("/getgold")
	public String processGold(HttpSession session, @RequestParam("location")String location, Model model) {
		Random r = new Random();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd YYYY HH:mm a");
		
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("now", now);
		System.out.println(dtf.format(now));
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		int gold = (int)session.getAttribute("gold");
		int goldEarned;
		
		//Logic for earning/losing gold
		if(location.equals("farm")) {
			//Farm earns a random value between 10-20
			goldEarned = r.nextInt((20-10)+1)+10;
			activity.add(String.format("You entered a %s and earned %s gold (" + dtf.format(now) + ")", location, goldEarned));
		}else if(location.equals("cave")) {
		//Cave earns a random value between 5 and 10
		goldEarned = r.nextInt((10-5)+1)+5;
		activity.add(String.format("You entered a %s and earned %s gold (" + dtf.format(now) + ")", location, goldEarned));
		}else if(location.equals("house")) {
		//House earns a random value between 2 and 5
			goldEarned = r.nextInt((5-2)+1)+2;
			activity.add(String.format("You entered a %s and earned %s gold (" + dtf.format(now) + ")", location, goldEarned));
		}else if(location.equals("spa")) {	
		//Bonus challenge: Create a fifth place "spa" where the ninja loses 5-20 gold
			goldEarned = r.nextInt((20-5)+1)-20;
			activity.add(String.format("You entered a %s and lost %s gold. Oof (" + dtf.format(now) + ")", location, goldEarned));
		}else {
			//Casino earns or loses a random value between 0 and 50
			goldEarned = r.nextInt((50+50)+1)-50;
			if(goldEarned < 0) {
				activity.add(String.format("You entered a %s and lost %s gold. Ouch (" + dtf.format(now) + ")", location, goldEarned));
			} else {
				activity.add(String.format("You entere a %s and earned %s gold (" + dtf.format(now) + ")", location, goldEarned));
			}
		}
		//Send the ninja to a debtors prison on a second rendered page if the ninja falls too far into debt 
		if(gold < -100) {
			activity.add(String.format("You entered a %s and lost %s gold. Over limit. Jail time for you. (" + dtf.format(now) + ")", location, goldEarned));
			return "jail.jsp";
		}
		int totalGold = gold += goldEarned;
		session.setAttribute("activity", activity);
		session.setAttribute("gold", totalGold);
		return "redirect:/";
		}
		//Bonus Challenge: Create a reset button to set the gold earned back to zero
		@RequestMapping("/reset")
		public String clearCount(HttpSession session) {
			session.setAttribute("gold", 0);// Will reset gold to 0
			return "redirect:/";
		}
}
