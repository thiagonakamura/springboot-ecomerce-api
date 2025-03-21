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

import com.example.springboot_ecomerce_api.dtos.UserRecordDto;
import com.example.springboot_ecomerce_api.entities.UserEntity;
import com.example.springboot_ecomerce_api.services.UserService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing user-related operations.
 * This class handles HTTP requests related to user operations
 * such as retrieving, creating, updating, and deleting users.
 */

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Retrieves all users from the database.
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	//Retrieves a user by its ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserEntity> getOneUser(@PathVariable Long id){
		UserEntity user = userService.getOneUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	
	//Creates a new user in the database.
	@PostMapping
	public ResponseEntity<UserEntity> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
		var user = new UserEntity();
		BeanUtils.copyProperties(userRecordDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	//Updates an existing user with the provided data.
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody @Valid UserRecordDto userRecordDto){
		var user = new UserEntity();
		BeanUtils.copyProperties(userRecordDto, user);
		return ResponseEntity.ok().body(userService.updateUser(id, user));
	}
	
	//Deletes a user from the database.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok().body("User with id " + id + " deleted.");
	}
}
