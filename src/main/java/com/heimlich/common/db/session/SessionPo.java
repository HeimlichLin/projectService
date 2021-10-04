package com.heimlich.common.db.session;

import java.util.List;

import com.heimlich.common.db.sql.SqlSelect;
import com.heimlich.common.db.sql.SqlUpdate;
import com.tradevan.taurus.xdao.SqlWhere;
import com.tradevan.taurus.xdao.XdaoException;

public interface SessionPo {
	
	void beginTransaction();

	void commit() throws XdaoException;

	/**
	 * rollback
	 */
	void rollback();

	/**
	 * 新增
	 *
	 * @param object
	 * @return
	 */
	<PO> int insertPo(PO object);

	/**
	 * 新增
	 *
	 * @param datas
	 * @return
	 */
	<PO> int insertPo(List<PO> datas);
	
	/**
	 * 刪除
	 *
	 * @param object
	 * @return
	 */
	<PO> int deletePo(PO object);

	/**
	 * 刪除
	 *
	 * @param datas
	 * @return
	 */
	<PO> int deletePo(List<PO> datas);

	/**
	 * 更新
	 *
	 * @param po
	 * @return
	 */
	<PO> int updatePo(PO po);

	/**
	 * 更新
	 *
	 * @param datas
	 * @return
	 */
	<PO> int updatePo(List<PO> datas);

	/**
	 * 新增或更新
	 *
	 * @param po
	 */
	<PO> void saveOrUpdatePo(PO po);
	
	/**
	 * 查詢
	 *
	 * @param poClass
	 * @param sqlWhere
	 * @return
	 */
	<PO> List<PO> selectPo(Class<PO> poClass, SqlWhere sqlWhere);

	/**
	 * 查詢
	 *
	 * @param po
	 * @return
	 */
	<PO> List<PO> selectPo(PO po);
	
	/**
	 * 查詢介面
	 * 
	 * @return
	 */
	SqlSelect getSqlSelect();

	/**
	 * 更新介面
	 * 
	 * @return
	 */
	SqlUpdate getSqlUpdate();
}
