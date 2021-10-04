package com.heimlich.domain.common.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.heimlich.domain.common.codes.briefcode.impl.BriefCodeComponentFactory;
import com.tradevan.commons.collection.DataObject;

public class StringFormatUtils {
	
	public static List<String> toList(String string) {
		final String[] array = StringUtils.split(string, ",");
		final List<String> list = new ArrayList<String>();
		if (array != null) {
			for (String keString : array) {
				list.add(keString.trim());
			}
		}
		return list;
	}
	
	public static String getNumFormate(String col, DataObject dataObject) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
		double value = Double.parseDouble(nal(dataObject.getString(col), 0));
		return String.valueOf(decimalFormat.format(value) + "%");
	}
	
	public String getPCTFormate(String col, DataObject dataObject) {
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.##");
		double value = Double.parseDouble(nal(dataObject.getString(col), 0));
		return String.valueOf(decimalFormat.format(value) + "%");
	}

	private static String nal(String val, Object val2) {
		if (val == null || val.equals(""))
			return val2.toString();
		return val;
	}
	
	public static String getText(final String category, final String keys){
		return BriefCodeComponentFactory.get().getTextFormCodes(category, keys);
	}		

}
