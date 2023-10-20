package com.nextscience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.nextscience.Constants.UsersConstant;

import io.swagger.v3.oas.models.annotations.OpenAPI30;

/**
 * Processes an {@link NextscienceServiceApplication } request.
 * 
 * @author Raghu
 *
 */

@SpringBootApplication

public class NextscienceServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(NextscienceServiceApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

		return application.sources(NextscienceServiceApplication.class);
	}
}
