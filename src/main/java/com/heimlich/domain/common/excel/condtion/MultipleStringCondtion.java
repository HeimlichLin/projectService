package com.heimlich.domain.common.excel.condtion;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;

public class MultipleStringCondtion extends MultipleCondtion<String> {

	public MultipleStringCondtion(final String query,//
			final List<String> code,//
			final String category, //
			final BriefCodeComponent briefCodeComponent) {//
		super(query, code, category, briefCodeComponent);
	}

	@Override
	public String toShowValue() {
		final List<String> labelStrings = new ArrayList<String>();
		for (final String str : this.getCodes()) {
			labelStrings.add(this.getBriefCodeComponent().getTextFormCodes(
					this.getCategory(), str));

		}
		return StringUtils.join(labelStrings, ",");
	}

}
