package com.heimlich.domain.common.excel.condtion;

import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.excel.component.ValueFace;

public abstract class MultipleCondtion<T> implements ValueFace {
	private String query;
	private List<T> codes;
	private String category;
	protected BriefCodeComponent briefCodeComponent;
	
	public MultipleCondtion(final String query, //
			final List<T> code,//
			final String category,//
			final BriefCodeComponent briefCodeComponent) {//
		super();
		this.query = query;
		this.codes = code;
		this.category = category;
		this.briefCodeComponent = briefCodeComponent;
	}

	@Override
	public String toShowName() {
		return this.query;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(final String query) {
		this.query = query;
	}

	public List<T> getCodes() {
		return this.codes;
	}

	public void setCodes(final List<T> codes) {
		this.codes = codes;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(final String category) {
		this.category = category;
	}

	public BriefCodeComponent getBriefCodeComponent() {
		return this.briefCodeComponent;
	}

	public void setBriefCodeComponent(
			final BriefCodeComponent briefCodeComponent) {
		this.briefCodeComponent = briefCodeComponent;
	}

}
