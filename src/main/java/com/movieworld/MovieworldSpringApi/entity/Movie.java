package com.movieworld.MovieworldSpringApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "Movie.findAll", query = "SELECT e FROM Movie e ORDER BY e.title ASC"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT e FROM Movie e ORDER BY e.year ASC"),
		@NamedQuery(name = "Movie.findByGenere", query = "SELECT e FROM Movie e ORDER BY e.genere ASC"),
		@NamedQuery(name = "Movie.findByRatings", query = "SELECT e FROM Movie e ORDER BY e.imdb_ratings ASC"),
		@NamedQuery(name = "Movie.findByTitle", query = "SELECT e FROM Movie e WHERE e.title=:pTitle"),
        @NamedQuery(name = "Movie.findOne", query = "SELECT e FROM Movie e WHERE e.id=:pId")})
public class Movie {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	@Column(unique = true)
	private String title;

	private int year;

	private String rated;

	private String released;

	private String genere;

	private String director;

	private String writer;

	private String actors;

	private String plot;

	private String language;

	private String country;

	private String awards;

	private String poster;

	private int metascore;

	private int imdb_ratings;

	private long imdb_votings;

	private String imdb_id;

	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getReleased() {
		return released;
	}

	public void setReleased(String released) {
		this.released = released;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getMetascore() {
		return metascore;
	}

	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}

	public int getImdb_ratings() {
		return imdb_ratings;
	}

	public void setImdb_ratings(int imdb_ratings) {
		this.imdb_ratings = imdb_ratings;
	}

	public long getImdb_votings() {
		return imdb_votings;
	}

	public void setImdb_votings(long imdb_votings) {
		this.imdb_votings = imdb_votings;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", released=" + released
				+ ", genere=" + genere + ", director=" + director + ", writer=" + writer + ", actors=" + actors
				+ ", plot=" + plot + ", language=" + language + ", country=" + country + ", awards=" + awards
				+ ", poster=" + poster + ", metascore=" + metascore + ", imdb_ratings=" + imdb_ratings
				+ ", imdb_votings=" + imdb_votings + ", imdb_id=" + imdb_id + ", type=" + type + "]";
	}

}
