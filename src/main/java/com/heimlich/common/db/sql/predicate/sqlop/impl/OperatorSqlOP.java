package com.heimlich.common.db.sql.predicate.sqlop.impl;

import com.heimlich.common.db.sql.predicate.sqlop.SqlOp;


public enum OperatorSqlOP implements SqlOp{
	EQ("="), // 等於
	NE("!="), // 不等於
	LT("<"), // 小於
	GT(">"), // 大於
	LE("<="), // 小於等於
	GE(">="), // 大於等於
	LIKE("like");//
	;
	
	public final String op;
	
	private OperatorSqlOP(String op) {
		this.op = op;
	}

	@Override
	public String getOp() {
		return op;
	}

}
