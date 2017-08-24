package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import com.movieworld.MovieworldSpringApi.entity.UserReview;

public interface UserReviewRepository {

	public List<UserReview> findAll();

	public UserReview findOne(String id);

	public UserReview create(UserReview comments);

	public UserReview update(UserReview comments);

	public void delete(UserReview comments);
}
