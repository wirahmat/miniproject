package com.miniproject.project.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.project.common.model.request.inventory.CreateInventoryRequest;
import com.miniproject.project.common.model.request.inventory.UpdateInventoryRequest;
import com.miniproject.project.common.model.response.InventoryResponse;
import com.miniproject.project.service.InventoryService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping({ "/api/inventory" })
public class InventoryController {

	private final InventoryService inventoryService;
	
	@GetMapping(produces  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryResponse>> getAll(){
		var result = inventoryService.getAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryResponse> getById(@PathVariable String id){
		var result = inventoryService.getById(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody CreateInventoryRequest request){
		inventoryService.add(request);
		return ResponseEntity.ok("inventory has been added successfully");
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody UpdateInventoryRequest request){
		inventoryService.edit(request);
		return ResponseEntity.ok("inventory has been edited successfully");
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String id){
		inventoryService.delete(id);
		return ResponseEntity.ok("inventory has been deleted successfully");
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@RequestBody List<String> ids){
		inventoryService.delete(ids);
		return ResponseEntity.ok("inventory(s) has been deleted successfully");
	}
}
