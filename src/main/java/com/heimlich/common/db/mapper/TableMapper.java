package com.heimlich.common.db.mapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.heimlich.common.db.dao.GeneralDAO;
import com.heimlich.common.db.utils.ObjectsUtils;
import com.heimlich.common.exception.ApBusinessException;
import com.heimlich.domain.project.dao.impl.FospFtzWorkStatsDAOImpl;
import com.heimlich.domain.project.po.FospFtzWorkStatsPo;

public enum TableMapper {
	FOSP_FTZWORKSTATS(FospFtzWorkStatsPo.class, FospFtzWorkStatsDAOImpl.class) //營運統計-作業型態統計表
	
	;
	final String entityClass;
	final String daoClass;
	
	final static Map<String, TableMapper> MAP;
	
	static {
		final Map<String, TableMapper> map = new HashMap<String, TableMapper>();
		for (final TableMapper mapper : TableMapper.values()) {
			map.put(mapper.entityClass, mapper);
		}
		MAP = Collections.unmodifiableMap(map);
	}
	
	private static String lookUpDAOClassName(final Object object) {
		if (!MAP.containsKey(object.getClass().getName())) {
			throw new ApBusinessException("此無物件無定義"
					+ object.getClass().getName());
		}
		return MAP.get(object.getClass().getName()).daoClass;
	}
	
	private static String lookupDAONameByClass(final Class<?> object) {
		if (!MAP.containsKey(object.getName())) {
			throw new ApBusinessException("此無物件無定義" + object.getName());
		}
		return MAP.get(object.getName()).daoClass;
	}

	@SuppressWarnings("unchecked")
	public static <PO> GeneralDAO<PO> lookupDAO(final Class<PO> object) {
		final String daoClass = lookupDAONameByClass(object);
		return (GeneralDAO<PO>) ObjectsUtils.newInstance(daoClass);
	}

	@SuppressWarnings("unchecked")
	public static <PO> GeneralDAO<PO> lookupDAO(final PO object) {
		final String daoClass = lookUpDAOClassName(object);
		return (GeneralDAO<PO>) ObjectsUtils.newInstance(daoClass);
	}

	private <PO, T extends GeneralDAO<PO>> TableMapper(
			final Class<PO> entityClass, final Class<T> daoClass) {
		this.entityClass = entityClass.getName();
		this.daoClass = daoClass.getName();
	}

}
