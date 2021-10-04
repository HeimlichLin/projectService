package com.heimlich.domain.project.dto.fospm2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public class Fospm201DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String category;
	List<? extends BriefCodeDefine> briefCodes = new ArrayList<BriefCodeDefine>();

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<? extends BriefCodeDefine> getBriefCodes() {
		return briefCodes;
	}

	public void setBriefCodes(List<? extends BriefCodeDefine> briefCodes) {
		this.briefCodes = briefCodes;
	}

}
