package io.egen.movieflix.daos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.egen.movieflix.configurations.ApplicationConfig;
import io.egen.movieflix.models.ArtistDetails;
import io.egen.movieflix.models.RoleDetails;
import io.egen.movieflix.models.UserDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
public class MovieDAOImplTest {

	@Autowired
	private UserDetailsDAO userDetails;
	
	@Autowired
	private MovieDetailsDAO movieDetails;
	@Test
	public void testGetAllUserDetails(){
		userDetails.findAllUsers();
	}
	
	
	@Test
	public void testRegisterUserDetails(){
		UserDetails userDetailsModel = new UserDetails();
		userDetailsModel.setEmailId("santhoshk.piduri@gmail.com");
		userDetailsModel.setUserName("Santhosh");
		userDetailsModel.setPassword("Santhosh@123");
		userDetails.registerUser(userDetailsModel);
		
	}
	@Test
	public void testCheckUserNameAndPassword(){
		UserDetails userDetailsModel = new UserDetails();
		userDetailsModel.setEmailId("santhoshk.piduri@gmail.com");
		userDetailsModel.setUserName("Santhosh");
		userDetailsModel.setPassword("Santhosh@123");
		userDetails.checkUserNameAndPassword(userDetailsModel);
		
	}
	
	@Test
	public void testAddRole(){
		movieDetails.addRole("Actor");
	}
	
	@Test
	public void testAddArtist(){
		ArtistDetails details = new ArtistDetails();
		details.setArtistBio("all rounder");
		details.setArtistName("Sampath");
		
		RoleDetails role1 = new RoleDetails();
		role1.setRoleName("Director");
		
		RoleDetails role2 = new RoleDetails();
		role2.setRoleName("Actor");
		
		Set<RoleDetails> roleSet = new HashSet<>();
		roleSet.add(role1);
		roleSet.add(role2);
		Iterator<RoleDetails> iterator = roleSet.iterator();
		while (iterator.hasNext()) {
			System.out.println("shl"+iterator.next().getRoleName());
			
			

		}
		details.setRole(roleSet);
		movieDetails.addArtist(details);
	}
}
