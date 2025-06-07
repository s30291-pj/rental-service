package pl.edu.pjwstk.s30291.projects.svc.rental.movie;

import java.time.LocalDate;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Movie object returned by movie service.")
public class Movie {
	@Schema(description = "Unique identifier of the movie.", example = "d997ae27-0a0a-439d-a982-c37279aa0f39")
	private UUID id;
	
	@Schema(description = "Date of movie publication")
	private LocalDate published;
	
	@Schema(description = "Title of the movie")
	private String title;
	
	@Schema(description = "Description of the movie")
	private String description;
	
	@Schema(description = "Category of the movie")
	private String category;
	
	@Schema(description = "Author of the movie")
	private String author;
	
	@Schema(description = "Availability status of the movie")
	private boolean available;
}
