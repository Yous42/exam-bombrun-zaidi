package com.examen.twitterlike.repositories;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.examen.twitterlike.models.Comment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Repository
public class CommentRepository {

	
	public List<Comment> getComments() {
		List<Comment> allComments = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();		
		try {
			File resourceJson = new ClassPathResource("comments.json").getFile();
			allComments = mapper.readValue(
					resourceJson, 
					new TypeReference<List<Comment>>() {} );			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return allComments;
	}
	
	public List<Comment> getCommentByCategoryId(String categoryId) {
		List<Comment> allComments = new ArrayList<>();
		List<Comment> comments = new ArrayList<>();

		ObjectMapper mapper = new ObjectMapper();		
		try {
			File resourceJson = new ClassPathResource("comments.json").getFile();
			allComments = mapper.readValue(
					resourceJson, 
					new TypeReference<List<Comment>>() {} );			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Comment c : allComments) {
			if(c.getPostId()!=null) {
			if(c.getPostId().equals(categoryId)) {
				comments.add(c);
			}}
		}
		
		return comments;
	}
	
	
	
}
