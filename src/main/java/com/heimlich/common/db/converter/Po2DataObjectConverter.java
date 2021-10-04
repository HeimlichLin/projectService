package com.heimlich.common.db.converter;

import com.tradevan.commons.collection.DataObject;

public interface Po2DataObjectConverter<PO> {
	
	DataObject toDataObject(PO po);

}
