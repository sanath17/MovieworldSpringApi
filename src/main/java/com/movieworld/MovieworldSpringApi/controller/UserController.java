package com.movieworld.MovieworldSpringApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movieworld.MovieworldSpringApi.entity.User;
import com.movieworld.MovieworldSpringApi.service.UserService;

@Controller
@ResponseBody
@RequestMapping(path = "users")
public class UserController {

	@Autowired
	UserService service;
	

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("email") String email) {
		return service.findByEmail(email);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User create(@RequestBody User email) {
		return service.create(email);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{email}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@PathVariable("email") User email, @RequestBody User user) {
		return service.update(email);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "email")
	public void delete(@PathVariable("email") String email) {
		service.delete(email);
	}

}
