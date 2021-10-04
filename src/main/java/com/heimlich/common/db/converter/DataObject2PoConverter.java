package com.heimlich.common.db.converter;

import com.tradevan.commons.collection.DataObject;

public interface DataObject2PoConverter<PO> {
	
	PO convert(DataObject dataObject);

}
