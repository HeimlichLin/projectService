package com.heimlich.domain.common.codes.briefcode.impl;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.CategoryHolder;
import com.heimlich.domain.common.codes.CommonCodeCategoryHolder;
import com.heimlich.domain.common.codes.EnumCodeCategoryHolder;
import com.heimlich.domain.common.codes.briefcode.BriefCodeComponent;
import com.heimlich.domain.common.codes.briefcode.BriefCodeDefine;
import com.heimlich.domain.common.codes.define.BriefCodes;
import com.heimlich.domain.common.codes.define.EnumCodes;
import com.heimlich.domain.project.model.CodesModel;

public class BriefCodeComponentImpl implements BriefCodeComponent {
	final Map<String, CategoryHolder> map = new HashMap<String, CategoryHolder>();

	protected BriefCodeComponentImpl() {
		this.init();
	}

	public void init() {
		final EnumSet<BriefCodes> briefCodes = EnumSet.allOf(BriefCodes.class);

		for (final BriefCodes codes : briefCodes) {
			final CommonCodeCategoryHolder holder = new CommonCodeCategoryHolder(
					codes, new CodesModel());
			this.map.put(codes.getCategory(), holder);
		}
		final EnumSet<EnumCodes> enumCodes = EnumSet.allOf(EnumCodes.class);
		for (final EnumCodes codes : enumCodes) {
			final EnumCodeCategoryHolder holder = new EnumCodeCategoryHolder(
					codes);
			this.map.put(codes.getCategory(), holder);
		}
	}
	
	@Override
	public String getTextFormCodes(final String category, final String... keys) {
		final CategoryHolder holder = this.map.get(category);
		for (final String key : keys) {
			if (key == null) {
				// LOGGER.warn("getText with null key : {}", category);
				return null;
			}
		}
		final String code = StringUtils.join(keys, ':');
		return holder.getTextByCode(code);
	}

	@Override
	public BriefCodeDefine getCode(final String category, final String... keys) {
		final CategoryHolder holder = this.map.get(category);
		final String code = StringUtils.join(keys, ':');
		return holder.getCode(code);
	}

	@Override
	public List<? extends BriefCodeDefine> getCodes(final String category) {
		final CategoryHolder holder = this.map.get(category);
		return holder.getCodes();
	}

	@Override
	public void clearCache(final String category) {
		final CategoryHolder holder = this.map.get(category);
		holder.clearCache();
	}

}
