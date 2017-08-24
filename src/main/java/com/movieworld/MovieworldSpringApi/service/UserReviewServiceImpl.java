package com.movieworld.MovieworldSpringApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.MovieworldSpringApi.entity.UserReview;
import com.movieworld.MovieworldSpringApi.exception.ReviewNotFoundException;
import com.movieworld.MovieworldSpringApi.repository.UserReviewRepository;

@Service
@EnableTransactionManagement
public class UserReviewServiceImpl implements UserReviewService {

	@Autowired
	UserReviewRepository repository;

	@Override
	public List<UserReview> findAll() {
		return repository.findAll();
	}

	@Override
	public UserReview findOne(UserReview id, UserReview comments) {
		UserReview existing = repository.findOne(id);
		if (existing == null) {
			throw new ReviewNotFoundException("Review with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public UserReview create(UserReview comments) {
		return repository.create(comments);
	}

	@Override
	@Transactional
	public UserReview update(UserReview id, UserReview comments) {
		UserReview existing = repository.findOne(id);
	if (existing == null) {
		throw new ReviewNotFoundException("Review with id:" + id + " not found");
		}
		return repository.update(comments);
	}

	@Override
	@Transactional
	public void delete(UserReview id) {
		UserReview existing = repository.findOne(id);
		if (existing == null) {
			throw new ReviewNotFoundException("Review with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
