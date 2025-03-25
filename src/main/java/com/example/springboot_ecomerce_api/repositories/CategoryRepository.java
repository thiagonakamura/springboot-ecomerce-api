package com.example.springboot_ecomerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_ecomerce_api.entities.CategoryEntity;

/**
 * Repository interface for managing CategoryEntity persistence.
 * Extends JpaRepository to provide CRUD operations and query capabilities.
 */
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

}
