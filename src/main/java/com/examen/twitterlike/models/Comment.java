package com.examen.twitterlike.models;

import java.util.Date;

public class Comment {

	private Integer id;
	private String postId;
	private String texte;
	private Date dateCreation;
	private String userName;
	
	
	public Comment() {
	}
	
	public Comment(Integer id, String postId, String texte, Date dateCreation, String userName) {
		super();
		this.id = id;
		this.postId = postId;
		this.texte = texte;
		this.dateCreation = dateCreation;
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}


	public void setPostId(String postId) {
		this.postId = postId;
	}


	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
