package com.heimlich.domain.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.heimlich.common.exception.ApBusinessException;
import com.heimlich.domain.common.excel.Values;
import com.heimlich.domain.common.excel.component.ExcelType;
import com.heimlich.domain.common.grid.Common2Model;
import com.heimlich.domain.project.component.AppSupportContext;
import com.heimlich.domain.project.component.TextSupport;
import com.heimlich.domain.project.define.ModelReportDef;

public class Common2ModelBuider {
	private String caption;
	private TextSupport support = AppSupportContext.getTextSupport();
	private List<CommonlStyle> commonlStyles = new ArrayList<CommonlStyle>();
	private List<?> list = null;
	private Values values = new Values();
	private ExcelType excelType = ExcelType.NORMAL;
	
	public Common2ModelBuider(ModelReportDef modelReportDef) {
		this.caption = modelReportDef.getCaption();
		this.values = modelReportDef.getValues();
	}
	
	public Common2ModelBuider setTextSupport(TextSupport support) {
		this.support = support;
		return this;
	}
	
	public Common2ModelBuider add(CommonlStyle commonlStyle) {
		this.commonlStyles.add(commonlStyle);
		return this;
	}
	
	public Common2ModelBuider setResult(List<?> list) {
		this.list = list;
		return this;
	}
	
	public Common2Model buider() {
		if (StringUtils.isBlank(this.caption)) {
			throw new ApBusinessException("標題不得為空值");
		}

		if (support == null) {
			throw new ApBusinessException("TextSupport不得null");
		}
		if (CollectionUtils.isEmpty(commonlStyles)) {
			throw new ApBusinessException("請輸入commonlStyles");
		}
		final Common2Model common2Model = new Common2Model(this);

		return common2Model;

	}

	public TextSupport getSupport() {
		return support;
	}

	public void setSupport(TextSupport support) {
		this.support = support;
	}

	public List<CommonlStyle> getCommonlStyles() {
		return commonlStyles;
	}

	public void setCommonlStyles(List<CommonlStyle> commonlStyles) {
		this.commonlStyles = commonlStyles;
	}

	public List<?> getList() {
		return list;
	}

	public String getCaption() {
		return caption;
	}

	public Values getValues() {
		return values;
	}

	public ExcelType getExcelType() {
		return excelType;
	}

	public void setExcelType(ExcelType excelType) {
		this.excelType = excelType;
	}

}
