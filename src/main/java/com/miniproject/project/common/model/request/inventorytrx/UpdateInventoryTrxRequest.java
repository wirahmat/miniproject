package com.miniproject.project.common.model.request.inventorytrx;

import java.math.BigDecimal;
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
public class UpdateInventoryTrxRequest {

	@NotBlank
	private String id;

	@NotNull
	private Long version;
	
	private LocalDate trxDate;
	
	private String trxNumber;
	
	private String inventoryId;
	
	private String vendor;
	
	private String reason;

	private BigDecimal amount;
	
	private String description;
	
	private Boolean isOneDay;
}
