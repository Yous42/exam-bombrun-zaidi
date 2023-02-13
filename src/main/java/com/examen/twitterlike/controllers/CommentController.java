package com.examen.twitterlike.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examen.twitterlike.dtos.CommentDTO;
import com.examen.twitterlike.models.Comment;
import com.examen.twitterlike.services.CommentService;



@Controller
public class CommentController {
	
	private CommentService commentService;
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	
	@GetMapping("/private/comment/getbycategoryid/{categoryId}")
	public ModelAndView getCommentByPostId(@PathVariable String categoryId) {
		ModelAndView mav = new ModelAndView("commentsByPost");
		List<Comment> comments = commentService.getCommentByCategoryId(categoryId);
		mav.addObject("comments", comments);
		
		return mav;
	}
	

}
