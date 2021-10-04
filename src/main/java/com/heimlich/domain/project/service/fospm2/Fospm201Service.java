package com.heimlich.domain.project.service.fospm2;

import com.heimlich.domain.project.dto.fospm2.Fospm201DTO;

/**
 * 代碼檔重置作業介面服務
 *
 */
public interface Fospm201Service {
	/**
	 * 重新查詢
	 * @param dFospm101dto
	 * @return
	 */
	Fospm201DTO query(Fospm201DTO dFospm101dto);

	/**
	 * 清除暫存
	 * @param dFospm101dto
	 * @return
	 */
	Fospm201DTO clearCache(Fospm201DTO dFospm101dto);
}
