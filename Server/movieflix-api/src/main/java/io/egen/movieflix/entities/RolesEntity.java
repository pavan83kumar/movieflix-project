package io.egen.movieflix.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role_details")
public class RolesEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="roles_id")
	private int rolesId;

	private String role;
	

	@ManyToMany(mappedBy="artistRoles")
	private Set<ArtistsEntity> artists = new HashSet<>();


	public int getRolesId() {
		return rolesId;
	}


	public void setRolesId(int rolesId) {
		this.rolesId = rolesId;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Set<ArtistsEntity> getArtists() {
		return artists;
	}


	public void setArtists(Set<ArtistsEntity> artists) {
		this.artists = artists;
	}

}
