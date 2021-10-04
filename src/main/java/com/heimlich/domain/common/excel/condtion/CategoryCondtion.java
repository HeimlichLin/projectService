package com.heimlich.domain.common.excel.condtion;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.excel.component.ValueFace;

public class CategoryCondtion implements ValueFace {
	private String query;
	private String code;
	private String lable;
	private final String category;
	
	public CategoryCondtion(final String query,//
			final String category,//
			final String code,//
			final BriefCodeComponent briefCodeComponent) {//
		this.query = query;
		this.code = code;
		this.category = category;
		this.lable = briefCodeComponent.getTextFormCodes(this.category, code);
	}
	
	public void setQuery(final String query) {
		this.query = query;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getLable() {
		return this.lable;
	}

	public void setLable(final String lable) {
		this.lable = lable;
	}

	@Override
	public String toShowName() {
		return this.query;
	}

	@Override
	public String toShowValue() {
		return this.lable;
	}

	public String getQuery() {
		return this.query;
	}

}
