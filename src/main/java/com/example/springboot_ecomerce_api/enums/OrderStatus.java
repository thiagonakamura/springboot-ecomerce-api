package com.example.springboot_ecomerce_api.enums;

/**
 * Enum representing the different statuses an order can have 
 * in the e-commerce system.
 */
public enum OrderStatus {

	WAITING_PAYMENT,
	PAID,
	SHIPPED,
	DELIVERED,
	CANCELED;
	
}
