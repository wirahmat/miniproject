package com.miniproject.project.common.model.request.inventory;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateInventoryRequest {

	private String itemCode;
	
	private String itemName;
	
	private LocalDate lastMaintenance;
	
	private Boolean isRemindedMaintenance;

	private Integer month;
	
	private String itemCategoryId;
	
	private Boolean isActive;
}
