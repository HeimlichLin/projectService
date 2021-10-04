package com.heimlich.common.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.heimlich.common.exception.TxBusinessException;

public class YYYYUtils {
	protected static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy");

	public static String getText() {
		return getText(new Date());
	}
	
	public static String getText(Date date) {
		return SDF.format(date);
	}
	
	public static Date parse(String yyyy) {
		try {
			return SDF.parse(yyyy);
		} catch (ParseException e) {
			throw new TxBusinessException("日期格式錯誤:" + yyyy);
		}
	}

}
