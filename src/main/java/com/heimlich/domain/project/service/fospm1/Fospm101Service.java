package com.heimlich.domain.project.service.fospm1;

import java.util.List;

import com.heimlich.domain.project.dto.fospm1.impl.Fospm101QueryDTO;
import com.heimlich.domain.project.dto.fospm1.impl.Fospm101ResultDTO;

public interface Fospm101Service extends Fospm1Service {
	/**
	 * 查詢
	 * 
	 * @param queryDTO
	 * @return
	 */
	List<Fospm101ResultDTO> query(Fospm101QueryDTO queryDTO);
	
	class MyConverter{};

}
