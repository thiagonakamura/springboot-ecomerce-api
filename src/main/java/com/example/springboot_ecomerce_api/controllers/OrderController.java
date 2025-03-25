package com.example.springboot_ecomerce_api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_ecomerce_api.dtos.OrderRecordDto;
import com.example.springboot_ecomerce_api.entities.OrderEntity;
import com.example.springboot_ecomerce_api.entities.UserEntity;
import com.example.springboot_ecomerce_api.services.OrderService;
import com.example.springboot_ecomerce_api.services.UserService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing order-related operations.
 * This class handles HTTP requests related to order operations
 * such as retrieving, creating, updating, and deleting orders.
 */

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	//Retrieves all orders from the database.
	@GetMapping
	public ResponseEntity<List<OrderEntity>> getAllOrders(){
		return ResponseEntity.ok().body(orderService.getAllOrders());
	}
	
	//Retrieves a order by its ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderEntity> getOneOrder(@PathVariable Long id){
		OrderEntity order = orderService.getOneOrder(id);
		return ResponseEntity.ok().body(order);
	}
	
	
	//Creates a new order in the database if find the Client´s id.
	@PostMapping
	public ResponseEntity<OrderEntity> saveOrder(@RequestBody @Valid OrderRecordDto orderRecordDto){
		var order = new OrderEntity();
		
		UserEntity userEntity = userService.findById(orderRecordDto.clientId());
		order.setMoment(orderRecordDto.moment());
		order.setStatus(orderRecordDto.status());
		order.setClient(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
	}
	
	//Updates an existing order with the provided data.
	@PutMapping(value = "/{id}")
	public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderRecordDto orderRecordDto){
		var order = new OrderEntity();
		BeanUtils.copyProperties(orderRecordDto, order);
		return ResponseEntity.ok().body(orderService.updateOrder(id, order));
	}
	
	//Deletes a order from the database.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id){
		orderService.deleteOrder(id);
		return ResponseEntity.ok().body("Order with id " + id + " deleted.");
	}
}
