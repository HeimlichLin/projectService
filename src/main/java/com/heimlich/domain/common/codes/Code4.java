package com.heimlich.domain.common.codes;

public class Code4 extends Code3 {
	protected String base4;

	public Code4(final String base1, final String base2, final String base3,
			final String base4) {
		super(base1, base2, base3);
		this.base4 = base4;
	}

	public final String getBase4() {
		return this.base4;
	}

	@Override
	public String toCode() {
		return this.joinKeys(this.base4, this.base3, this.base2, this.base1,
				this.key);
	}

}
