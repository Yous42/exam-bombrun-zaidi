package com.examen.twitterlike.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

	@GetMapping("/private/profile")
	public String homePage() {
		return "profile";
	}
}
