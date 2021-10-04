package com.heimlich.common.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.heimlich.common.exception.TxBusinessException;

public class YYYYMMDDUtils {
	protected static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");

	public static String getText() {
		return getText(new Date());
	}
	
	public static String getText(Date date) {
		return SDF.format(date);
	}
	
	public static Date parse(String yyyyMMdd) {
		try {
			return SDF.parse(yyyyMMdd);
		} catch (Exception e) {
			throw new TxBusinessException("日期格式錯誤:" + yyyyMMdd);
		}
	}

}
