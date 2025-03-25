package com.example.springboot_ecomerce_api.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springboot_ecomerce_api.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

//This annotation marks the class as a centralized exception handler for all controllers, allowing global exception handling.
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	// This method intercepts exceptions of type ResourceNotFoundException and handles them accordingly.
	public ResponseEntity<StandardError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		// Creates a standardized error response containing timestamp, status code, error description, exception message, and request URI.
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		// Returns an HTTP response with the defined status code and the error details in the response body.
		return ResponseEntity.status(status).body(err);
	}
}
