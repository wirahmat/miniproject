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
public class EmployeeResponse extends MasterResponse {

	private String nik;
	private String fullName;
	private String numberPhone;
	private String address;
	private String birthplace;
	private LocalDate birthDate;
	private LocalDate joinDate;
	private Boolean isActive;
	
}
