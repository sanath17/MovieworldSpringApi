package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieworld.MovieworldSpringApi.entity.UserReview;

@Repository
public class UserReviewRepositoryImpl implements UserReviewRepository  {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<UserReview> findAll() {
		TypedQuery<UserReview> query = em.createNamedQuery("Review.findAll", UserReview.class);
		return query.getResultList();
	}

	@Override
	public UserReview findOne(UserReview id) {
		return em.find(UserReview.class, id);
	}

	@Override
	public UserReview create(UserReview comments) {
		em.persist(comments);
		return null;
	}

	@Override
	public UserReview update(UserReview comments) {
		return em.merge(comments);
	}

	@Override
	public void delete(UserReview comments) {
		em.remove(comments);
	}

	

}
