package com.heimlich.domain.project.dao.impl;

import java.util.Map;

import com.heimlich.common.db.converter.MapConverter;
import com.heimlich.common.db.dao.impl.GeneralDAOImpl;
import com.heimlich.domain.common.utils.BigDecimalUtils;
import com.heimlich.domain.project.dao.FospFtzWorkStatsDAO;
import com.heimlich.domain.project.po.FospFtzWorkStatsPo;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.SqlWhere;

public class FospFtzWorkStatsDAOImpl extends GeneralDAOImpl<FospFtzWorkStatsPo>
		implements FospFtzWorkStatsDAO {

	public static final FospFtzWorkStatsDAOImpl INSTANCE = new FospFtzWorkStatsDAOImpl();
	
	protected Map<String, Object> values;
	protected boolean keySensitive = true;

	public FospFtzWorkStatsDAOImpl() {
		super("FOSP_FTZWORKSTATS");
	}

	protected static MapConverter<FospFtzWorkStatsPo> CONVERTER = new MapConverter<FospFtzWorkStatsPo>() {

		@Override
		public FospFtzWorkStatsPo convert(DataObject dataObject) {
			final FospFtzWorkStatsPo vo = new FospFtzWorkStatsPo();
			vo.setYear(dataObject.getString("YEAR"));
			vo.setMonth(dataObject.getString("MONTH"));
			vo.setBondno(dataObject.getString("BONDNO"));
			vo.setCustoms(dataObject.getString("CUSTOMS"));
			vo.setHs(dataObject.getString("HS"));
			vo.setImportNat(dataObject.getString("IMPORT_NAT"));
			vo.setOptype(dataObject.getString("OPTYPE"));
			vo.setWgt(BigDecimalUtils.formObj(dataObject.getValue("WGT")));
			vo.setCifob(BigDecimalUtils.formObj(dataObject.getValue("CIFOB")));
			return vo;
		}

		@Override
		public DataObject toDataObject(FospFtzWorkStatsPo po) {
			DataObject dataObject = new DataObject();
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.YEAR.name(),
					po.getYear());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.MONTH.name(),
					po.getMonth());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.BONDNO.name(),
					po.getBondno());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.CUSTOMS.name(),
					po.getCustoms());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.HS.name(),
					po.getHs());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.IMPORT_NAT.name(),
					po.getImportNat());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.OPTYPE.name(),
					po.getOptype());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.WGT.name(),
					po.getWgt());
			dataObject.setValue(FospFtzWorkStatsPo.COLUMNS.CIFOB.name(),
					po.getCifob());
			return dataObject;
		}
	};

	@Override
	public MapConverter<FospFtzWorkStatsPo> getConverter() {
		return CONVERTER;
	}

	@Override
	public SqlWhere getPkSqlWhere(FospFtzWorkStatsPo po) {
		SqlWhere sqlWhere = new SqlWhere();
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.YEAR.name(), po.getYear());
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.MONTH.name(), po.getMonth());
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.BONDNO.name(), po.getBondno());
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.HS.name(), po.getHs());
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.IMPORT_NAT.name(),
				po.getImportNat());
		sqlWhere.add(FospFtzWorkStatsPo.COLUMNS.OPTYPE.name(), po.getOptype());
		return sqlWhere;
	}
	
	public void setValue(String key, Object value) {
		if (key != null) {
			if (this.keySensitive) {
				this.values.put(key, value);
			} else {
				this.values.put(key.toUpperCase(), value);
			}
		}

	}

}
