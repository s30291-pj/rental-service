package pl.edu.pjwstk.s30291.projects.svc.rental.controller.advice;

import java.net.ConnectException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientResponseException;

@ControllerAdvice
public class GlobalControllerAdvice {

//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleException(Exception ex) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystapil blad: " + ex.getMessage());
//	}
	
	@ExceptionHandler(RestClientResponseException.class)
	public ResponseEntity<String> handleException(RestClientResponseException ex) {
		HttpStatusCode status;
		
		if(ex.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) status = HttpStatus.BAD_GATEWAY;
		else status = ex.getStatusCode();
		
		return ResponseEntity.status(status).build();
	}
	
	@ExceptionHandler(ConnectException.class)
	public ResponseEntity<String> handleException(ConnectException ex) {
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
	}
}
