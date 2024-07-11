package com.miniproject.project.common.model.request.commodity;

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
public class UpdateCommodityRequest {
	
	@NotBlank
	private String id;

	@NotNull
	private Long version;

	private String code;
	
	private String name;
	
	private String description;
	
	private Integer restockWhen;
	
	private Integer quantity;

	private String itemCategoryId;
	
	private Boolean isActive;
	
}
