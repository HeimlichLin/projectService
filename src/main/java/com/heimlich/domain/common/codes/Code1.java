package com.heimlich.domain.common.codes;

public class Code1 extends Code {
	protected final String base1;
	
	public Code1(final String base1) {
		super();
		this.base1 = base1;
	}

	public final String getBase1() {
		return this.base1;
	}

	@Override
	public String toCode() {
		return this.joinKeys(this.base1, this.key);
	}

}
