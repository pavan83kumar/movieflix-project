package io.egen.movieflix.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.egen.movieflix.controllers.MovieDetailsServices;
import io.egen.movieflix.controllers.UserDetailsController;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private  ApplicationConfig appConfig;
	@Bean
	public UserDetailsController controllerInstance(){
		return new UserDetailsController();
	}
	
	@Bean
	public MovieDetailsServices movieDetailsInstance(){
		MovieDetailsServices movieService = new MovieDetailsServices();
		movieService.setHandler(appConfig.movieDetailsHandlerInstance());
		return movieService;
	}
}
