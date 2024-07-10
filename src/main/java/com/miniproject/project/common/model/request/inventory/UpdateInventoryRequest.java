package com.miniproject.project.common.model.request.inventory;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInventoryRequest {

	@NotBlank
	private String id;

	@NotNull
	private Long version;

	private String itemCode;

	private String itemName;

	private LocalDate lastMaintenance;

	private Boolean isRemindedMaintenance;

	private Integer month;

	private LocalDate registeredDate;

	private String itemCategoryId;
	
	private Boolean isActive;

}
