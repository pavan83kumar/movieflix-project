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
@Table(name="type_details")
public class TypesEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="type_id")
	private int typeId;

	@Column(name="type_value")
	private String typeValue;
	
	@OneToMany(mappedBy="movietype")
	private List<MoviesEntity> movies;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public List<MoviesEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MoviesEntity> movies) {
		this.movies = movies;
	}
	
	
}
