package com.heimlich.common.db.converter;

import com.tradevan.commons.collection.DataObject;

public interface MapConverter<PO> extends Po2DataObjectConverter<PO>, DataObject2PoConverter<PO> {

	PO convert(DataObject dataObject);

	DataObject toDataObject(PO po);
	
}
