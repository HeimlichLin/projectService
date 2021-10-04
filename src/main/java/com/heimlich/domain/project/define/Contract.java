package com.heimlich.domain.project.define;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Contract {
	LABEL_FontName_Type1("LABEL.FontName.Type1", "標楷體"), //	
	LABEL_YEAR("LABEL.YEAR", "年度"), //
	LABEL_CUSTCODE("LABEL.CustCode", "港區代碼"), //
	LABEL_FTZNAME("LABEL.FtzName", "事業名稱"), //
	LABEL_FOSPM101("LABEL.FOSPM101", "自由港區委託加工同類貨物統計"), //
	LABEL_WARM_ENTER("LABEL.WARM.ENTER", "請輸入") //
	;
	
	final String code;
	final String lable;
	final static Map<String, Contract> MAP;
	static {
		final Map<String, Contract> contractMap = new HashMap<String, Contract>();
		final EnumSet<Contract> contracts = EnumSet.allOf(Contract.class);
		for (Contract contract : contracts) {
			contractMap.put(contract.code, contract);
		}
		MAP = Collections.unmodifiableMap(contractMap);
	}

	public static String getTextFormCodes(String code) {
		if (!MAP.containsKey(code)) {
			return code;
		} else {
			return MAP.get(code).toText();
		}
	}

	private Contract(String code, String lable) {
		this.code = code;
		this.lable = lable;
	}

	public String getCode() {
		return code;
	}

	public String toLastKey() {
		return code;
	}

	public String toCode() {
		return code;
	}

	public String toText() {
		return lable;
	}

}
