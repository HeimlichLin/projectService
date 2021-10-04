package com.heimlich.domain.project.service.fospm1.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.heimlich.common.db.converter.DataObject2PoConverter;
import com.heimlich.common.db.session.DoXdaoSession;
import com.heimlich.common.db.session.manager.XdaoSessionManager;
import com.heimlich.common.db.sql.SqlSelect;
import com.heimlich.common.db.utils.CommonDBStringUtils;
import com.heimlich.domain.common.codes.briefcode.impl.BriefCodeComponentFactory;
import com.heimlich.domain.common.codes.define.BriefCodes;
import com.heimlich.domain.project.dto.fospm1.impl.Fospm101QueryDTO;
import com.heimlich.domain.project.dto.fospm1.impl.Fospm101ResultDTO;
import com.heimlich.domain.project.service.fospm1.Fospm101Service;
import com.tradevan.commons.collection.DataObject;

public class Fospm101ServiceImpl implements Fospm101Service {
	private XdaoSessionManager xdaoSessionManager = new XdaoSessionManager();
	
	private class MyConverter implements DataObject2PoConverter<Fospm101ResultDTO> {
		final Fospm101QueryDTO queryDTO;

		public MyConverter(Fospm101QueryDTO queryDTO) {
			this.queryDTO = queryDTO;
		}
		@Override
		public Fospm101ResultDTO convert(DataObject dataObject) {
			final Fospm101ResultDTO resultDTO = new Fospm101ResultDTO();
			
			resultDTO.setYear(dataObject.getString("YEAR"));
			resultDTO.setBondno(this.getText(BriefCodes.FOSP_FTZBAN.name(), dataObject.getString("BONDNO")));
			
			resultDTO.setWgt(this.getNoFormate("WGT", dataObject));
			resultDTO.setCifob(this.getNoFormate("CIFOB", dataObject));
			return resultDTO;
		}
		
		private String getNoFormate(String col, DataObject dataObject) {
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");
			double value = Double.parseDouble(nal(dataObject.getString(col), 0));
			return String.valueOf(decimalFormat.format(value));
		}

		private String nal(String val, Object val2) {
			if (val == null || val.equals(""))
				return val2.toString();
			return val;
		}
		public String getText(final String category, final String keys){
			return BriefCodeComponentFactory.get().getTextFormCodes(category, keys);
		}
		
	}
	
	@Override
	public List<Fospm101ResultDTO> query(Fospm101QueryDTO queryDTO) {
		final DoXdaoSession doXdaoSession = xdaoSessionManager.getDoXdaoSession();
		final String sqlString = this.getSql(queryDTO);
		final SqlSelect sqlSelect = doXdaoSession.getSqlSelect();
		return sqlSelect.select(new MyConverter(queryDTO), sqlString);
	}

	public String getSql(Fospm101QueryDTO queryDTO) {
		String select = "";
		String where = "";
		String group = "";
		String order = "";
		
			
			if (StringUtils.isNotEmpty(queryDTO.getYear())) {
				select += " a.year ";
				group += " a.year ";
				order += " a.year ";
				where += " a.year = " + queryDTO.getYear();
			}
		
		if (StringUtils.isNotEmpty(queryDTO.getCustCode())) {
			where += " and c.reportcustid in ("
					+ CommonDBStringUtils.getSqlComa(queryDTO.getCustCodeList())
					+ ")";
		}

		if (StringUtils.isNotEmpty(queryDTO.getFtzName())) {
			group += " , a.bondno ";
			order += " , a.bondno ";
			where += " and a.bondno in ("
					+ CommonDBStringUtils.getSqlComa(queryDTO.getFtzNameList())
					+ ")";
		}

		StringBuffer sb = new StringBuffer();
		sb.append(" Select " + select + " c.reportcustid ")
				.append(" , nvl(sum(a.wgt), 0) / 1000 wgt, nvl(sum(a.cifob), 0) / 1000 cifob ")
				.append(" from fosp_ftzworkstats a ")
				.append(" left join fosp_report_cust c on a.customs = c.custid ")
				.append(" left join fosp_countrycode e on a.import_nat = e.countryid ")
				.append(" where " + where)
				.append(" group by " + group + " , c.reportcustid ")
				.append(" order by  " + order + " , c.reportcustid asc ");
		return sb.toString();
	}

}
