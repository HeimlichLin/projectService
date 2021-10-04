package com.heimlich.domain.common.excel.condtion;

import com.heimlich.domain.common.excel.component.ValueFace;

public class CommonCondition implements ValueFace {
	private String query;
	private String value;
	
	public CommonCondition(final String query, final String value) {
		super();
		this.query = query;
		this.value = value;
	}
	
	public String getQuery() {
		return this.query;
	}

	public void setQuery(final String query) {
		this.query = query;
	}

	@Override
	public String toShowValue() {
		return this.value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public String toShowName() {
		return this.query;
	}

}
