package com.examen.twitterlike.services;


import java.util.List;

import org.springframework.stereotype.Service;


import com.examen.twitterlike.models.Comment;
import com.examen.twitterlike.repositories.CommentRepository;



@Service
public class CommentService {

	
	private CommentRepository commentRepository;
	
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public List<Comment> getCommentByCategoryId(String categoryId){
		return commentRepository.getCommentByCategoryId(categoryId);
	}
	
	
}
