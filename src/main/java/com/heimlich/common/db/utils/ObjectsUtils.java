package com.heimlich.common.db.utils;

import com.heimlich.common.exception.ApBusinessException;

public class ObjectsUtils {
	
	public static Object newInstance(String className) {
		try {
			Class<?> instanceClass = Class.forName(className);
			return instanceClass.newInstance();
		} catch (Exception e) {
			throw new ApBusinessException("建立失敗", e);
		}
	}

	public static <T> T newInstance(Class<T> pClass) {
		try {
			return pClass.newInstance();
		} catch (Exception e) {
			throw new ApBusinessException("建立失敗", e);
		}
	}

}
