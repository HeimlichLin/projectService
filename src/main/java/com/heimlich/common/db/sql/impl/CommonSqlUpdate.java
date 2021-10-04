package com.heimlich.common.db.sql.impl;

import com.heimlich.common.db.sql.SqlUpdate;
import com.heimlich.common.exception.TxBusinessException;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

public class CommonSqlUpdate implements SqlUpdate {
	private XdaoSession xdaoSession;

	public CommonSqlUpdate(final XdaoSession xdaoSession) {
		this.xdaoSession = xdaoSession;
	}
	
	@Override
	public void update(String sql) {
		try {
			this.xdaoSession.executeUpdate(sql, null);
		} catch (final XdaoException e) {
			throw new TxBusinessException("執行失敗");
		}
	}

}
