package com.heimlich.domain.common.codes;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public abstract class AbstractCodeCategoryHolder implements CategoryHolder {
	protected CodeCategory defaultCodes;
	
	abstract CodeCategory initial();
	
	@Override
	public synchronized void clearCache() {
		this.defaultCodes = null;
	}
	
	@Override
	public String getTextByCode(final String code) {
		if (StringUtils.isBlank(code)) {
			return "";
		}
		final String textByCode = this.initial().getTextByCode(code);
		return StringUtils.defaultString(textByCode);
	}

	@Override
	public BriefCodeDefine getCode(final String code) {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		return this.initial().getCode(code);
	}
	
	/**
	 * Gets the codes.
	 */
	@Override
	public List<? extends BriefCodeDefine> getCodes() {
		return this.initial().getCodes();
	}

}
