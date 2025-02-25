package com.miniproject.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.miniproject.project.common.model.request.category.CreateCategoryRequest;
import com.miniproject.project.common.model.request.category.UpdateCategoryRequest;
import com.miniproject.project.common.model.response.CategoryResponse;
import com.miniproject.project.persistence.entity.Category;
import com.miniproject.project.persistence.repository.CategoryRepository;
import com.miniproject.project.service.CategoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	private final CategoryRepository repo;

	@Override
	public void validateIdExist(String id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"category id is not found ");
		}
	}

	@Override
	public void validateIdActive(String id) {
		Category category = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"category id is not found "));
		if (Boolean.FALSE.equals(category.getIsActive())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"category is not active");
		}
	}

	@Override
	public void validateBkNotExist(String code) {
		if (repo.existsByCode(code)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"category with same code is exists ");
		}
	}

	@Override
	public void validateVersion(String id, Long version) {
		Category category = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"category is not active" ));
		if (!category.getVersion().equals(version)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "category version does not matched");
		}
	}

	@Override
	public List<CategoryResponse> getAll() {
		List<Category> categories = repo.findAll();
		List<CategoryResponse> categoryResponse = categories.stream().map(this::mapToResponse).toList();
		return categoryResponse;
	}

	@Override
	public Optional<Category> getEntityById(String id) {
		return repo.findById(id);
	}

	@Override
	public Category getValidatedEntityById(String id) {
		return getEntityById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"category is not exists"));
	}

	@Override
	public CategoryResponse getById(String id) {
		Category category = getValidatedEntityById(id);
		return mapToResponse(category);
	}

	@Override
	public void add(CreateCategoryRequest data) {
		validateBkNotExist(data.getCode());
		
		Category category = new Category();
		BeanUtils.copyProperties(data, category);
		
		repo.save(category);
	}

	@Override
	public void edit(UpdateCategoryRequest data) {
		validateIdExist(data.getId());
		Category category = getValidatedEntityById(data.getId());
		validateVersion(category.getId(), data.getVersion());
		BeanUtils.copyProperties(data, category);
		repo.saveAndFlush(category);
	}

	@Override
	public void delete(String id) {
		repo.deleteById(id);
	}

	@Override
	public void delete(List<String> ids) {
		for(String id : ids) {
			delete(id);
		}
	}
	
	private CategoryResponse mapToResponse(Category category) {
		CategoryResponse categoryResponse = new CategoryResponse();
		BeanUtils.copyProperties(category, categoryResponse);
		
		return categoryResponse;
	}
}
