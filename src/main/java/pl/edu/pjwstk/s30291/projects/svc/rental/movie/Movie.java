package pl.edu.pjwstk.s30291.projects.svc.rental.movie;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {
	private UUID id;
	
	private LocalDate published;
	
	private String title;
	
	private String description;
	 
	private String category;
	
	private String author;
	
	private boolean available;
}
