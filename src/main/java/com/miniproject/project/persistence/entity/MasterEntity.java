package com.miniproject.project.persistence.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class MasterEntity {

	@Id
	@Column(name = "id", nullable = false)
	@UuidGenerator
	private String id;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private ZonedDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	private ZonedDateTime updatedAt;

	@Column(name = "version")
	@Version
	private Long version;

	@Column(name = "deleted_at")
	private ZonedDateTime deletedAt;
}
