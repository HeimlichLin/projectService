package com.heimlich.domain.common.codes;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.heimlich.domain.common.codes.briefcode.AbstractBriefCodeDefine;
import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public class Code extends AbstractBriefCodeDefine {
	protected String category;
	protected String key;
	protected String text;
	
	public String getCategory() {
		return this.category;
	}

	public String getKey() {
		return this.key;
	}

	public String getText() {
		return this.text;
	}

	@Override
	public String toLastKey() {
		return this.key;
	}

	@Override
	public String toCode() {
		return this.key;
	}

	@Override
	public String toText() {
		return this.text;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof BriefCodeDefine) {
			final BriefCodeDefine p = (BriefCodeDefine) obj;
			return p.toCode().equals(this.toCode());
		}
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(//
				this.toCode()).//
				toHashCode();//
	}

}
