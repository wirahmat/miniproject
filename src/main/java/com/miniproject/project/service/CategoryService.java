package com.miniproject.project.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.project.common.model.request.category.CreateCategoryRequest;
import com.miniproject.project.common.model.request.category.UpdateCategoryRequest;
import com.miniproject.project.common.model.response.CategoryResponse;
import com.miniproject.project.persistence.entity.Category;

public interface CategoryService {

	void validateIdExist(String id);

	void validateIdActive(String id);

	void validateBkNotExist(String code);

	void validateVersion(String id, Long version);

	List<CategoryResponse> getAll();

	Optional<Category> getEntityById(String id);

	Category getValidatedEntityById(String id);
	
	CategoryResponse getById(String id);
	
	void add(CreateCategoryRequest data);
	
	void edit(UpdateCategoryRequest data);
	
	void delete(String id);
	
	void delete(List<String> ids);
	
}
