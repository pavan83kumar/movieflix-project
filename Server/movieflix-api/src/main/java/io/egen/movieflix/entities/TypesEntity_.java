package io.egen.movieflix.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TypesEntity.class)
public abstract class TypesEntity_ {

	public static volatile ListAttribute<TypesEntity, MoviesEntity> movies;
	public static volatile SingularAttribute<TypesEntity, Integer> typeId;
	public static volatile SingularAttribute<TypesEntity, String> typeValue;

}

