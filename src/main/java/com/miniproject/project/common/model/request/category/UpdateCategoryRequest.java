package com.miniproject.project.common.model.request.category;

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
public class UpdateCategoryRequest {

	@NotBlank
	private String id;
	
	@NotNull
	private Long version;
	
	private String code;

	private String name;

	private String description;
	
	private Boolean isActive;
}
