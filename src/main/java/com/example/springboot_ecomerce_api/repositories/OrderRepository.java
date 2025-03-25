package com.example.springboot_ecomerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_ecomerce_api.entities.OrderEntity;

/**
 * Repository interface for managing OrderEntity persistence.
 * Extends JpaRepository to provide CRUD operations and query capabilities.
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
