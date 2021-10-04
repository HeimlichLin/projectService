package com.heimlich.domain.common.grid;

import java.util.List;
import java.util.Map;

public interface GridModel {
	
	List<String> getColModes();//欄位

	List<String> getColNames();//欄位名稱

	String getCaption();//標題

	List<Map<String, String>> getGridList();//樣式資料	

}
