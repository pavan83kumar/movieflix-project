package io.egen.movieflix.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.models.UserDetails;

@RestController
@RequestMapping(path = "users")
public class UserDetailsController {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDetails userDetails(){
		UserDetails userDetails = new UserDetails();
		userDetails.setEmailId("santhosh");
		return userDetails;
		
	}
	//@RequestMapping(valuusers/{id}
}
