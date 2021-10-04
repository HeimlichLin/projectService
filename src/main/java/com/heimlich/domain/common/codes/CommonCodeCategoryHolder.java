package com.heimlich.domain.common.codes;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.heimlich.common.exception.ApBusinessException;
import com.heimlich.domain.common.codes.define.BriefCodes;
import com.heimlich.domain.project.model.CodesModel;
import com.tradevan.commons.collection.DataList;
import com.tradevan.commons.collection.DataObject;

public class CommonCodeCategoryHolder extends AbstractCodeCategoryHolder {
	protected final BriefCodes codeDefine;
	private final CodesModel dbFacadeFactory;
	
	/**
	 * Instantiates a new risCodeItem.
	 */
	public CommonCodeCategoryHolder(final BriefCodes codeDefine,
			final CodesModel dbFacadeFactory) {
		this.codeDefine = codeDefine;
		this.dbFacadeFactory = dbFacadeFactory;
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
			final DataList results = this.dbFacadeFactory
					.queryTable(this.codeDefine);
			final List<Code> nppCodes = new ArrayList<Code>();
			for (final Object dataObject : results.toList()) {
				final DataObject pDataObject = (DataObject) dataObject;
				nppCodes.add(this.convert(pDataObject));
			}
			final Set<Code> codesSet = new LinkedHashSet<Code>(nppCodes);
			final List<Code> codesList = new ArrayList<Code>(codesSet);
			final CodeCategory codeCategory = new CodeCategory(category,
					codesList);
			this.defaultCodes = codeCategory;
			return codeCategory;
		} catch (final Exception e) {
			e.printStackTrace();
			throw new ApBusinessException("loadCodeTable fail", e);
		}

	}

	/**
	 * Reload.
	 */

	private Code convert(final DataObject map) {
		final Code code = this.createNppCode(map);
		code.category = this.codeDefine.getCategory();
		code.key = map.getString(this.codeDefine.getKeyColumn());
		code.text = map.getString("VALUE");
		return code;
	}

	private Code createNppCode(final DataObject map) {
		final String base1 = map.getString(this.codeDefine.getBase1Column());
		final String base2 = map.getString(this.codeDefine.getBase2Column());
		final String base3 = map.getString(this.codeDefine.getBase3Column());
		final String base4 = map.getString(this.codeDefine.getBase4Column());
		switch (this.codeDefine.getKeyColumns().length) {
		case 1:
			return new Code();
		case 2:
			return new Code1(base1);
		case 3:
			return new Code2(base1, base2);
		case 4:
			return new Code3(base1, base2, base3);
		case 5:
			return new Code4(base1, base2, base3, base4);
		default:
			throw new RuntimeException("鍵值設定異常");
		}
	}

}
