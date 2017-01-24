package io.egen.movieflix.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CredentialsEntity.class)
public abstract class CredentialsEntity_ {

	public static volatile SingularAttribute<CredentialsEntity, String> password;
	public static volatile ListAttribute<CredentialsEntity, UserDetailsEntity> userdetails;
	public static volatile SingularAttribute<CredentialsEntity, Integer> credentialsId;

}

