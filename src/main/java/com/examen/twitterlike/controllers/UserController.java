package com.examen.twitterlike.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.twitterlike.dtos.UserFormDTO;
import com.examen.twitterlike.services.UserService;



@Controller
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping("public/user/new")
	public ModelAndView getRegistrationForm() {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new UserFormDTO("", ""));
		return mav;
	}

	@PostMapping("public/user/new")
	public ModelAndView registerUser(@ModelAttribute UserFormDTO user) {
		userService.saveUser(user);
		ModelAndView mav = new ModelAndView("redirect:/login");
		return mav;
	}

}