package io.egen.movieflix.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ArtistsEntity.class)
public abstract class ArtistsEntity_ {

	public static volatile SetAttribute<ArtistsEntity, MoviesEntity> moviesActors;
	public static volatile SetAttribute<ArtistsEntity, RolesEntity> artistRoles;
	public static volatile SetAttribute<ArtistsEntity, MoviesEntity> moviesDirectors;
	public static volatile SingularAttribute<ArtistsEntity, Integer> artistId;
	public static volatile SingularAttribute<ArtistsEntity, String> artistName;
	public static volatile SingularAttribute<ArtistsEntity, String> artistBio;

}

