package com.miniproject.project.persistence.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

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
@Table(name = "categories", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "code" }) })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE categories SET deleted_at = now() WHERE id=? AND version =?")
@SQLRestriction("deleted_at IS NULL")
public class Category extends MasterEntity{

	@Column(name = "code", nullable = false)
	private String code;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
}
