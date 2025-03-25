package com.example.springboot_ecomerce_api.dtos;

import java.time.Instant;

import com.example.springboot_ecomerce_api.enums.OrderStatus;

import jakarta.validation.constraints.NotNull;

/**
 * Data Transfer Object (DTO) for user-related operations.
 * 
 * This record is used to encapsulate user input data in a structured way, ensuring 
 * validation constraints are applied at the API layer.
 * 
 * Fields:
 * - moment: The timestamp when the order was created.
 * - status: The current status of the order.
 * - id: The unique identifier of the user who placed the order.
 */

public record OrderRecordDto(@NotNull Instant moment, @NotNull OrderStatus status, @NotNull Long clientId) {

}
