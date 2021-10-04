package com.heimlich.common.db.session;

import java.util.List;

import com.heimlich.common.db.dao.GeneralDAO;
import com.heimlich.common.db.mapper.MapperFactory;
import com.heimlich.common.db.sql.SqlSelect;
import com.heimlich.common.db.sql.SqlUpdate;
import com.heimlich.common.db.sql.impl.CommonSqlSelect;
import com.heimlich.common.db.sql.impl.CommonSqlUpdate;
import com.heimlich.common.exception.TxBusinessException;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;
import com.tradevan.taurus.xdao.XdaoSession;

public class DoXdaoSession extends XdaoSession implements SessionPo {	
	private MapperFactory mapper;
	private static final long serialVersionUID = 1L;

	public DoXdaoSession(final XdaoSession xdaoSession, final MapperFactory mapper) {
		super(xdaoSession.getXdaoConnection(), null);
		this.mapper = mapper;
	}
	
	public XdaoSession getXdaoSession() {
		return this;
	}

	@Override
	public void beginTransaction() {
		try {
			super.beginTransaction();
		} catch (final XdaoException e) {
			throw new TxBusinessException("資料庫異常", e);
		}
	}
	
	@Override
	public void commit() throws XdaoException {
		try {
			super.commit();
		} catch (final XdaoException e) {
			throw e;
		}

	}
	
	@Override
	public void rollback() {
		super.rollback();
	}
	
	public <PO> GeneralDAO<PO> getMapper(final Class<PO> pClass) {
		return mapper.lookUpDAO(pClass);
	}

	public <PO> GeneralDAO<PO> getMapper(final PO object) {
		return mapper.lookUpDAO(object);
	}
	
	@Override
	public <PO> List<PO> selectPo(final PO po) {
		return this.getMapper(po).select(this.getXdaoSession(), po);
	}
	
	@Override
	public <PO> List<PO> selectPo(final Class<PO> poClass, final SqlWhere sqlWhere) {
		return this.getMapper(poClass).select(this.getXdaoSession(), sqlWhere);
	}
	
	@Override
	public <PO> int deletePo(final PO object) {
		return this.getMapper(object).delete(this.getXdaoSession(), object);
	}

	@Override
	public <PO> int deletePo(final List<PO> datas) {
		int total = 0;
		for (final PO po : datas) {
			total += this.deletePo(po);
		}
		return total;
	}

	@Override
	public <PO> int insertPo(final PO object) {
		return this.getMapper(object).insert(this.getXdaoSession(), object);
	}

	@Override
	public <PO> int insertPo(final List<PO> datas) {
		int total = 0;
		for (final PO po : datas) {
			total += this.insertPo(po);
		}
		return total;
	}

	@Override
	public <PO> int updatePo(final PO po) {
		return this.getMapper(po).update(this.getXdaoSession(), po);
	}

	@Override
	public <PO> int updatePo(final List<PO> datas) {
		int total = 0;
		for (final PO po : datas) {
			total += this.updatePo(po);
		}
		return total;
	}

	@Override
	public <PO> void saveOrUpdatePo(final PO po) {
		this.getMapper(po).saveOrUpdate(this.getXdaoSession(), po);
	}

	
	@Override
	public SqlSelect getSqlSelect() {
		return new CommonSqlSelect(this.getXdaoSession());
	}

	@Override
	public SqlUpdate getSqlUpdate() {
		return new CommonSqlUpdate(this.getXdaoSession());
	}
	

}
