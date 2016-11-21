package com.niit.latitude.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.latitude.dao.PostDAO;
import com.niit.latitude.model.Post;

public class PostTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		PostDAO postDAO = (PostDAO) context.getBean("postDAO");

		Post post = (Post) context.getBean("post");

//		Date date = new Date();
//		long time = date.getTime();
		

		post.setId("P001");
		post.setName("JOBS");
		post.setDescription("job posts");
		//post.setPostedat(date);

		postDAO.saveOrUpdate(post);

		System.out.println("\n***********\n" + postDAO.list() + "\n***********\n");
		if (postDAO.get("P001") == null) {
			System.out.println("Post does not exist");
		} else {
			System.out.println("Post exists..");
		}
	}
}
