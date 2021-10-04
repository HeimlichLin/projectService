package com.heimlich.domain.common.codes.briefcode;

import java.util.List;

public interface BriefCodeComponent {
	
	List<? extends BriefCodeDefine> getCodes(final String category);

	String getTextFormCodes(final String category, final String... keys);

	BriefCodeDefine getCode(final String category, final String... keys);

	void clearCache(String category);

}
