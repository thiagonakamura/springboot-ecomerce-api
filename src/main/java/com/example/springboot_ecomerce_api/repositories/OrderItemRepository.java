package com.example.springboot_ecomerce_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot_ecomerce_api.entities.OrderItemEntity;
import com.example.springboot_ecomerce_api.entities.pk.OrderItemPK;

/**
 * Repository interface for managing OrderItemEntity persistence.
 * Extends JpaRepository to provide CRUD operations and query capabilities.
 */
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPK>{

}
