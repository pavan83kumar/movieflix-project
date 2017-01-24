package io.egen.movieflix.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserDetailsEntity.class)
public abstract class UserDetailsEntity_ {

	public static volatile SingularAttribute<UserDetailsEntity, CredentialsEntity> credential;
	public static volatile SingularAttribute<UserDetailsEntity, String> emailId;
	public static volatile SingularAttribute<UserDetailsEntity, String> userName;
	public static volatile SingularAttribute<UserDetailsEntity, Integer> userId;

}

