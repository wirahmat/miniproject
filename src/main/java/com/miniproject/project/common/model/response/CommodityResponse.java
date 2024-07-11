package com.miniproject.project.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityResponse extends MasterResponse{

	private String code;
	private String name;
	private String description;
	private Integer restockWhen;
	private Integer quantity;
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private Boolean isActive;
	
}
