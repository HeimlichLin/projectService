package com.heimlich.domain.project.dto.fospm1.impl;

import java.util.List;

import com.heimlich.domain.common.codes.define.BriefCodes;
import com.heimlich.domain.common.codes.define.EnumCodes;
import com.heimlich.domain.common.excel.QueryConditionBuider;
import com.heimlich.domain.common.excel.Values;
import com.heimlich.domain.common.utils.StringFormatUtils;
import com.heimlich.domain.project.define.Contract;
import com.heimlich.domain.project.define.ModelReportDef;

public class Fospm101QueryDTO extends Fospm101DTO implements ModelReportDef {
	private String year;
	private String custCode;
	private String ftzName;	
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getFtzName() {
		return ftzName;
	}

	public void setFtzName(String ftzName) {
		this.ftzName = ftzName;
	}
	
	public List<String> getFtzNameList() {
		return StringFormatUtils.toList(ftzName);
	}

	public List<String> getCustCodeList() {
		return StringFormatUtils.toList(custCode);
	}
	
	@Override
	public String getCaption() {
		return Contract.LABEL_FOSPM101.toText();
	}

	@Override
	public Values getValues() {
		final QueryConditionBuider buider = new QueryConditionBuider();
		buider.add(this.getText(Contract.LABEL_YEAR), this.getYear());
		buider.add(this.getText(Contract.LABEL_CUSTCODE), EnumCodes.CUSTCODE, this.getCustCodeList());
		buider.add(this.getText(Contract.LABEL_FTZNAME), BriefCodes.FOSP_FTZBAN.name(), this.getFtzNameList());
		return buider.buider();
	}

}
