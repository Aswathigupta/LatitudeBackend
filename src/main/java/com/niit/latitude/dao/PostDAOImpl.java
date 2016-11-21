package com.niit.latitude.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.latitude.model.Post;

@Repository("postDAO")
public class PostDAOImpl implements PostDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public PostDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public Post get(String id) {

		String hql = "from Post where id=" + "'" + id + "'";
		@SuppressWarnings("unchecked")
		Query<Post> query = sessionFactory.getCurrentSession().createQuery(hql);

		List<Post> listPost = query.getResultList();
		if (listPost != null && !listPost.isEmpty()) {
			return listPost.get(0);
		}

		return null;

	}

	@Transactional
	public void saveOrUpdate(Post post) {

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(post);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Transactional
	public void delete(String id) {

		Post PostToDelete = new Post();
		try {
			PostToDelete.setId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sessionFactory.getCurrentSession().delete(PostToDelete);

	}

	@Transactional
	public List<Post> list() {

		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Post> listPost = (List<Post>) sessionFactory.getCurrentSession().createCriteria(Post.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return listPost;
	}

}
