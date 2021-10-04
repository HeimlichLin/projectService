package com.heimlich.domain.common.codes;

public class Code3 extends Code2 {
	protected String base3;

	public Code3(final String base1, final String base2, final String base3) {
		super(base1, base2);
		this.base3 = base3;
	}

	public final String getBase3() {
		return this.base3;
	}

	@Override
	public String toCode() {
		return this.joinKeys(this.base3, this.base2, this.base1, this.key);
	}

}
