package com.heimlich.domain.common.codes;

import com.heimlich.domain.common.codes.define.EnumCodes;

public class EnumCodeCategoryHolder extends AbstractCodeCategoryHolder {
	private final EnumCodes codeDefine;
	private CodeCategory defaultCodes;
	
	/**
	 * Instantiates a new risCodeItem.
	 */
	public EnumCodeCategoryHolder(final EnumCodes codeDefine) {
		this.codeDefine = codeDefine;
	}
	
	@Override
	public synchronized void clearCache() {
		this.defaultCodes = null;
	}

	@Override
	protected CodeCategory initial() {
		final CodeCategory checkCache = this.checkCache();
		if (checkCache != null) {
			return checkCache;
		}
		return this.loadCodeTable();
	}

	private CodeCategory checkCache() {
		if (this.defaultCodes != null) {
			return this.defaultCodes;
		}
		return null;
	}
	
	/**
	 * Reload.
	 */
	private synchronized CodeCategory loadCodeTable() {
		final CodeCategory checkCache = this.checkCache();
		if (checkCache != null) {
			return checkCache;
		}
		final String category = this.codeDefine.getCategory();

		try {
			final CodeCategory codeCategory = new CodeCategory(category,
					this.codeDefine.getCommCodes());
			this.defaultCodes = codeCategory;
			return codeCategory;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new RuntimeException("loadCodeTable fail");
		}

	}	

}
