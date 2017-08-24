package com.movieworld.MovieworldSpringApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.movieworld.MovieworldSpringApi.exception.*;
import com.movieworld.MovieworldSpringApi.repository.MovieRepository;
import com.movieworld.MovieworldSpringApi.entity.Movie;

@Service
@EnableTransactionManagement
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository repository;

	@Override
	public List<Movie> findAll() {

		return repository.findAll();
	}

	@Override
	public Movie findByTitle(String title) {
		Movie existing = repository.findByTitle(title);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + title + "notfound");
		}
		return existing;
	}
	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + id + "notfound");
		}
		return existing;
	}

	@Override
	public Movie findByGenere(String genere) {
		Movie existing = repository.findByGenere(genere);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + genere + "notfound");
		}
		return existing;
	}

	@Override
	public Movie findByRatings(int imdb_ratings) {
		Movie existing = repository.findByRatings(imdb_ratings);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + imdb_ratings + "notfound");
		}
		return existing;
	}

	@Override
	public Movie findByType(String type) {
		Movie existing = repository.findByType(type);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + type + "notfound");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie create(Movie movie) {
		Movie existing = repository.findByTitle(movie.getTitle());
		if (existing != null) {
			throw new MovieNotFoundException("Movie with " + movie.getTitle() + "already exists");
		}
		return repository.create(movie);
	}

	@Override
	@Transactional
	public Movie update(String id, Movie title) {
		Movie existing = repository.findByTitle(title.getTitle());
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + title.getTitle() + "notfound");
		}
		return repository.update(title);
	}

	@Override
	@Transactional
	public void delete(String title) {
		Movie existing = repository.findByTitle(title);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with " + title + "notfound");
		}
		repository.delete(existing);
	}

}
