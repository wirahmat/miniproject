package com.miniproject.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miniproject.project.persistence.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>, JpaSpecificationExecutor<Employee> {

	boolean existsByNikAndNumberPhone(String nik, String numberPhone);
	
	Employee findByNik(String nik);
	
	Employee findByNumberPhone(String numberPhone);
	
	@Query(value = "SELECT COUNT(em.id) FROM Employee em ")
	Long getCount();
	
}
