package com.example.springboot_ecomerce_api.services.exceptions;

/**
 * Custom exception to indicate that a requested resource was not found.
 * 
 * This exception extends RuntimeException, allowing it to be used as an 
 * unchecked exception in the application.
 * 
 * When thrown, it includes a message with the resource ID that was not found.
 */

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//Constructs a new ResourceNotFoundException with a detailed message.
	public ResourceNotFoundException(Object id) {
		super("Resource not found with id: " + id);
	}

}
