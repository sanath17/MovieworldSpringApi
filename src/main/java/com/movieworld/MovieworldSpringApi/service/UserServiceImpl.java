package com.movieworld.MovieworldSpringApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.MovieworldSpringApi.entity.User;
import com.movieworld.MovieworldSpringApi.exception.UserAlreadyExistsException;
import com.movieworld.MovieworldSpringApi.exception.UserNotFoundException;
import com.movieworld.MovieworldSpringApi.repository.UserRepository;



@Service("userService")
@Transactional
@EnableTransactionManagement
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
	
	@Override
	public User findByEmail(String email) {
		User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new UserNotFoundException("User with email:" + email + " not found");
		}
		return existing;
	}
	
	@Override
	@Transactional
	public User create(User email) {
		User existing = repository.findByEmail(email.getEmail());
		if (existing != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + email);
		}
		return repository.create(email);
	}


	@Override
	@Transactional
	public User update(User email) {
		User existing = repository.findByEmail(email.getEmail());
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + email.getEmail() + " not found");
		}
		return repository.update(email);
	}

	@Override
	@Transactional
	public void delete(String email) {
	User existing = repository.findByEmail(email);
		if (existing == null) {
			throw new UserNotFoundException("User with id:" + email + " not found");
		}
		repository.delete(existing);
	}
	
	public User findById(int id) {
		return repository.findById(id);
	}

	public User findBySso(String sso) {
		return repository.findBySSO(sso);
	}

}
