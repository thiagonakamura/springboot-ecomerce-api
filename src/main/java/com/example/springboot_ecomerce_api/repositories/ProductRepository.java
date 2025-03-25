package com.example.springboot_ecomerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_ecomerce_api.entities.ProductEntity;

/**
 * Repository interface for managing ProductEntity persistence.
 * Extends JpaRepository to provide CRUD operations and query capabilities.
 */
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
