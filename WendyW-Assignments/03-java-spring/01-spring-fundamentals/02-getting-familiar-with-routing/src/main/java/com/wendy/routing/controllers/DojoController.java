package com.wendy.routing.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	@RequestMapping("")
	public String index() {
		return "The Dojo is awesome!";
	}
	@RequestMapping("/{city}")
	public String burbank(@PathVariable("city") String city) {
		if(city.equals("burbank")) {
		return "Burbank Dojo is located in Southern California.";
		}
		else if(city.equals("san-jose")) {
		return "SJ dojo is the headquarters.";
	}else {
		return "";
		}
	}
}