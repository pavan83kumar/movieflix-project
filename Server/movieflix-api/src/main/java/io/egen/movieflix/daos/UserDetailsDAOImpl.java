package io.egen.movieflix.daos;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;

import io.egen.movieflix.entities.CredentialsEntity;
import io.egen.movieflix.entities.UserDetailsEntity;
import io.egen.movieflix.entities.UserDetailsEntity_;
//import io.egen.movieflix.entities.Userdetail_;
import io.egen.movieflix.models.UserDetails;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO{

	
	private EntityManagerFactory emf;
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void findAllUsers() {
		EntityManager em = this.emf.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<UserDetailsEntity> query = cb.createQuery(UserDetailsEntity.class);
		
		Root<UserDetailsEntity> root = query.from(UserDetailsEntity.class);
		query.select(root);
		
		TypedQuery<UserDetailsEntity> typedQuery = em.createQuery(query);
		
		for(UserDetailsEntity users : typedQuery.getResultList())
		{
			
		}
	}

	//Requirement 2 
	
	@Override
	public boolean checkUserNameAndPassword(UserDetails userDetails) {
		EntityManager em = emf.createEntityManager();

		try{
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<UserDetailsEntity> query = cb.createQuery(UserDetailsEntity.class);
			
			Root<UserDetailsEntity> root = query.from(UserDetailsEntity.class);
			query.select(root);
			query.where(cb.equal(root.get(UserDetailsEntity_.emailId), userDetails.getEmailId()));
			
			TypedQuery<UserDetailsEntity> typedQuery = em.createQuery(query);
			UserDetailsEntity user = typedQuery.getSingleResult();
			
			if(user!=null){
				if(user.getCredential().getPassword().equals(userDetails.getPassword())){
					return true;
		
				}else{
					return false;
				}
			}else{
				return false;
			}
		}catch(NoResultException nre){
			return false;
		}finally{
			if(em!=null){
				em.close();
			}
		}
		
		
	}

	//Requirement 1 

	@Override
	public boolean registerUser(UserDetails userDetails) {
		//check whether user is registering with existing email id or not 
		//if not allow for registration
		//if yes throw custom exception saying already email exists 
		
		
		EntityManager em = emf.createEntityManager();
		System.out.println("User Details Registration");
		try{
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			UserDetailsEntity userDetailEntity = new UserDetailsEntity();
			userDetailEntity.setUserName(userDetails.getUserName());
			userDetailEntity.setEmailId(userDetails.getEmailId());
			
			CredentialsEntity credential = new CredentialsEntity();
			credential.setPassword(userDetails.getPassword());
			
			userDetailEntity.setCredential(credential);
			
			em.persist(userDetailEntity);
			transaction.commit();
			
		} catch (RollbackException ex) {
	        Logger.getLogger(UserDetailsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	        throw new EntityExistsException(ex);
	    } catch (SecurityException ex) {
	        Logger.getLogger(UserDetailsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (IllegalStateException ex) {
	        Logger.getLogger(UserDetailsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
	    } 
		
		finally{
			if(em!=null){
				em.close();
			}
		}
		
		return false;
	}

	@Override
	public void findUser(String id) {
		
	}

	@Override
	public void getAllMovieDetails() {
		
	}

}
