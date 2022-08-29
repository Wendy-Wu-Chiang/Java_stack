package com.wendy.hello_human.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
	
@Controller
public class HomeController {
    @RequestMapping("/your_server/")
    public String success(@RequestParam(value="name", required=false, defaultValue="Human") String name, Model model) {
		model.addAttribute("name", name);
		 return "index.jsp";
    }
}