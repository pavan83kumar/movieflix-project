package io.egen.movieflix.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the credentials database table.
 * 
 */
@Entity
@Table(name="credentials")
public class CredentialsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="credentials_id")
	private int credentialsId;

	private String password;

	//bi-directional many-to-one association to Userdetail
	@OneToMany(mappedBy="credential")
	private List<UserDetailsEntity> userdetails;

	public CredentialsEntity() {
	}

	public int getCredentialsId() {
		return this.credentialsId;
	}

	public void setCredentialsId(int credentialsId) {
		this.credentialsId = credentialsId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserDetailsEntity> getUserdetails() {
		return this.userdetails;
	}

	public void setUserdetails(List<UserDetailsEntity> userdetails) {
		this.userdetails = userdetails;
	}

	public UserDetailsEntity addUserdetail(UserDetailsEntity userdetail) {
		getUserdetails().add(userdetail);
		userdetail.setCredential(this);

		return userdetail;
	}

	public UserDetailsEntity removeUserdetail(UserDetailsEntity userdetail) {
		getUserdetails().remove(userdetail);
		userdetail.setCredential(null);

		return userdetail;
	}

}