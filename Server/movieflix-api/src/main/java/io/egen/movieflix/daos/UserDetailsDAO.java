package io.egen.movieflix.daos;

import io.egen.movieflix.models.UserDetails;

public interface UserDetailsDAO {
	void findAllUsers();
	boolean checkUserNameAndPassword(UserDetails userDetails);
	boolean registerUser(UserDetails userDetails);
	void findUser(String id);
	void getAllMovieDetails();
}
