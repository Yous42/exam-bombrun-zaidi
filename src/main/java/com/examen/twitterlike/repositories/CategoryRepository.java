package com.examen.twitterlike.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.examen.twitterlike.models.Category;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CategoryRepository {

	public List<Category> getCategories() {
		List<Category> posts = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();		
		try {
			File resourceJson = new ClassPathResource("categories.json").getFile();
			posts = mapper.readValue(
					resourceJson, 
					new TypeReference<List<Category>>() {} );			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return posts;
	}
}
