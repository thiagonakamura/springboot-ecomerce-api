package com.example.springboot_ecomerce_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_ecomerce_api.entities.UserEntity;
import com.example.springboot_ecomerce_api.repositories.UserRepository;
import com.example.springboot_ecomerce_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to UserEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting users.
 * It acts as an intermediary between the controller and the repository.
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository; 
	
	//Retrieves all users from the database.
	public List<UserEntity> getAllUsers(){
		return userRepository.findAll();
	}
	
	//Retrieves a user by its ID.
	public UserEntity getOneUser(Long id) {
		UserEntity userEntity = userRepository.findById(id).orElse(null);
		if (userEntity == null) {
			throw new ResourceNotFoundException(id);
		}
		return userEntity;
	}
	
	//Saves a new user in the database.
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
	
	//Updates an existing user with new data.
	public UserEntity updateUser(Long id, UserEntity userUpdated) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(userUpdated, user, "id");
		return userRepository.save(user);
	}
	
	//Deletes a user from the database.
	public void deleteUser(Long id) {
		UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		userRepository.delete(user);
	}
}
