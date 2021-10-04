package com.heimlich.domain.common.codes.define;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public enum BriefCodes {
	FOSP_FTZBAN("廠商名稱", "FTZSHORTNAME", "BONDNO"), // 查詢業者清單
	FOSP_COUNTRYCODE("國家名稱", "COUNTRYNAME", "COUNTRYID") {
		@Override
		public String getTableName() {
			return "FOSP_COUNTRYCODE";
		}
	},
	FOSP_FTZLMEBAN("LME廠商名稱", "FTZSHORTNAME", "BONDNO") {
		@Override
		public String toSQL() {
			final StringBuffer buffer = new StringBuffer();
			buffer.append("select distinct BONDNO, FTZNAME as VALUE ")
					.append(" from FOSP_LMESTORAGEDATA order by BONDNO asc ");
			return buffer.toString();
		}
		@Override
		public String getTableName() {
			return "FOSP_FTZBAN";
		}
	} // 查詢LME業者清單
	;
	
	private final String category;
	private final String description;
	private final String valueColumn;
	private final String[] keyColumns;
	
	private BriefCodes(final String description, final String valueColumn,
			final String... keyColumns) {
		this.category =name();
		this.description = description;
		this.valueColumn = valueColumn;
		this.keyColumns = keyColumns;
	}
	
	public String getCategory() {
		return this.category;
	}

	public String getDescription() {
		return this.description;
	}
	
	public String getValueColumn() {
		return this.valueColumn;
	}
	
	public String[] getKeyColumns() {
		return this.keyColumns;
	}
	
	public String getKeyColumn() {
		return get(this.keyColumns, this.keyColumns.length - 1);
	}

	public String getBase1Column() {
		return get(this.keyColumns, this.keyColumns.length - 2);
	}

	public String getBase2Column() {
		return get(this.keyColumns, this.keyColumns.length - 3);
	}

	public String getBase3Column() {
		return get(this.keyColumns, this.keyColumns.length - 4);
	}

	public String getBase4Column() {
		return get(this.keyColumns, this.keyColumns.length - 5);
	}
	
	public String getTableName() {
		return this.category;
	}
	
	public String toSQL() {
		final String isNullTemplateString = "%s is not null";
		final List<String> wheres = new ArrayList<String>();
		for (String column : keyColumns) {
			wheres.add(String.format(isNullTemplateString, column));
		}
		wheres.add(String.format(isNullTemplateString, valueColumn));
		return String.format("select %s, %s as VALUE from %s where %s order by %s asc ", //
				StringUtils.join(keyColumns, ", "), //
				valueColumn, //
				this.getTableName(), //
				StringUtils.join(wheres, " or "),// 排除名稱或key為空白的
				StringUtils.join(keyColumns, ", ")
				);
	}
	
	private static <T> T get(final T[] array, final int index) {
		if (array == null || array.length <= index || index < 0) {
			return null;
		}
		return array[index];
	}
	
	/**
	 * 是否使用Cache機制
	 * @return
	 */
	public boolean isCache() {
		return true;
	}

}
