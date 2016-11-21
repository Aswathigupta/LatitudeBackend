package com.niit.latitude.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "post")
@Component
public class Post {
	
	private String id;
	private String name;
	private String description;
	private Set<PostComment> postComment;
	

	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	
	public Set<PostComment> getPostComment() {
		return postComment;
	}
	public void setPostComment(Set<PostComment> postComment) {
		this.postComment = postComment;
	}
	
	//private Date postedat;
	
	
//	public Date getPostedat() {
//		return postedat;
//	}
//	public void setPostedat(Date postedat) {
//		this.postedat = postedat;
//	}
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
