package com.example.springboot_ecomerce_api.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * Data Transfer Object (DTO) for category-related operations.
 * 
 * This record is used to encapsulate user input data in a structured way, ensuring 
 * validation constraints are applied at the API layer.
 * 
 * Fields:
 * - name: Category name (must not be blank).
 */

public record CategoryRecordDto(@NotBlank String name) {

}
