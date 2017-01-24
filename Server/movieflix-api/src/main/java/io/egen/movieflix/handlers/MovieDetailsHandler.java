package io.egen.movieflix.handlers;

import org.springframework.stereotype.Component;

import io.egen.movieflix.daos.MovieDetailsDAO;
import io.egen.movieflix.models.RoleDetails;

@Component
public class MovieDetailsHandler {

	private MovieDetailsDAO daoInstance;
	
	public MovieDetailsDAO getDaoInstance() {
		return daoInstance;
	}

	public void setDaoInstance(MovieDetailsDAO daoInstance) {
		this.daoInstance = daoInstance;
	}

	public RoleDetails createRole(RoleDetails details){
		//validation
		if(details!=null && details.getRoleName()!=null && details.getRoleName().length()>0){
			return daoInstance.addRole(details.getRoleName());
		}else{
			return null;
		}
	}
}
