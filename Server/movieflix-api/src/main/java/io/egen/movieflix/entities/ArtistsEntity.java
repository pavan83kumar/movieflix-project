package io.egen.movieflix.entities;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name="artist_details")
public class ArtistsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="artist_id")
	private int artistId;

	@Column(name="artist_bio")
	private String artistBio;

	@Column(name="artist_name")
	private String artistName;
	
	@ManyToMany(mappedBy="actors")
	private Set<MoviesEntity> moviesActors = new HashSet<>();

	@ManyToMany(mappedBy="directors")
	private Set<MoviesEntity> moviesDirectors = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(
			name="artist_role_map",
			joinColumns = {@JoinColumn(name="fk_artist_id")},
			inverseJoinColumns = {@JoinColumn(name="fk_role_id")}
			)
	private Set<RolesEntity> artistRoles = new HashSet<>();
	
	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public Set<MoviesEntity> getMoviesActors() {
		return moviesActors;
	}

	public void setMoviesActors(Set<MoviesEntity> moviesActors) {
		this.moviesActors = moviesActors;
	}

	public Set<MoviesEntity> getMoviesDirectors() {
		return moviesDirectors;
	}

	public void setMoviesDirectors(Set<MoviesEntity> moviesDirectors) {
		this.moviesDirectors = moviesDirectors;
	}

	public Set<RolesEntity> getArtistRoles() {
		return artistRoles;
	}

	public void setArtistRoles(Set<RolesEntity> artistRoles) {
		this.artistRoles = artistRoles;
	}

	
	
}
