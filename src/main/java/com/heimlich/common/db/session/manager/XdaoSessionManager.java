package com.heimlich.common.db.session.manager;

import com.heimlich.common.db.mapper.PoDaoMapper;
import com.heimlich.common.db.session.DoXdaoSession;
import com.tradevan.taurus.xdao.XdaoFactory;
import com.tradevan.taurus.xdao.XdaoSession;

public class XdaoSessionManager {	
	protected static XdaoFactory xdaoFactory = XdaoFactory.getInstance();
	private static ThreadLocal<XdaoSession> sessions = new ThreadLocal<XdaoSession>();
	protected static PoDaoMapper myMapper = new PoDaoMapper();
	
	public static XdaoSession getXdaoSession() {
		XdaoSession session = (XdaoSession) sessions.get();
		if (session == null) {
			if (xdaoFactory == null) {
				init();
			}
			session = new DoXdaoSession(xdaoFactory.getXdaoSession("fospConn"), myMapper);
			sessions.set(session);
		}
		return session;

	}

	public static DoXdaoSession getDoXdaoSession() {
		return (DoXdaoSession) getXdaoSession();
	}

	private static void init() {
		try {
			xdaoFactory = null;
			xdaoFactory = XdaoFactory.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
