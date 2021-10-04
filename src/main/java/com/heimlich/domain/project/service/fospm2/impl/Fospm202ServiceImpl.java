package com.heimlich.domain.project.service.fospm2.impl;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.heimlich.common.exception.ApBusinessException;
import com.heimlich.domain.project.dao.FospFtzWorkStatsDAO;
import com.heimlich.domain.project.dao.impl.FospFtzWorkStatsDAOImpl;
import com.heimlich.domain.project.dto.fospm2.Fospm202DTO;
import com.heimlich.domain.project.service.fospm2.Fospm202Service;
import com.tradevan.commons.collection.DataObject;
import com.tradevan.taurus.xdao.XdaoException;

public class Fospm202ServiceImpl implements Fospm202Service {	
//	private transient FospEifMccService fospEifMccService = new FospEifMccService();
	private final static String MYPASSWORD = "1055003857";

	@Override
	public void insertData(Fospm202DTO dto) {
		dto = this.load(dto);

	}

	public enum COLUMNS {
		DECLTYPE("申請書類別", false), //
		PORT("港口別", false), // (A：基隆, B：高雄, D：台中)
		CUSTID("關別代碼", false), //
		DECLNO("申請書號碼(進口編號)", false), //
		PORTID("起運口岸", false), //
		STORWARECD("目的地(卸存地)代碼", false), //
		STATDATE("統計月份", false) {
			@Override
			public FospFtzWorkStatsDAO set(FospFtzWorkStatsDAO fospEifMccDo, String value, Fospm202DTO dto) {
				fospEifMccDo.setValue(this.name(), dto.getYear() + value);
				return fospEifMccDo;
			}
		}, //
		GROSS("毛重", false) {
			@Override
			public FospFtzWorkStatsDAO set(FospFtzWorkStatsDAO fospEifMccDo, String value, Fospm202DTO dto) {
				if (StringUtils.isNotBlank(value)) {
					fospEifMccDo.setValue(this.name(), new BigDecimal(value));
				}

				return fospEifMccDo;
			}
		}, //
		TRANSCUSID("轉至關別", false), //
		IM_VESSEL_REG_NO("海關通關號碼-進口", false), //
		IM_MANIF_NO("艙單號碼-進口", false), //
		IM_MAWB_NO("主提單號碼-進口", false), //
		IM_HAWB_NO("分提單號碼-進口", false), //
		EX_VESSEL_REG_NO("海關通關號碼-出口", false), //
		EX_MANIF_NO("裝貨單號碼-出口", false), //
		EX_MAWB_NO("託運單主號-出口", false), //
		EX_HAWB_NO("託運單分號-出口", false), //
		DESCRIP("貨物名稱", false), //
		CONTR_NO("貨櫃號碼", false), //
		SHIPMENT_PLACE_CODE("起運地點代碼", false), //

		NOFILE("查無欄位", false) {
			@Override
			public FospFtzWorkStatsDAO set(FospFtzWorkStatsDAO fospEifMccDo, String value, Fospm202DTO dto) {

				return fospEifMccDo;
			}
		}, //
		;//
		final String chineseName;
		final boolean isPK;

		private COLUMNS(String chineseName, boolean isPK) {
			this.chineseName = chineseName;
			this.isPK = isPK;
		}

		public String getChineseName() {
			return chineseName;
		}

		public boolean isPK() {
			return isPK;
		}

		public FospFtzWorkStatsDAO set(FospFtzWorkStatsDAO fospEifMccDo, String value, Fospm202DTO dto) {
			fospEifMccDo.setValue(this.name(), value);
			return fospEifMccDo;
		}

		final static Map<String, COLUMNS> MAP;
		static {
			final Map<String, COLUMNS> contractMap = new HashMap<String, COLUMNS>();
			final EnumSet<COLUMNS> contracts = EnumSet.allOf(COLUMNS.class);
			for (COLUMNS contract : contracts) {
				contractMap.put(contract.chineseName, contract);
			}
			MAP = Collections.unmodifiableMap(contractMap);
		}

		public static COLUMNS lookup(String chineseName) {

			for (Map.Entry<String, COLUMNS> entry : MAP.entrySet()) {
				if (chineseName.startsWith(entry.getKey())) {
					return entry.getValue();
				}

			}
			return null;
		}
	}

	private Fospm202DTO load(Fospm202DTO dto) {

		dto = this.loadExecelData(dto);
		this.insertFospEifMcc(dto);
		return dto;

	}

	private void insertFospEifMcc(Fospm202DTO dto) {
		for (FospFtzWorkStatsDAO dao : dto.getMccsList()) {
			this.insert(dao);
		}

	}

	private Fospm202DTO loadExecelData(Fospm202DTO dto) {
		try {
			final FileInputStream inp = new FileInputStream(dto.getFile1());//
			final HSSFWorkbook wb = new HSSFWorkbook(inp);

			final HSSFSheet sheet = wb.getSheetAt(0);
			List<COLUMNS> columns = localColums(sheet);
			List<FospFtzWorkStatsDAOImpl> dao = new ArrayList<FospFtzWorkStatsDAOImpl>();
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				HSSFRow hssfrow = sheet.getRow(i);
				int cellNo = 0;
				FospFtzWorkStatsDAOImpl po = new FospFtzWorkStatsDAOImpl();
				for (COLUMNS column : columns) {
					HSSFCell hssfcell = hssfrow.getCell((short) cellNo++);
					final String lable = hssfcell.getStringCellValue();
					column.set(po, lable, dto);
				}
				dao.add(po);
			}
			dto.setMccsList(dao);
		} catch (Exception e) {
//			throw new ApBusinessException("解析錯誤", e);
		}

		return dto;
	}

	private List<COLUMNS> localColums(HSSFSheet sheet) {
		List<COLUMNS> colums = new ArrayList<Fospm202ServiceImpl.COLUMNS>();
		HSSFRow hssfrow = sheet.getRow(0);
		int index = 0;
		while (true) {
			HSSFCell hssfcell = hssfrow.getCell((short) index++);
			if (hssfcell == null || StringUtils.isBlank(hssfcell.getStringCellValue())) {
				break;
			} else {
				final String lable = hssfcell.getStringCellValue();
				COLUMNS column = COLUMNS.lookup(lable);
				if (column != null) {
					colums.add(column);
				} else {
					colums.add(COLUMNS.NOFILE);
				}
			}
		}
		return colums;
	}
	
	public int insert(FospFtzWorkStatsDAO dao) {
		return 0;
	}
	
}