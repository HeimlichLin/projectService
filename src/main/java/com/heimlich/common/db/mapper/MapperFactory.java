package com.heimlich.common.db.mapper;

import com.heimlich.common.db.dao.GeneralDAO;

public interface MapperFactory {
	
	<PO> GeneralDAO<PO> lookUpDAO(final PO po);
	
	<PO> GeneralDAO<PO> lookUpDAO(final Class<PO> pClass);

}
