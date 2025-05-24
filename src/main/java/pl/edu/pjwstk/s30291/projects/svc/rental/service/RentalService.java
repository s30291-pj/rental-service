package pl.edu.pjwstk.s30291.projects.svc.rental.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import pl.edu.pjwstk.s30291.projects.svc.rental.movie.Movie;

@Service
public class RentalService {

	private RestTemplate rest;
	
	public RentalService(RestTemplate restTemplate) {
		this.rest = restTemplate;
	}
	
	public Movie getMovie(UUID uuid) {
		return rest.getForObject("/movies/%s".formatted(uuid), Movie.class);
	}
	
	public void setAvailability(UUID uuid, boolean value) {
		rest.postForObject("/movies/%s/availability".formatted(uuid), value, Void.class);
	}
}
