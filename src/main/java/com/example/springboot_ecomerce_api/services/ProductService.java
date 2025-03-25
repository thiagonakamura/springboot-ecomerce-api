package com.example.springboot_ecomerce_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_ecomerce_api.entities.ProductEntity;
import com.example.springboot_ecomerce_api.repositories.ProductRepository;
import com.example.springboot_ecomerce_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to ProductEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting products.
 * It acts as an intermediary between the controller and the repository.
 */

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository; 
	
	public ProductEntity findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Retrieves all products from the database.
	public List<ProductEntity> getAllProducts(){
		return productRepository.findAll();
	}
	
	//Retrieves a product by its ID.
	public ProductEntity getOneProduct(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new product in the database.
	public ProductEntity saveProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}
	
	//Updates an existing product with new data.
	public ProductEntity updateProduct(Long id, ProductEntity productUpdated) {
		ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(productUpdated, product, "id");
		return productRepository.save(product);
	}
	
	//Deletes a product from the database.
	public void deleteProduct(Long id) {
		ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		productRepository.delete(product);
	}
}
