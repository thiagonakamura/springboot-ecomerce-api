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

import com.example.springboot_ecomerce_api.dtos.CategoryRecordDto;
import com.example.springboot_ecomerce_api.entities.CategoryEntity;
import com.example.springboot_ecomerce_api.services.CategoryService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing category-related operations.
 * This class handles HTTP requests related to category operations
 * such as retrieving, creating, updating, and deleting categorys.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//Retrieves all categories from the database.
	@GetMapping
	public ResponseEntity<List<CategoryEntity>> getAllCategories(){
		return ResponseEntity.ok().body(categoryService.getAllCategories());
	}
	
	//Retrieves a category by its ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryEntity> getOneCategory(@PathVariable Long id){
		CategoryEntity category = categoryService.getOneCategory(id);
		return ResponseEntity.ok().body(category);
	}
	
	
	//Creates a new category in the database.
	@PostMapping
	public ResponseEntity<CategoryEntity> saveCategory(@RequestBody @Valid CategoryRecordDto categoryRecordDto){
		var category = new CategoryEntity();
		BeanUtils.copyProperties(categoryRecordDto, category);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.saveCategory(category));
	}
	
	//Updates an existing category with the provided data.
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Long id, @RequestBody @Valid CategoryRecordDto categoryRecordDto){
		var category = new CategoryEntity();
		BeanUtils.copyProperties(categoryRecordDto, category);
		return ResponseEntity.ok().body(categoryService.updateCategory(id, category));
	}
	
	//Deletes a category from the database.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable Long id){
		categoryService.deleteCategory(id);
		return ResponseEntity.ok().body("Category with id " + id + " deleted.");
	}
}
