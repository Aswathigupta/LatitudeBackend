package com.niit.latitude.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "postcomment")
@Component
public class PostComment {
	
	@Id
	private String id;
	private String comment;
	//private Date commentedat;
	
//	public Date getCommentedat() {
//		return commentedat;
//	}
//	public void setCommentedat(Date commentedat) {
//		this.commentedat = commentedat;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
