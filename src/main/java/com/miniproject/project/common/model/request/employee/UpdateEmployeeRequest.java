package com.miniproject.project.common.model.request.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeRequest {
	
	private String id;
	
	private Long version;
	
	private String nik;

	private String fullName;

	private String numberPhone;

	private String address;

	private String birthplace;

	private LocalDate birthDate;

	private LocalDate joinDate;

	private Boolean isActive;
	
}
