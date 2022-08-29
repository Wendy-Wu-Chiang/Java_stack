package com.wendy.the_code.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	@RequestMapping("/")
    public String index(@ModelAttribute("errors") String errors, Model model) {
        model.addAttribute("errors", errors);
        return "index.jsp";
    }
	@PostMapping(path="/code")
	public String success(@RequestParam(value="guess")String guess, RedirectAttributes redirectAttributes) {
		System.out.println(guess);
		
		if(guess.equals("bushido")) {
			System.out.println("You may enter");
			return "success.jsp";
		}else {
			redirectAttributes.addFlashAttribute("errors", "You must train HARDER!");
			return "redirect:/";
		}
	}
}