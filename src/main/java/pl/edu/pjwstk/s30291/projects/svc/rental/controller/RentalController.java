package pl.edu.pjwstk.s30291.projects.svc.rental.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import pl.edu.pjwstk.s30291.projects.svc.rental.movie.Movie;
import pl.edu.pjwstk.s30291.projects.svc.rental.service.RentalService;

@OpenAPIDefinition(
		info = @Info(
			title = "Movie Rental Service", 
			description = "This is a movie rental service API that can be used to fetch movie details or execute rental actions."
			)
		)

@RestController
@RequestMapping("rentals")
@Tag(name = "Basic Operations - Rental Controller", description = "This controller provides basic rental actions.")
public class RentalController {

	private RentalService service;
	
	public RentalController(RentalService service) {
		this.service = service;
	}
	
	@Operation(summary = "Fetch movie with ID")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Successfuly fetch movie with provided ID", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Movie.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid ID provided", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
	    content = @Content) })
	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable UUID id) {
		return ResponseEntity.ok(service.getMovie(id));
	}
	
	@Operation(summary = "Rent movie with ID")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Movie rental successful", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid ID/request provided", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
			    content = @Content) })
	@PutMapping("/{id}/rent")
	public ResponseEntity<Void> rentMovie(@PathVariable UUID id) {
		service.setAvailability(id, false);
		
		return ResponseEntity.ok().build();
	}
	
	@Operation(summary = "Return movie with ID")
	@ApiResponses(value = { 
			  @ApiResponse(responseCode = "200", description = "Movie return successful", 
			    content = { @Content(mediaType = "application/json", 
			      schema = @Schema(implementation = Movie.class)) }),
			  @ApiResponse(responseCode = "400", description = "Invalid ID/request provided", 
			    content = @Content), 
			  @ApiResponse(responseCode = "404", description = "Movie with provided ID not found", 
			    content = @Content) })
	@PutMapping("/{id}/return")
	public ResponseEntity<Void> returnMovie(@PathVariable UUID id) {
		service.setAvailability(id, true);
		return ResponseEntity.ok().build();
	}
	
}
