package com.example.springboot_ecomerce_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for product-related operations.
 * 
 * This record is used to encapsulate product input data in a structured way, ensuring 
 * validation constraints are applied at the API layer.
 * 
 * Fields:
 * - name: Products´s name (must not be blank).
 * - description: Product´s description (must not be blank).
 * - price: Product´s price (must not be null).
 */

public record ProductRecordDto(@NotBlank String name, @NotBlank String description, @NotNull Double price, @NotNull Long categoryId) {

}
