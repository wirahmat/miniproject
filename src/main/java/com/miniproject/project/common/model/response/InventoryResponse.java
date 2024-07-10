package com.miniproject.project.common.model.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse extends MasterResponse{

	private String itemCode;
	private String itemName;
	private LocalDate lastMaintenance;
	private Boolean isRemindedMaintenance;
	private String isRemindedMaintenanceStr;
	private Integer month;
	private LocalDate registeredDate;
	private String itemCategoryId;
	private String itemCategoryCode;
	private String itemCategoryName;
	
}
