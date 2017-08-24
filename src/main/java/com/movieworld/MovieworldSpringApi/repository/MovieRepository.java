package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import com.movieworld.MovieworldSpringApi.entity.Movie;

public interface MovieRepository {

	public  List<Movie> findAll();
	
	public  Movie findByTitle(String title);
	
	public Movie findOne(String id);
	
	public Movie findByGenere(String genere);
	
	public Movie findByRatings(int imdb_ratings );
	
	public Movie findByType(String type);
	
	public Movie create(Movie movie);
	
	public Movie update(Movie title);
	
	public void delete(Movie title);


}
