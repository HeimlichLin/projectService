package com.heimlich.common.db.dao;

import java.util.List;

import com.heimlich.common.db.converter.MapConverter;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoSession;

public interface GeneralDAO<PO> {

	int insert(final XdaoSession session, final PO po);

	int delete(XdaoSession session, PO po);
	
	int update(XdaoSession session, PO po);
	
	List<PO> select(XdaoSession session, SqlWhere sqlWhere);
	
	List<PO> select(MapConverter<PO> converter, XdaoSession session, SqlWhere sqlWhere);
	
	int delete(XdaoSession session, SqlWhere sqlWhere);
	
	void saveOrUpdate(final XdaoSession session, PO po);
	
	List<PO> select(final XdaoSession session, PO po);

}
