package io.egen.movieflix.daos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import io.egen.movieflix.entities.ArtistsEntity;
import io.egen.movieflix.entities.RolesEntity;
import io.egen.movieflix.entities.RolesEntity_;
import io.egen.movieflix.models.ArtistDetails;
import io.egen.movieflix.models.MovieDetails;
import io.egen.movieflix.models.RoleDetails;

@Repository
public class MovieDetailsDAOImpl implements MovieDetailsDAO{

	private EntityManagerFactory emf;
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public RoleDetails addRole(String roleName) {
		
		EntityManager em = emf.createEntityManager();
		RoleDetails details = new RoleDetails();
		EntityTransaction tx= em.getTransaction();

		try{
			tx.begin();
			RolesEntity role = new RolesEntity();
			role.setRole(roleName);
			em.persist(role);
			tx.commit();
			details.setRoleName(roleName);
		}catch(Exception e){
			if(tx!=null){
				tx.rollback();
			}
		}
		finally{
			if(em!=null){
				em.close();
			}
		}
		return details;
	}

	@Override
	public ArtistDetails addArtist(ArtistDetails details) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();

		try{
			tx.begin();
			ArtistsEntity entity = new ArtistsEntity();
			entity.setArtistName(details.getArtistName());
			entity.setArtistBio(details.getArtistBio());
			Iterator<RoleDetails> iterator = details.getRole().iterator();
			Set<RolesEntity> roleEntities = new HashSet<>();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			while (iterator.hasNext()) {
				RoleDetails role = iterator.next();
				System.out.println(role.getRoleName());

				CriteriaQuery<RolesEntity> query = cb.createQuery(RolesEntity.class);

				Root<RolesEntity> root = query.from(RolesEntity.class);
				query.select(root);
				query.where(cb.equal(root.get(RolesEntity_.role), role.getRoleName()));
				
				TypedQuery<RolesEntity> typedQuery = em.createQuery(query);
				RolesEntity roleEntity = typedQuery.getSingleResult();
				
				
				roleEntities.add(roleEntity);
			}
			entity.setArtistRoles(roleEntities);
			em.persist(entity);
			tx.commit();
		}catch(Exception e){
			System.out.println(e);
			if(tx!=null){
				tx.rollback();
			}
		}
		finally{
			if(em!=null){
				em.close();
			}
		}
		return details;
		
	}

	@Override
	public MovieDetails addMovieDetails(MovieDetails details) {
		// TODO Auto-generated method stub
		return null;
	}
}
