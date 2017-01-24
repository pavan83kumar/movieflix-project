package io.egen.movieflix.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.movieflix.handlers.MovieDetailsHandler;
import io.egen.movieflix.models.RoleDetails;

@RestController
@RequestMapping(path="movie")
public class MovieDetailsServices {

	private MovieDetailsHandler handler;
	
	public MovieDetailsHandler getHandler() {
		return handler;
	}

	public void setHandler(MovieDetailsHandler handler) {
		this.handler = handler;
	}

	@RequestMapping(method=RequestMethod.POST, value="/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createRole(@RequestBody RoleDetails roleDetails){
		return ResponseEntity.ok(handler.createRole(roleDetails));
	}
}
