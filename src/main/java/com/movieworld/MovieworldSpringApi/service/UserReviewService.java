package com.movieworld.MovieworldSpringApi.service;

import java.util.List;

import com.movieworld.MovieworldSpringApi.entity.UserReview;

public interface UserReviewService {
	
	public List<UserReview> findAll();
	
	public UserReview findOne( UserReview id, UserReview comments);
	
	public UserReview create(UserReview comments);
	
	public UserReview update(UserReview id, UserReview comments);
	
	public void delete(UserReview comments);

	

}
