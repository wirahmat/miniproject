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

import com.miniproject.project.common.model.request.employee.CreateEmployeeRequest;
import com.miniproject.project.common.model.request.employee.UpdateEmployeeRequest;
import com.miniproject.project.common.model.response.EmployeeResponse;
import com.miniproject.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping({ "/api/employee" })
public class EmployeeController {

	private final EmployeeService employeeService;
	
	@GetMapping(produces  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeResponse>> getAll(){
		var result = employeeService.getAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeResponse> getById(@PathVariable String id){
		var result = employeeService.getById(id);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody CreateEmployeeRequest request){
		employeeService.add(request);
		return ResponseEntity.ok("employee has been added successfully");
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> edit(@RequestBody UpdateEmployeeRequest request){
		employeeService.edit(request);
		return ResponseEntity.ok("employee has been edited successfully");
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@PathVariable String id){
		employeeService.delete(id);
		return ResponseEntity.ok("employee has been deleted successfully");
	}
	
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> delete(@RequestBody List<String> ids){
		employeeService.delete(ids);
		return ResponseEntity.ok("employee(s) has been deleted successfully");
	}
}
