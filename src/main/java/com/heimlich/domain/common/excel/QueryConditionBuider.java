package com.heimlich.domain.common.excel;

import java.util.ArrayList;
import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.codes.briefcode.BriefCodesCache;
import com.heimlich.domain.common.codes.define.EnumCodes;
import com.heimlich.domain.common.excel.component.ValueFace;
import com.heimlich.domain.common.excel.condtion.CategoryCondtion;
import com.heimlich.domain.common.excel.condtion.CommonCondition;
import com.heimlich.domain.common.excel.condtion.MultipleStringCondtion;

public class QueryConditionBuider {
	final String TEMPLATE = "%s=%s\n";
	final List<ValueFace> valueFaces = new ArrayList<ValueFace>();

	public BriefCodeComponent getBriefCodeComponent() {
		return BriefCodesCache.Instance.getBridfCodeComponent();
	}

	public QueryConditionBuider add(final String query, final String value) {
		this.valueFaces.add(//
				new CommonCondition(query, value));
		return this;
	}

	public QueryConditionBuider add(//
			final String query, //
			final String category, //
			final String value) {//
		this.valueFaces.add(//
				new CategoryCondtion(query,//
						category,//
						value,//
						this.getBriefCodeComponent()));
		return this;
	}

	public QueryConditionBuider add(//
			final String query, //
			final EnumCodes enumCodes, //
			final String value) {//
		this.add(query, enumCodes.name(), value);
		return this;
	}

	public QueryConditionBuider add(final String query, //
			final String category,//
			final List<String> codes) {//
		this.valueFaces.add(//
				new MultipleStringCondtion(query,//
						codes,//
						category, //
						this.getBriefCodeComponent()));//
		return this;
	}

	public QueryConditionBuider add(final String query, //
			final EnumCodes enumCodes,//
			final List<String> codes) {//
		this.add(query, enumCodes.name(), codes);
		return this;
	}

	public Values buider() {
		Values values = new Values();
		values.valueFaces = this.valueFaces;
		return values;
	}

	/**
	 * 顯示查詢條件
	 * 
	 * @return
	 */
	public String toShow() {
		final StringBuffer buffer = new StringBuffer();
		for (final ValueFace queryCondition : this.valueFaces) {
			buffer.append(String.format(this.TEMPLATE,
					queryCondition.toShowName(), queryCondition.toShowValue()));

		}
		return buffer.toString();
	}

}
