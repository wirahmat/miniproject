package com.miniproject.project.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.project.common.model.request.inventory.CreateInventoryRequest;
import com.miniproject.project.common.model.request.inventory.UpdateInventoryRequest;
import com.miniproject.project.common.model.response.InventoryResponse;
import com.miniproject.project.persistence.entity.Inventory;

public interface InventoryService {

	void validateIdExist(String id);

	void validateIdActive(String id);

	void validateBkNotExist(String itemCode);

	void validateVersion(String id, Long version);

	List<InventoryResponse> getAll();

	Optional<Inventory> getEntityById(String id);

	Inventory getValidatedEntityById(String id);
	
	InventoryResponse getById(String id);
	
	void add(CreateInventoryRequest data);
	
	void edit(UpdateInventoryRequest data);
	
	void delete(String id);
	
	void delete(List<String> ids);
	
}
