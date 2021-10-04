package com.heimlich.domain.common.codes.define;

import java.util.Arrays;
import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public enum EnumCodes {
	CUSTCODE(CustCode.values()) //港口
	;
	
	final String category;
	final List<? extends BriefCodeDefine> commCodes;

	private EnumCodes(BriefCodeDefine[] commCodes) {
		this.category = this.name();

		this.commCodes = Arrays.asList(commCodes);
	}

	public String getCategory() {
		return category;
	}

	public List<? extends BriefCodeDefine> getCommCodes() {
		return commCodes;
	}

}
