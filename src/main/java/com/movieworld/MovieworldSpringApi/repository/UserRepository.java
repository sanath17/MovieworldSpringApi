package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import com.movieworld.MovieworldSpringApi.entity.User;

public interface UserRepository {

	public List<User> findAll();
	
	public User findByEmail(String email);

	public User create(User email);

	public User update(User email);

	public void delete(User email);
	
	User findById(int id);
	
	User findBySSO(String sso);

}
