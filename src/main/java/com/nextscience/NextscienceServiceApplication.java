package com.nextscience;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nextscience.Constants.UsersConstant;

import io.swagger.v3.oas.models.annotations.OpenAPI30;

/**
 * Processes an {@link NextscienceServiceApplication } request.
 * @author Raghu
 *
 */

@SpringBootApplication

public class NextscienceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextscienceServiceApplication.class, args);
	}

}
