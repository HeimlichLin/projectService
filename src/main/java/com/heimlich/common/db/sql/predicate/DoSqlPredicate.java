package com.heimlich.common.db.sql.predicate;

import java.util.List;

import com.heimlich.common.db.sql.predicate.sqlop.impl.ExtractSqlOp;
import com.heimlich.common.db.sql.predicate.sqlop.impl.OperatorSqlOP;
import com.heimlich.common.db.utils.CommonDBStringUtils;
import com.tradevan.taurus.xdao.SqlPredicate;

public class DoSqlPredicate extends SqlPredicate {	
	private static final long serialVersionUID = 1L;
	
	public DoSqlPredicate(final String field, final OperatorSqlOP sqlNote, final String value) {
		super(field, sqlNote.op, value, false, false);
	}

	public DoSqlPredicate(final String field, final ExtractSqlOp sqlNote, final List<String> value) {
		super(field, sqlNote.op, "(" + CommonDBStringUtils.getSqlComa(value) + ")", false, false);
	}

}
