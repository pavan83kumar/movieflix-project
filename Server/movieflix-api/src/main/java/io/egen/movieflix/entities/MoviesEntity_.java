package io.egen.movieflix.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MoviesEntity.class)
public abstract class MoviesEntity_ {

	public static volatile SingularAttribute<MoviesEntity, String> imdbvoting;
	public static volatile SingularAttribute<MoviesEntity, String> country;
	public static volatile SingularAttribute<MoviesEntity, Date> year;
	public static volatile SingularAttribute<MoviesEntity, String> imdbid;
	public static volatile SetAttribute<MoviesEntity, ArtistsEntity> directors;
	public static volatile SingularAttribute<MoviesEntity, Integer> runtime;
	public static volatile SingularAttribute<MoviesEntity, Integer> movieId;
	public static volatile SingularAttribute<MoviesEntity, String> imdbRating;
	public static volatile SingularAttribute<MoviesEntity, String> language;
	public static volatile SingularAttribute<MoviesEntity, String> title;
	public static volatile SingularAttribute<MoviesEntity, MovieRatedEntity> movierated;
	public static volatile SetAttribute<MoviesEntity, ArtistsEntity> actors;
	public static volatile SingularAttribute<MoviesEntity, String> plot;
	public static volatile SingularAttribute<MoviesEntity, String> awards;
	public static volatile SingularAttribute<MoviesEntity, String> metascore;
	public static volatile SingularAttribute<MoviesEntity, String> movieName;
	public static volatile SingularAttribute<MoviesEntity, Date> releaseYear;
	public static volatile SingularAttribute<MoviesEntity, TypesEntity> movietype;

}

