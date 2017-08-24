package com.movieworld.MovieworldSpringApi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.movieworld.MovieworldSpringApi.entity.Movie;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByTitle", Movie.class);
		query.setParameter("pTitle", title);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1)
			return movies.get(0);
		return null;
	}
	public Movie findOne(String id) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findOne", Movie.class);
		query.setParameter("pId", id);
		List<Movie> movies = query.getResultList();
		if (movies != null && movies.size() == 1)
			return movies.get(0);
		return null;
	}

	@Override
	public Movie findByGenere(String genere) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByGenere", Movie.class);
		return (Movie) query.getResultList(); 
	}

	@Override
	public Movie findByRatings(int imdb_ratings) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByRatings", Movie.class);
		return (Movie) query.getResultList(); 
	}

	@Override
	public Movie findByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByType", Movie.class);
		return (Movie) query.getResultList(); 
	}

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie title) {
		return em.merge(title);
	}

	@Override
	public void delete(Movie title) {
		em.remove(title);
		
	}

}
