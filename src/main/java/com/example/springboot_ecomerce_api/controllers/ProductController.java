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

import com.example.springboot_ecomerce_api.dtos.ProductRecordDto;
import com.example.springboot_ecomerce_api.entities.ProductEntity;
import com.example.springboot_ecomerce_api.services.ProductService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing product-related operations.
 * This class handles HTTP requests related to product operations
 * such as retrieving, creating, updating, and deleting products.
 */

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//Retrieves all products from the database.
	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllProducts(){
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	//Retrieves a product by its ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductEntity> getOneProduct(@PathVariable Long id){
		ProductEntity product = productService.getOneProduct(id);
		return ResponseEntity.ok().body(product);
	}
	
	
	//Creates a new product in the database.
	@PostMapping
	public ResponseEntity<ProductEntity> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
		var product = new ProductEntity();
		BeanUtils.copyProperties(productRecordDto, product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
	}
	
	//Updates an existing product with the provided data.
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRecordDto productRecordDto){
		var product = new ProductEntity();
		BeanUtils.copyProperties(productRecordDto, product);
		return ResponseEntity.ok().body(productService.updateProduct(id, product));
	}
	
	//Deletes a product from the database.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.ok().body("Product with id " + id + " deleted.");
	}
}
