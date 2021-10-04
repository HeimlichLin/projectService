package com.heimlich.common.db.sql.impl;

import java.util.ArrayList;
import java.util.List;

import com.heimlich.common.db.converter.DataObject2PoConverter;
import com.heimlich.common.db.converter.MapConverter;
import com.heimlich.common.db.sql.SqlSelect;
import com.heimlich.common.exception.TxBusinessException;
import com.tradevan.commons.collection.DataList;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

public class CommonSqlSelect implements SqlSelect {	
	private XdaoSession xdaoSession;

	public CommonSqlSelect(final XdaoSession xdaoSession) {
		this.xdaoSession = xdaoSession;
	}	
	
	final MapConverter<DataObject> NO_CONVERTE = new MapConverter<DataObject>() {

		public DataObject toDataObject(final DataObject po) {
			return po;
		}

		public DataObject convert(final DataObject dataObject) {
			return dataObject;
		}
	};
	
	@Override
	public List<DataObject> select(final String sql) {
		return this.select(this.NO_CONVERTE, sql);
	}

	@Override
	public <PO> List<PO> select(final DataObject2PoConverter<PO> convertec,
			final String sql) {
		final List<PO> pos = new ArrayList<PO>();
		try {
			final DataList dataList = this.xdaoSession.executeQuery(sql, null);
			for (int i = 0; i < dataList.size(); i++) {
				final DataObject dataObject = dataList.get(i);
				pos.add(convertec.convert(dataObject));
			}
		} catch (final XdaoException e) {
			throw new TxBusinessException("查詢錯誤", e);
		}
		return pos;
	}

}
