package com.miniproject.project.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.miniproject.project.persistence.entity.InventoryTrx;

@Repository
public interface InventoryTrxRepository extends JpaRepository<InventoryTrx, String>, JpaSpecificationExecutor<InventoryTrx> {

	boolean existsByTrxDateAndTrxNumberAndInventoryId(LocalDate trxDate, String trxNumber, String inventoryId);
	
	List<InventoryTrx> findAllByInventoryId(String invetoryId);
	
	@Query(value = "SELECT COUNT(inTrx.id) FROM InventoryTrx inTrx ")
	Long getCount();
}
