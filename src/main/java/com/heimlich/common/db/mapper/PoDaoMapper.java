package com.heimlich.common.db.mapper;

import com.heimlich.common.db.dao.GeneralDAO;

public class PoDaoMapper implements MapperFactory {

	@Override
	public <PO> GeneralDAO<PO> lookUpDAO(PO po) {
		return TableMapper.lookupDAO(po);
	}

	@Override
	public <PO> GeneralDAO<PO> lookUpDAO(Class<PO> pClass) {
		// TODO Auto-generated method stub
		return TableMapper.lookupDAO(pClass);
	}

}
