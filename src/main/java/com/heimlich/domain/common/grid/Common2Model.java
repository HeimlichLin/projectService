package com.heimlich.domain.common.grid;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.heimlich.domain.common.Common2ModelBuider;
import com.heimlich.domain.common.CommonlStyle;
import com.heimlich.domain.common.excel.Values;
import com.heimlich.domain.common.excel.component.ExcelModel;
import com.heimlich.domain.common.excel.component.ExcelType;
import com.heimlich.domain.common.utils.TransUtils;
import com.heimlich.domain.project.component.TextSupport;

public class Common2Model implements ExcelModel, GridModel {
	private Map<String, String> mapLabel = new LinkedHashMap<String, String>();
	private GridModelImpl gridModelImpl = new GridModelImpl();
	private Values query = new Values();
	protected List<Map<String, String>> sum = new ArrayList<Map<String, String>>();
	protected ExcelType excelType;
	
	public Common2Model(Common2ModelBuider buider) {
		this.setCaption(buider.getCaption());
		this.excelType = buider.getExcelType();
		for (CommonlStyle commonlStyle : buider.getCommonlStyles()) {
			this.add(commonlStyle, buider.getSupport());
		}
		this.setOrgList(buider.getList());
		this.query = buider.getValues();

	}
	
	public Map<String, String> getMapLabel() {
		return mapLabel;
	}

	public void setMapLabel(Map<String, String> mapLabel) {
		this.mapLabel = mapLabel;
	}

	public void add(CommonlStyle enumT, TextSupport textSupport) {
		this.gridModelImpl.add(enumT, textSupport);
		this.mapLabel.put(enumT.getKey(), enumT.getLabelName(textSupport));
	}

	public GridModelImpl getGridModelImpl() {
		return gridModelImpl;
	}

	public void setGridModelImpl(GridModelImpl gridModelImpl) {
		this.gridModelImpl = gridModelImpl;
	}

	public List<Map<String, String>> getGridList() {
		return gridModelImpl.getGridList();
	}

	public void setCaption(String caString) {
		this.gridModelImpl.caption = caString;

	}

	public String getCaption() {
		return this.gridModelImpl.getCaption();
	}

	public List<String> getColModes() {
		return gridModelImpl.getColModes();
	}

	public List<String> getColNames() {
		return this.gridModelImpl.getColNames();
	}

	public void setGridList(List<Map<String, String>> gridList) {
		this.gridModelImpl.setGridList(gridList);

	}

	public <T> void setOrgList(List<T> lists) {
		List<Map<String, String>> gridList = TransUtils.transBean2MapList(lists);
		this.setGridList(gridList);

		if(CollectionUtils.isNotEmpty(lists)){
			if (excelType == ExcelType.SUM) {
				sum.add(gridList.get(0));
			}
		}
		

	}

	public <T> void setSum(List<T> lists) {
		sum = TransUtils.transBean2MapList(lists);

	}

	public Values getQuery() {
		return this.query;
	}

	public List<Map<String, String>> getSum() {
		return sum;
	}

	public ExcelType getExcelType() {
		return excelType;
	}

	public void setExcelType(ExcelType excelType) {
		this.excelType = excelType;
	}

}
