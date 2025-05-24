package pl.edu.pjwstk.s30291.projects.svc.rental.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RentalConfiguration {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder, @Value("${service.movie.url}") String url) {
		return builder.rootUri(url).build();
	}
	
}
