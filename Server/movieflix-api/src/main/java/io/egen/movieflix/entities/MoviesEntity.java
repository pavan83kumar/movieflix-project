package io.egen.movieflix.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name="movie_details")
@Entity
public class MoviesEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="imdb_rating")
	private String imdbRating;
	

	private String awards;

	private String country;

	private String imdbid;


	private String imdbvoting;

	private String language;

	private String metascore;

	private String plot;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="release_year")
	private Date releaseYear;

	private int runtime;

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	private Date year;
	
	//directors
	//actors
	//writers

	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="movie_actors_map",
			joinColumns = {@JoinColumn(name="fk_movie_id")},
			inverseJoinColumns = { @JoinColumn(name="fk_actor_id")}
			)	
	private Set<ArtistsEntity> actors = new HashSet<>();
	
	
	@ManyToMany(cascade= {CascadeType.PERSIST})
	@JoinTable(
			name="movie_directors_map",
			joinColumns = {@JoinColumn(name="fk_movie_id")},
			inverseJoinColumns = { @JoinColumn(name="fk_director_id")}
			)	
	private Set<ArtistsEntity> directors = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name="fk_type_id")
	private TypesEntity movietype;
	
	@ManyToOne
	@JoinColumn(name="fk_rated_id")
	private MovieRatedEntity movierated;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getAwards() {
		return awards;
	}

	public void setAwards(String awards) {
		this.awards = awards;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImdbid() {
		return imdbid;
	}

	public void setImdbid(String imdbid) {
		this.imdbid = imdbid;
	}

	public String getImdbvoting() {
		return imdbvoting;
	}

	public void setImdbvoting(String imdbvoting) {
		this.imdbvoting = imdbvoting;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMetascore() {
		return metascore;
	}

	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Set<ArtistsEntity> getActors() {
		return actors;
	}

	public void setActors(Set<ArtistsEntity> actors) {
		this.actors = actors;
	}

	public Set<ArtistsEntity> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<ArtistsEntity> directors) {
		this.directors = directors;
	}

	public TypesEntity getMovietype() {
		return movietype;
	}

	public void setMovietype(TypesEntity movietype) {
		this.movietype = movietype;
	}

	public MovieRatedEntity getMovierated() {
		return movierated;
	}

	public void setMovierated(MovieRatedEntity movierated) {
		this.movierated = movierated;
	}
	
	
	
	
}
