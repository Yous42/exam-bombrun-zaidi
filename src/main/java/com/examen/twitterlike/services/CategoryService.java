package com.examen.twitterlike.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.twitterlike.dtos.CategoryDTO;
import com.examen.twitterlike.models.Category;
import com.examen.twitterlike.repositories.CategoryRepository;



@Service
public class CategoryService {

	
	private CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<CategoryDTO> getCategories() {
		List<Category> categories = categoryRepository.getCategories();
		List<CategoryDTO> categoriesDtos = new ArrayList<>();
		
		categories.forEach((category) -> { 
			categoriesDtos.add(new CategoryDTO(category.getId().toString(),category.getName())); 
				});
		
		return categoriesDtos;
	}
}
