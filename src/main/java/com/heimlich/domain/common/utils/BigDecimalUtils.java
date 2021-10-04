package com.heimlich.domain.common.utils;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

public class BigDecimalUtils {
	
	public static BigDecimal formObj(final Object obj) {
		if (obj == null) {
			return null;
		}		
		if (StringUtils.isNumeric(String.valueOf(obj))) {
			return new BigDecimal(String.valueOf(obj));
		}
		return null;
	}

}
