package com.miniproject.project.common.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse extends MasterResponse{

	private String code;
	private String name;
	private String description;
	private Boolean isActive;
}
