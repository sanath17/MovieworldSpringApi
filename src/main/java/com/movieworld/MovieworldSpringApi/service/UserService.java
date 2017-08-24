package com.movieworld.MovieworldSpringApi.service;

import java.util.List;

import com.movieworld.MovieworldSpringApi.entity.User;

public interface UserService {

	 List<User> findAll();

	 User findByEmail(String email);

	 User create(User email);

	 User update(User email);

	 void delete(String email);
	
	User findById(int id);
	
	User findBySso(String sso);

}
