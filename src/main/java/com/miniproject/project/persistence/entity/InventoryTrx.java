package com.miniproject.project.persistence.entity;

import java.math.BigDecimal;
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
@Table(name = "inventory_transaction", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "trx_date", "trx_number", "inventory_id" }) })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE categories SET deleted_at = now() WHERE id=? AND version =?")
@SQLRestriction("deleted_at IS NULL")
public class InventoryTrx extends MasterEntity{

	@Column(name = "trx_date", nullable = false)
	private LocalDate trxDate;
	
	@Column(name = "trx_number", nullable = false)
	private String trxNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id", nullable = false)
	private Inventory inventory;
	
	@Column(name = "vendor")
	private String vendor;
	
	@Column(name = "reason")
	private String reason;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;
	
	@Column(name = "description")
	private String description;
	
}
