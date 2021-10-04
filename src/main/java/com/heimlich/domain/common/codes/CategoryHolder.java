package com.heimlich.domain.common.codes;

import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public interface CategoryHolder {
	
	String getTextByCode(String code);

	BriefCodeDefine getCode(String code);

	List<? extends BriefCodeDefine> getCodes();

	void clearCache();

}
