package com.niit.latitude.dao;

import java.util.List;

import com.niit.latitude.model.Post;

public interface PostDAO {

	public List<Post> list();

	public Post get(String id);

	public void saveOrUpdate(Post post);

	public void delete(String id);
}
