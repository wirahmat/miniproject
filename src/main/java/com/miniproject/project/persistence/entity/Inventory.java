package com.miniproject.project.persistence.entity;

import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "inventories", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "item_code" }) })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE categories SET deleted_at = now() WHERE id=? AND version =?")
@SQLRestriction("deleted_at IS NULL")
public class Inventory extends MasterEntity {

	@Column(name = "item_code", nullable = false)
	private String itemCode;
	
	@Column(name = "item_name", nullable = false)
	private String itemName;
	
	@Column(name = "last_maintenance")
	private LocalDate lastMaintenance;
	
	@Column(name = "is_reminded_maintenance", nullable = false)
	private Boolean isRemindedMaintenance;

	@Column(name = "month")
	private Integer month;
	
	@Column(name = "registered_date", nullable = false)
	private LocalDate registeredDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_category_id", nullable = false)
	private Category itemCategory;
	
	@Column(name = "is_active", nullable = false)
	private Boolean isActive;
	
}
