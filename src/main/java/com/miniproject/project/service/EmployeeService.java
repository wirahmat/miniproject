package com.miniproject.project.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.project.common.model.request.employee.CreateEmployeeRequest;
import com.miniproject.project.common.model.request.employee.UpdateEmployeeRequest;
import com.miniproject.project.common.model.response.EmployeeResponse;
import com.miniproject.project.persistence.entity.Employee;

public interface EmployeeService {

	void validateIdExist(String id);

	void validateIdActive(String id);

	void validateBkNotExist(String nik, String numberPhone);

	void validateVersion(String id, Long version);

	List<EmployeeResponse> getAll();

	Optional<Employee> getEntityById(String id);

	Employee getValidatedEntityById(String id);
	
	EmployeeResponse getById(String id);
	
	void add(CreateEmployeeRequest data);
	
	void edit(UpdateEmployeeRequest data);
	
	void delete(String id);
	
	void delete(List<String> ids);
}
