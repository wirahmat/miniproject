package com.miniproject.project.common.model.response;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MasterResponse {

	private String id;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private Long version;
}
