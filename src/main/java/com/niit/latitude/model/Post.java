package com.niit.latitude.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "post")
@Component
public class Post {
	
	@Id
	private String id;
	private String name;
	private String description;
	//private Date postedat;
	
	
//	public Date getPostedat() {
//		return postedat;
//	}
//	public void setPostedat(Date postedat) {
//		this.postedat = postedat;
//	}
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
