package com.heimlich.domain.common.codes;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;

public class CodeCategory {
	/** The category. */
	private final String category;

	/** The codes. */
	private final List<? extends BriefCodeDefine> codes;

	/** The codeProp. */
	private final Map<String, BriefCodeDefine> codeToObject = new ConcurrentHashMap<String, BriefCodeDefine>();

	public CodeCategory(final String category,
			final List<? extends BriefCodeDefine> codes) {
		this.category = category;
		for (final BriefCodeDefine bc : codes) {
			this.codeToObject.put(bc.toCode(), bc);
		}
		this.codes = Collections.unmodifiableList(codes);
	}
	
	public String getCategory() {
		return this.category;
	}

	public List<? extends BriefCodeDefine> getCodes() {
		return this.codes;
	}
	
	public String getTextByCode(final String code) {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		final BriefCodeDefine briefCodeDefine = this.codeToObject.get(code);
		if (briefCodeDefine == null) {
			return null;
		}
		return briefCodeDefine.toText();
	}

	public BriefCodeDefine getCode(final String code) {
		if (StringUtils.isBlank(code)) {
			return null;
		}
		return this.codeToObject.get(code);

	}

}
