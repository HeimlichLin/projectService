package com.heimlich.domain.common.excel.component;

import java.util.List;
import java.util.Map;

import com.heimlich.domain.common.excel.Values;

public interface ExcelModel {
	
	String getCaption();// 標題

	List<Map<String, String>> getGridList();// 取得統計結果
	
	List<Map<String, String>> getSum();// 取得統計結果

	Map<String, String> getMapLabel();// 顯示header

	Values getQuery();// 取得查詢條件

	ExcelType getExcelType();

}
