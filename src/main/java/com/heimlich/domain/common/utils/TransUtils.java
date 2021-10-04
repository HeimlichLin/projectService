package com.heimlich.domain.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.heimlich.common.exception.TxBusinessException;

public class TransUtils {
	
	public static void transMap2Bean(final Map<String, Object> map, final Object obj) {

		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (final PropertyDescriptor property : propertyDescriptors) {
				final String key = property.getName();

				if (map.containsKey(key)) {
					final Object value = map.get(key);
					final Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}

		} catch (final Exception e) {
			throw new TxBusinessException("轉換失敗", e);
		}

	}

	public static <T> Map<String, String> transBean2Map(final T obj) {
		final Map<String, String> map = new LinkedHashMap<String, String>();
		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (final PropertyDescriptor property : propertyDescriptors) {
				final String key = property.getName();
				final Method getMethod = property.getReadMethod();
				final Object retunVal = getMethod.invoke(obj) == null ? "" : getMethod.invoke(obj);
				if (!key.equals("class")) {
					map.put(key.toUpperCase(), retunVal.toString());
				}

			}
		} catch (final Exception e) {
			throw new TxBusinessException("轉換失敗", e);
		}
		return map;

	}

	public static <T> List<Map<String, String>> transBean2MapList(final List<T> objs) {
		final List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
		for (final T t : objs) {
			mapList.add(TransUtils.transBean2Map(t));
		}
		return mapList;
	}

}
