package com.examen.twitterlike.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.twitterlike.dtos.CategoryDTO;
import com.examen.twitterlike.services.CategoryService;

@Controller
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	

	@GetMapping("/private/categories")
	public ModelAndView getCategories() {
		List<CategoryDTO> categories = categoryService.getCategories();
		ModelAndView mav = new ModelAndView("categories");
		mav.addObject("categories", categories);
		return mav;
	}
}
