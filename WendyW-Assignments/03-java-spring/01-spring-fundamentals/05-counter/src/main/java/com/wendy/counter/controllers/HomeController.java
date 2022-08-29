package com.wendy.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("")
	public String index(HttpSession session){      
        if(session.getAttribute("count") == null) {        
            session.setAttribute("count", 0);
        }
        return "index.jsp";
    }
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		currentCount++;
		
		session.setAttribute("count", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/counter_two")
        public String counterTwo(HttpSession session) {
			
			if(session.getAttribute("countTwo") == null)        	
            session.setAttribute("countTwo", 0);
	
			Integer currentCountTwo = (Integer) session.getAttribute("countTwo");
			currentCountTwo+=2;

			session.setAttribute("countTwo", currentCountTwo);
			return "counter_two.jsp";
		}
	
	@RequestMapping("/clear")
	public String clearCount(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/your_server/counter";
	}
	
	@RequestMapping("/clear_two")
	public String clearCountTwo(HttpSession session) {
		session.setAttribute("countTwo", 0);
		return "redirect:/your_server/counter_two";
	}

}