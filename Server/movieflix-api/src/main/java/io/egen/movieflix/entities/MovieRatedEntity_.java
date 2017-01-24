package io.egen.movieflix.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MovieRatedEntity.class)
public abstract class MovieRatedEntity_ {

	public static volatile ListAttribute<MovieRatedEntity, MoviesEntity> movies;
	public static volatile SingularAttribute<MovieRatedEntity, Integer> ratedId;
	public static volatile SingularAttribute<MovieRatedEntity, String> ratedValue;

}

