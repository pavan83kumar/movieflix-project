package io.egen.movieflix.models;

import java.util.HashSet;
import java.util.Set;

public class ArtistDetails {

	private String artistName;
	private String artistBio;
	
	private Set<RoleDetails> role = new HashSet<>();

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public Set<RoleDetails> getRole() {
		return role;
	}

	public void setRole(Set<RoleDetails> role) {
		this.role = role;
	}
	
	
}
