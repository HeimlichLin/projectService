package com.heimlich.domain.project.dto;

import com.heimlich.domain.project.component.AppSupportContext;
import com.heimlich.domain.project.define.Contract;

public class BaseDTO implements DTOSupport {
	
	public String getText(String key) {
		return AppSupportContext.getTextSupport().getText(key);
	}
	public String getText(Contract enumObj) {
		return this.getText(enumObj.getCode());
	}

}
