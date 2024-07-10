package com.miniproject.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.miniproject.project.common.model.request.inventory.CreateInventoryRequest;
import com.miniproject.project.common.model.request.inventory.UpdateInventoryRequest;
import com.miniproject.project.common.model.response.InventoryResponse;
import com.miniproject.project.persistence.entity.Category;
import com.miniproject.project.persistence.entity.Inventory;
import com.miniproject.project.persistence.repository.InventoryRepository;
import com.miniproject.project.service.CategoryService;
import com.miniproject.project.service.InventoryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService{
	
	private final InventoryRepository repo;
	private final CategoryService categoryService;
	
	@Override
	public void validateIdExist(String id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"inventory id is not found ");
		}
	}
	@Override
	public void validateIdActive(String id) {
		Inventory inventory = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"inventory id is not found "));
		if (Boolean.FALSE.equals(inventory.getIsActive())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"inventory is not active");
		}
	}
	@Override
	public void validateBkNotExist(String itemCode) {
		if (repo.existsByItemCode(itemCode)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"inventory with same nik and number phone is exists ");
		}
	}
	@Override
	public void validateVersion(String id, Long version) {
		Inventory inventory = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"inventory is not active" ));
		if (!inventory.getVersion().equals(version)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "inventory version does not matched");
		}
	}
	@Override
	public List<InventoryResponse> getAll() {
		List<Inventory> inventories = repo.findAll();
		List<InventoryResponse> inventoryResponse = inventories.stream().map(this::mapToResponse).toList();
		return inventoryResponse;
	}
	@Override
	public Optional<Inventory> getEntityById(String id) {
		return repo.findById(id);
	}
	@Override
	public Inventory getValidatedEntityById(String id) {
		return getEntityById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"inventory is not exists"));
	}
	@Override
	public InventoryResponse getById(String id) {
		Inventory inventory = getValidatedEntityById(id);
		return mapToResponse(inventory);
	}
	@Override
	public void add(CreateInventoryRequest data) {
		validateBkNotExist(data.getItemCode());
		
		Inventory inventory = new Inventory();
		BeanUtils.copyProperties(data, inventory);
		
		Category category = getActiveCategory(data.getItemCategoryId());
		inventory.setItemCategory(category);
		
		repo.save(inventory);
	}
	@Override
	public void edit(UpdateInventoryRequest data) {
		validateIdExist(data.getId());
		Inventory inventory = getValidatedEntityById(data.getId());
		validateVersion(inventory.getId(), data.getVersion());
		BeanUtils.copyProperties(data, inventory);
		
		if(data.getItemCategoryId() != null && !data.getItemCategoryId().equals(inventory.getItemCategory().getId())) {
			Category category = getActiveCategory(data.getItemCategoryId());
			inventory.setItemCategory(category);
		}
		
		repo.saveAndFlush(inventory);
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
	
	private Category getExistCategory(String categoryId) {
		return categoryService.getEntityById(categoryId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"category is not exists"));
	}
	
	private Category getActiveCategory(String categoryId) {
		Category category = getExistCategory(categoryId);
		if(Boolean.FALSE.equals(category.getIsActive())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "inventory is not active");
		}
		return category;
	}
	
	private InventoryResponse mapToResponse(Inventory inventory) {
		InventoryResponse inventoryResponse = new InventoryResponse();
		BeanUtils.copyProperties(inventory, inventoryResponse);
		
		return inventoryResponse;
	}

}
