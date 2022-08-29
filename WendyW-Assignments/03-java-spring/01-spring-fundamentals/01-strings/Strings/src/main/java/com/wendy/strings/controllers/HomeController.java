package com.wendy.strings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "Hello client! How are you doing?";
	}
	@RequestMapping("/random")
	public String world() {
		return "Spring Boot is great! So easy to just respond with strings";
	}
}
