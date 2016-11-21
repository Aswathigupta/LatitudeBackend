package com.niit.latitude.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "postcomment")
@Component
public class PostComment {

	@Id
	private String id;
	private String comment;
	private String post_id;

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false, updatable = false, insertable = false)

	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	// private Date commentedat;
	// public Date getCommentedat() {
	// return commentedat;
	// }
	// public void setCommentedat(Date commentedat) {
	// this.commentedat = commentedat;
	// }
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
