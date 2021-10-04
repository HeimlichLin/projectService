package com.heimlich.domain.common.codes;

public class Code2 extends Code1 {
	protected String base2;

	public Code2(final String base1, final String base2) {
		super(base1);
		this.base2 = base2;
	}

	public final String getBase2() {
		return this.base2;
	}

	@Override
	public String toCode() {
		return this.joinKeys(this.base2, this.base1, this.key);
	}
	
	

}
