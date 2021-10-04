package com.heimlich.domain.project.model;

import com.heimlich.common.db.session.DoXdaoSession;
import com.heimlich.common.db.session.manager.XdaoSessionManager;
import com.heimlich.domain.common.codes.define.BriefCodes;
import com.tradevan.commons.collection.DataList;
import com.tradevan.taurus.xdao.XdaoException;

public class CodesModel {
	private XdaoSessionManager xdaoSessionManager = new XdaoSessionManager();
	public static CodesModel INSTANCE = new CodesModel();
	public static final String TABLE = "PFOSPMGR.FOSP_APPLICATION";
	
	public CodesModel() {
		
	}
	
	public String getTableName() {
		return TABLE;
	}

	public DataList queryTable(BriefCodes codeDefine) {
		final DoXdaoSession doXdaoSession = xdaoSessionManager.getDoXdaoSession();
		try {
			final String sql = codeDefine.toSQL();
			return doXdaoSession.executeQuery(sql, null);
		} catch (XdaoException e) {
			e.printStackTrace();
			return new DataList();
		}
	}

//	public Class getBeanClass() {
//		return FospApplicationDo.class;
//	}

//	/**
//	 * 取得primary key
//	 */
//	public String getPrimaryKey() {
//		return FospApplicationDo.PRIMARY_KEY_STRING;
//	}
//
//	public String[] getDefaultOrderBy() {
//		return FospApplicationDo.PRIMARY_KEY;
//	}
//
//	public String[] getPrimaryIndex() {
//		return FospApplicationDo.PRIMARY_KEY;
//	}
	
}
