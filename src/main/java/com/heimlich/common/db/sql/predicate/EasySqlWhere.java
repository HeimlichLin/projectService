package com.heimlich.common.db.sql.predicate;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.heimlich.common.db.sql.predicate.sqlop.impl.ExtractSqlOp;
import com.heimlich.common.db.sql.predicate.sqlop.impl.OperatorSqlOP;
import com.tradevan.taurus.xdao.SqlWhere;

public class EasySqlWhere extends SqlWhere {	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param isRequire 是否必填
	 * @param field 
	 * @param op
	 * @param value
	 */
	public void add(boolean isRequire, final String field, final OperatorSqlOP op, final String value) {
		if (isRequire || StringUtils.isNotBlank(value)) {
			super.add(new DoSqlPredicate(field, op, "'"+value+"'"));
		}
	}
	
	/**
	 * 新增非必為查詢條件之SQL
	 * @param field
	 * @param op
	 * @param value
	 */
	public void add( final String field, final OperatorSqlOP op, final String value) {
		this.add(false, field, op, value);
	}

	/**
	 * 
	 * @param isRequire 是否必填
	 * @param field 欄位
	 * @param op 運算式
	 * @param value 值
	 */
	
	public void add(boolean isRequire, String field, final ExtractSqlOp op, final List<String> value) {
		if (isRequire || CollectionUtils.isNotEmpty(value)) {
			super.add(new DoSqlPredicate(field, op, value));
		}
	}
	
	/**
	 * 新增非必為查詢條件之SQL
	 * @param field
	 * @param op 運算式
	 * @param value
	 */
	public void add( String field, final ExtractSqlOp op, final List<String> value) {
		this.add(false, field, op, value);
	}

}
