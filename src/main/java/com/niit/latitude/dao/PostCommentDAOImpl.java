package com.niit.latitude.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.latitude.model.PostComment;

@Repository("postCommentDAO")
public class PostCommentDAOImpl implements PostCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public PostCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	
	@Transactional
	public PostComment get(String id) {
		
		String hql = "from Post where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<PostComment> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<PostComment> listPost = query.getResultList();
		if (listPost != null && !listPost.isEmpty()) {
			return listPost.get(0);
		}
	
		return null;

	}
	
	

	@Transactional
	public void saveOrUpdate(PostComment postComment) {
		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(postComment);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	@Transactional
	public void delete(String id) {

		PostComment PostToDelete = new PostComment();
		try {
			PostToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(PostToDelete);
		
	}

	@Transactional
	public List<PostComment> list() {
		
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<PostComment> listPost = (List<PostComment>) sessionFactory.getCurrentSession().createCriteria(PostComment.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return listPost;
	}



	

}
