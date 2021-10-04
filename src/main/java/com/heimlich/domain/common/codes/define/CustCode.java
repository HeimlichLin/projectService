package com.heimlich.domain.common.codes.define;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public enum CustCode implements BriefCodeDefine{
	AA("基隆港"), //
	AB("臺北港"), //
	AS("蘇澳港"), //
	DA("臺中港"), //
	BT("安平港"), //
	BA("高雄港"), //
	CA("桃園空港") //
	;
	
	private CustCode(String name) {
		this.code = this.name();
		this.name = name;
	}

	final String code;
	final String name;
	
	@Override
	public String toLastKey() {
		return this.code;
	}

	@Override
	public String toCode() {
		return this.code;
	}

	@Override
	public String toText() {
		return this.name;
	}

}
