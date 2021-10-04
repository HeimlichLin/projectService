package com.heimlich.domain.common.excel.condtion;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public class MultipleBriefCodesCondtion extends MultipleCondtion<BriefCodeDefine> {

	public MultipleBriefCodesCondtion(//
			final String query,//
			final List<BriefCodeDefine> code,//
			final String category,//
			final BriefCodeComponent briefCodeComponent) {//
		super(query, code, category, briefCodeComponent);
	}
	
	@Override
	public String toShowValue() {
		final List<String> labelStrings = new ArrayList<String>();
		for (final BriefCodeDefine briefCodes : this.getCodes()) {
			labelStrings.add(briefCodes.toText());

		}
		return StringUtils.join(labelStrings, ",");
	}

}
