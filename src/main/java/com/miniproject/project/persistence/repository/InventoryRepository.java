package com.miniproject.project.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miniproject.project.persistence.entity.Employee;
import com.miniproject.project.persistence.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, String>, JpaSpecificationExecutor<Inventory> {

	boolean existsByItemCode(String itemCode);
	
	Employee findByItemCode(String itemCode);
	
	@Query(value = "SELECT COUNT(inv.id) FROM Inventory inv ")
	Long getCount();
	
}
