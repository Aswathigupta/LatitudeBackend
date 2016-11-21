package com.niit.latitude.dao;

import java.util.List;

import com.niit.latitude.model.PostComment;

public interface PostCommentDAO {

	public List<PostComment> list();

	public PostComment get(String id);

	public void saveOrUpdate(PostComment postComment);

	public void delete(String id);
	
}
