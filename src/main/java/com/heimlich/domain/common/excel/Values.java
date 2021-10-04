package com.heimlich.domain.common.excel;

import java.util.ArrayList;
import java.util.List;

import com.heimlich.domain.common.excel.component.ValueFace;

public class Values {
	
	final String TEMPLATE = "%s=%s\n";
	protected List<ValueFace> valueFaces = new ArrayList<ValueFace>();

	public String toLine() {
		final StringBuffer buffer = new StringBuffer();
		for (final ValueFace queryCondition : this.valueFaces) {
			buffer.append(String.format(this.TEMPLATE, queryCondition.toShowName(), queryCondition.toShowValue()));

		}
		return buffer.toString();
	}

}
