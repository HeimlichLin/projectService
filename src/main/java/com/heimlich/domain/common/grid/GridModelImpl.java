package com.heimlich.domain.common.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.heimlich.domain.project.component.TextSupport;

public class GridModelImpl implements GridModel {	
	protected List<String> colModes = new ArrayList<String>();
	protected List<String> colNames = new ArrayList<String>();
	protected String caption = "";
	protected List<Map<String, String>> gridList = new ArrayList<Map<String, String>>();

	public List<String> getColModes() {
		return this.colModes;
	}

	public List<String> getColNames() {
		return this.colNames;
	}

	public String getCaption() {
		return this.caption;
	}

	public void setCaption(final String caption) {
		this.caption = caption;
	}

	public List<Map<String, String>> getGridList() {
		return this.gridList;
	}

	public void setGridList(final List<Map<String, String>> gridList) {
		this.gridList = gridList;
	}

	public void add(final GridStyle enumT, final TextSupport fsopBaseAction) {
		this.colModes.add(enumT.getStyle());
		this.colNames.add(enumT.getLabelName(fsopBaseAction));
	}

}
