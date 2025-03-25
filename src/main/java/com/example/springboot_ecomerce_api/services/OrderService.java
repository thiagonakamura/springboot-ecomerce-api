package com.example.springboot_ecomerce_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_ecomerce_api.entities.OrderEntity;
import com.example.springboot_ecomerce_api.repositories.OrderRepository;
import com.example.springboot_ecomerce_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to OrderEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting orders.
 * It acts as an intermediary between the controller and the repository.
 */

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository; 
	
	//Retrieves all orders from the database.
	public List<OrderEntity> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//Retrieves a order by its ID.
	public OrderEntity getOneOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new order in the database.
	public OrderEntity saveOrder(OrderEntity orderEntity) {
		return orderRepository.save(orderEntity);
	}
	
	//Updates an existing order with new data.
	public OrderEntity updateOrder(Long id, OrderEntity orderUpdated) {
		OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(orderUpdated, order, "id");
		return orderRepository.save(order);
	}
	
	//Deletes a order from the database.
	public void deleteOrder(Long id) {
		OrderEntity order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		orderRepository.delete(order);
	}
}
