package com.example.springboot_ecomerce_api.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for user-related operations.
 * 
 * This record is used to encapsulate user input data in a structured way, ensuring 
 * validation constraints are applied at the API layer.
 * 
 * Fields:
 * - name: User's full name (must not be blank).
 * - email: User's email address (must not be blank).
 * - phone: User's phone number (must not be blank).
 * - password: User's password (must not be blank).
 */

public record UserRecordDto(@NotBlank String name, @NotBlank String email, @NotBlank String phone, @NotBlank String password) {

}
