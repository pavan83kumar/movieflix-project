package io.egen.movieflix.daos;

import io.egen.movieflix.models.ArtistDetails;
import io.egen.movieflix.models.MovieDetails;
import io.egen.movieflix.models.RoleDetails;

public interface MovieDetailsDAO {
	
	RoleDetails addRole(String roleName);
	ArtistDetails addArtist(ArtistDetails details);
	MovieDetails addMovieDetails(MovieDetails details);
}
