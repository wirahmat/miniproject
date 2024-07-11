package com.miniproject.project.service;

import java.util.List;
import java.util.Optional;

import com.miniproject.project.common.model.request.commodity.CreateCommodityRequest;
import com.miniproject.project.common.model.request.commodity.UpdateCommodityRequest;
import com.miniproject.project.common.model.response.CommodityResponse;
import com.miniproject.project.persistence.entity.Commodity;

public interface CommodityService {

	void validateIdExist(String id);

	void validateIdActive(String id);

	void validateBkNotExist(String code);

	void validateVersion(String id, Long version);

	List<CommodityResponse> getAll();

	Optional<Commodity> getEntityById(String id);

	Commodity getValidatedEntityById(String id);
	
	CommodityResponse getById(String id);
	
	void add(CreateCommodityRequest data);
	
	void edit(UpdateCommodityRequest data);
	
	void delete(String id);
	
	void delete(List<String> ids);
	
}
