package com.heimlich.domain.project.service.fospm2.impl;

import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;
import com.heimlich.domain.common.codes.briefcode.impl.BriefCodeComponentFactory;
import com.heimlich.domain.project.dto.fospm2.Fospm201DTO;
import com.heimlich.domain.project.service.fospm2.Fospm201Service;

/**
 * 代碼檔重置作業服務
 *
 */
public class Fospm201ServiceImpl implements Fospm201Service {
	
	private transient BriefCodeComponent briefCodeComponent = BriefCodeComponentFactory.get();

	@Override
	public Fospm201DTO query(Fospm201DTO dFospm201dto) {
		List<? extends BriefCodeDefine> codeDefines = briefCodeComponent.getCodes(dFospm201dto.getCategory());
		dFospm201dto.setBriefCodes(codeDefines);
		return dFospm201dto;
	}
	
	@Override
	public Fospm201DTO clearCache(Fospm201DTO dFospm201dto) {
		BriefCodeComponentFactory.get().clearCache(dFospm201dto.getCategory());
		return dFospm201dto;
	}

}
