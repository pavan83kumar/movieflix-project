package io.egen.movieflix.configurations;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import io.egen.movieflix.daos.MovieDetailsDAO;
import io.egen.movieflix.daos.MovieDetailsDAOImpl;
import io.egen.movieflix.daos.UserDetailsDAO;
import io.egen.movieflix.daos.UserDetailsDAOImpl;
import io.egen.movieflix.handlers.MovieDetailsHandler;

@Configuration
public class ApplicationConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManager(){
		LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
		lcemfb.setPersistenceUnitName("movieflix-api");
		return lcemfb;
	}
	@Bean
	public JpaTransactionManager getTransactionManager(EntityManagerFactory emf){
		JpaTransactionManager jtm = new JpaTransactionManager();
		jtm.setEntityManagerFactory(emf);
		return jtm;
	}
	
	@Bean 
	public UserDetailsDAO userDetailsInstance(){
		UserDetailsDAOImpl userDetails = new UserDetailsDAOImpl();
		userDetails.setEmf(getEntityManager().getObject());
		return userDetails;
	}
	
	@Bean
	public MovieDetailsDAO movieDetailsInstance(){
		MovieDetailsDAOImpl details = new MovieDetailsDAOImpl();
		details.setEmf(getEntityManager().getObject());
		return details;
	}
	
	@Bean
	public MovieDetailsHandler movieDetailsHandlerInstance(){
		MovieDetailsHandler handler = new MovieDetailsHandler();
		handler.setDaoInstance(movieDetailsInstance());
		return handler;
	}
}
