package com.heimlich.common.db.sql.predicate.sqlop.impl;

import com.heimlich.common.db.sql.predicate.sqlop.SqlOp;


public enum ExtractSqlOp implements SqlOp {
	IN("IN"),//
	BETWEEN("BETWEEN"),//
	;
	
	public final String op;
	
	private ExtractSqlOp(String op) {
		this.op = op;
	}

	@Override
	public String getOp() {
		return op;
	}

}
