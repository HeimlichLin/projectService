package com.heimlich.common.db.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class CommonDBStringUtils {
	static String SEMICOLON_MARK = "'";
	
	/**
	 * 1,2,3,4=>'1','2','3','4'
	 * 
	 * @param paString
	 * @return
	 */
	public static String addMarksSymbol(final String paString) {
		final List<String> parameters = CommonDBStringUtils.getParametersByComma(paString);
		final List<String> addNotList = new ArrayList<String>();
		for (final String string : parameters) {
			addNotList.add(CommonDBStringUtils.SEMICOLON_MARK //
					+ string//
					+ CommonDBStringUtils.SEMICOLON_MARK);//
		}
		return StringUtils.join(addNotList, ",");
	}

	/**
	 * '1,2,3,4'=>{"1","2","3"}
	 * 
	 * @param string
	 * @return
	 */
	public static List<String> getParametersByComma(final String string) {
		final String[] dateForm = StringUtils.split(string, ",");
		final List<String> keyStrings = new ArrayList<String>();
		for (final String key : dateForm) {
			keyStrings.add(key.trim());
		}
		return keyStrings;

	}

	public static String getSqlComa(final List<String> datas) {
		final List<String> list = new ArrayList<String>();
		for (String data : datas) {
			list.add("'" + data + "'");
		}
		return StringUtils.join(list, ",");
	}

	public static String getSqlComa(final String... datas) {
		final List<String> inputs = Arrays.asList(datas);
		return getSqlComa(inputs);
	}

}
