package pl.edu.pjwstk.s30291.projects.svc.rental.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.edu.pjwstk.s30291.projects.svc.rental.movie.Movie;
import pl.edu.pjwstk.s30291.projects.svc.rental.service.RentalService;

@RestController
@RequestMapping("rentals")
public class RentalController {

	private RentalService service;
	
	public RentalController(RentalService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable UUID id) {
		return ResponseEntity.ok(service.getMovie(id));
	}
	
	@PutMapping("/{id}/rent")
	public ResponseEntity<Void> rentMovie(@PathVariable UUID id) {
		service.setAvailability(id, false);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}/return")
	public ResponseEntity<Void> returnMovie(@PathVariable UUID id) {
		service.setAvailability(id, true);
		return ResponseEntity.ok().build();
	}
	
}
