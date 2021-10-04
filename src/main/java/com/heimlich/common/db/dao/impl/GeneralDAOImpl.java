package com.heimlich.common.db.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.heimlich.common.db.converter.MapConverter;
import com.heimlich.common.db.dao.GeneralDAO;
import com.heimlich.common.exception.TxBusinessException;
import com.tradevan.commons.collection.DataList;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

public abstract class GeneralDAOImpl<PO> implements GeneralDAO<PO> {
	private final String tableName;
	
	public GeneralDAOImpl(final String tableName) {
		super();
		this.tableName = tableName;
	}

	public abstract SqlWhere getPkSqlWhere(PO po);

	public abstract MapConverter<PO> getConverter();

	public final int insert(final XdaoSession session, final PO po) {
		try {
			final DataObject dataObject = this.getConverter().toDataObject(po);
			return session.insert(this.tableName, dataObject);
		} catch (final XdaoException e) {
			throw new TxBusinessException("新增失敗:" + this.tableName, e);
		}
	}

	public final int delete(final XdaoSession session, final PO po) {
		try {
			final SqlWhere sqlWhere = this.getPkSqlWhere(po);
			return session.delete(this.tableName, sqlWhere);
		} catch (final XdaoException e) {
			throw new TxBusinessException("刪除失敗" + this.tableName, e);
		}
	}

	public final int update(final XdaoSession session, final PO po) {
		try {
			return session.update(this.tableName, this.getConverter()
					.toDataObject(po), this.getPkSqlWhere(po));
		} catch (final XdaoException e) {
			throw new TxBusinessException("更新失敗" + this.tableName, e);
		}
	}

	public List<PO> select(final MapConverter<PO> converter,
			final XdaoSession session, final SqlWhere sqlWhere) {
		final List<PO> pos = new ArrayList<PO>();
		try {
			final DataList dataList = session.select(this.tableName, sqlWhere);
			for (int i = 0; i < dataList.size(); i++) {
				final DataObject dataObject = dataList.get(i);
				pos.add(converter.convert(dataObject));
			}
			return pos;
		} catch (final XdaoException e) {
			throw new TxBusinessException("查詢失敗" + this.tableName, e);
		}

	}

	public List<PO> select(final XdaoSession session, final SqlWhere sqlWhere) {
		return this.select(this.getConverter(), session, sqlWhere);
	}

	public int delete(final XdaoSession session, final SqlWhere sqlWhere) {
		try {
			return session.delete(this.tableName, sqlWhere);
		} catch (final XdaoException e) {
			throw new TxBusinessException("刪除失敗" + this.tableName, e);
		}
	}

	public void saveOrUpdate(final XdaoSession session, final PO po) {
		final List<PO> poList = this.select(session, po);
		if (CollectionUtils.isEmpty(poList)) {
			this.insert(session, po);
		} else {
			this.update(session, po);
		}
	}

	public List<PO> select(final XdaoSession session, final PO po) {
		final SqlWhere sqlWhere = this.getPkSqlWhere(po);
		return this.select(session, sqlWhere);

	}
	
	
}
