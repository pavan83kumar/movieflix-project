package io.egen.movieflix.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userdetails database table.
 * 
 */
@Entity
@Table(name="user_details")
public class UserDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;

	@Column(name="email_id")
	private String emailId;

	@Column(name="user_name")
	private String userName;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="fk_credentials")
	private CredentialsEntity credential;

	public UserDetailsEntity() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CredentialsEntity getCredential() {
		return this.credential;
	}

	public void setCredential(CredentialsEntity credential) {
		this.credential = credential;
	}

}