package com.miniproject.project.persistence.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employees", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "nik", "phone_number" }) })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends MasterEntity{

	@Column(name = "nik", nullable = false)
	private String nik;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "number_phone", nullable = false)
	private String numberPhone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "birth_place")
	private String birthplace;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "join_date")
	private LocalDate joinDate;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
	
}
