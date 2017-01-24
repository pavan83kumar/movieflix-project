package io.egen.movieflix.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="movie_rates")
public class MovieRatedEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rated_id")
	private int ratedId;

	@Column(name="rated_value")
	private String ratedValue;

	//bi-directional many-to-one association to Movy
	@OneToMany(mappedBy="movierated")
	private List<MoviesEntity> movies;

}
