package com.miniproject.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.miniproject.project.common.model.request.employee.CreateEmployeeRequest;
import com.miniproject.project.common.model.request.employee.UpdateEmployeeRequest;
import com.miniproject.project.common.model.response.EmployeeResponse;
import com.miniproject.project.persistence.entity.Employee;
import com.miniproject.project.persistence.repository.EmployeeRepository;
import com.miniproject.project.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository repo;

	@Override
	public void validateIdExist(String id) {
		if (!repo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"employee id is not found ");
		}
	}

	@Override
	public void validateIdActive(String id) {
		Employee employee = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
						"employee id is not found "));
		if (Boolean.FALSE.equals(employee.getIsActive())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"employee is not active");
		}
	}

	@Override
	public void validateBkNotExist(String nik, String numberPhone) {
		if (repo.existsByNikAndNumberPhone(nik, numberPhone)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"employee with same nik and number phone is exists ");
		}
	}

	@Override
	public void validateVersion(String id, Long version) {
		Employee employee = getEntityById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"employee is not active" ));
		if (!employee.getVersion().equals(version)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "employee version does not matched");
		}
	}

	@Override
	public List<EmployeeResponse> getAll() {
		List<Employee> employees = repo.findAll();
		List<EmployeeResponse> employeeResponse = employees.stream().map(this::mapToResponse).toList();
		return employeeResponse;
	}

	@Override
	public Optional<Employee> getEntityById(String id) {
		return repo.findById(id);
	}

	@Override
	public Employee getValidatedEntityById(String id) {
		return getEntityById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
				"employee is not exists"));
	}
	
	@Override
	public EmployeeResponse getById(String id) {
		Employee employee = getValidatedEntityById(id);
		return mapToResponse(employee);
	}

	@Override
	@Transactional
	public void add(CreateEmployeeRequest data) {
		Long nik = repo.getCount() + 1;
		validateBkNotExist(nik.toString(), data.getNumberPhone());
		
		Employee employee = new Employee();
		BeanUtils.copyProperties(data, employee);
		
		employee.setNik(nik.toString());
		repo.save(employee);
	}

	@Override
	@Transactional
	public void edit(UpdateEmployeeRequest data) {
		validateIdExist(data.getId());
		Employee employee = getValidatedEntityById(data.getId());
		validateVersion(employee.getId(), data.getVersion());
		BeanUtils.copyProperties(data, employee);
		repo.saveAndFlush(employee);
	}

	@Override
	@Transactional
	public void delete(String id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(List<String> ids) {
		for(String id : ids) {
			delete(id);
		}
	}
	
	private EmployeeResponse mapToResponse(Employee employee) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		BeanUtils.copyProperties(employee, employeeResponse);
		
		return employeeResponse;
	}
	
}
