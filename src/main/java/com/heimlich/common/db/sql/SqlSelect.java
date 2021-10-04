package com.heimlich.common.db.sql;

import java.util.List;

import com.heimlich.common.db.converter.DataObject2PoConverter;
import com.tradevan.commons.collection.DataObject;

public interface SqlSelect {

	<PO> List<PO> select(DataObject2PoConverter<PO> convertec, String sql);
	
	List<DataObject> select(String sql);
	
}
