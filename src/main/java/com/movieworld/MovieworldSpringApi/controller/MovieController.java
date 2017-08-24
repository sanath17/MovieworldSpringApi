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

import com.movieworld.MovieworldSpringApi.entity.Movie;
import com.movieworld.MovieworldSpringApi.service.MovieService;


@Controller
@ResponseBody
@RequestMapping(path = "Movie")
public class MovieController  {
	
	@Autowired
	MovieService service;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE  )
	public List<Movie> findAll(){
		return service.findAll();	
	}
	
//	@RequestMapping(method=RequestMethod.GET, path= "{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findBytitle(@PathVariable("title") String title) {
//		return service.findByTitle(title);
//	}
	
	@RequestMapping(method=RequestMethod.GET, path= "{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public Movie findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

    
//	@RequestMapping(method=RequestMethod.GET, path= "{genere}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByGenere(@PathVariable("genere") String genere) {
//		return service.findByGenere(genere);
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, path= "{ratings}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByRatings(@PathVariable("ratings") int ratings) {
//		return service.findByRatings(ratings);
//	}
//	
//	@RequestMapping(method=RequestMethod.GET, path= "{type}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
//	public Movie findByType(@PathVariable("type") String type) {
//		return service.findByType(type);
//	}
	
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie title) {
		return service.create(title);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, path= "{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public Movie update(@PathVariable("title") Movie title) {
		return service.update(title);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, path= "{title}" )
	public void delete(@PathVariable("title") String title) {
		 service.delete(title);
	}
		
	
}
