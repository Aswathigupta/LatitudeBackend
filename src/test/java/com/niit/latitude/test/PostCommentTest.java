package com.niit.latitude.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.latitude.dao.PostCommentDAO;
import com.niit.latitude.dao.PostDAO;
import com.niit.latitude.model.PostComment;

public class PostCommentTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		PostCommentDAO postCommentDAO = (PostCommentDAO) context.getBean("postCommentDAO");

		PostComment postComment = (PostComment) context.getBean("postComment");
		
		PostDAO postDAO = (PostDAO) context.getBean("postDAO");

//		Date date = new Date();
//		long time = date.getTime();
		

		postComment.setId("PC01");
		postComment.setComment("good");
		
		postComment.setPost(postDAO.get("P001"));
		postComment.setPost_id("P001");
		
		
		
		//PostComment.setPostCommentedat(date);

		postCommentDAO.saveOrUpdate(postComment);

		System.out.println("\n***********\n" + postCommentDAO.list() + "\n***********\n");
		if (postCommentDAO.get("PC01") == null) {
			System.out.println("PostComment does not exist");
		} else {
			System.out.println("PostComment exists..");
		}
	}
	

}
