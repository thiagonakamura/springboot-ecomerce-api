package com.example.springboot_ecomerce_api.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_ecomerce_api.entities.CategoryEntity;
import com.example.springboot_ecomerce_api.repositories.CategoryRepository;
import com.example.springboot_ecomerce_api.services.exceptions.ResourceNotFoundException;

/**
 * Service layer for handling business logic related to CategoryEntity.
 * 
 * This class provides methods for retrieving, creating, updating, and deleting categories.
 * It acts as an intermediary between the controller and the repository.
 */

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	
	public CategoryEntity findById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Retrieves all categories from the database.
	public List<CategoryEntity> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	//Retrieves a category by its ID.
	public CategoryEntity getOneCategory(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	//Saves a new category in the database.
	public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
		return categoryRepository.save(categoryEntity);
	}
	
	//Updates an existing category with new data.
	public CategoryEntity updateCategory(Long id, CategoryEntity categoryUpdated) {
		CategoryEntity category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		BeanUtils.copyProperties(categoryUpdated, category, "id");
		return categoryRepository.save(category);
	}
	
	//Deletes a category from the database.
	public void deleteCategory(Long id) {
		CategoryEntity category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		categoryRepository.delete(category);
	}
}
