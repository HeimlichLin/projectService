package com.heimlich.domain.project.po;

public interface FospFtzWorkStatsPoImpl {
	
	//get年度YYYY
		public String getYear();

		//set年度YYYY
		public void setYear(String year);
		//get月份MM
		public String getMonth();

		//set月份MM
		public void setMonth(String month);
		//get監管編號
		public String getBondno();

		//set監管編號
		public void setBondno(String bondno);
		//get港區
		public String getCustoms();

		//set港區
		public void setCustoms(String customs);
		//get稅則代碼
		public String getHs();

		//set稅則代碼
		public void setHs(String hs);
		//get目的國代碼
		public String getImportNat();

		//set目的國代碼
		public void setImportNat(String importNat);
		//get作業類別：A3委託加工、A5委託維修檢測、P區內加工、R 區內分割拆料、其他代碼物流
		public String getOptype();

		//set作業類別：A3委託加工、A5委託維修檢測、P區內加工、R 區內分割拆料、其他代碼物流
		public void setOptype(String optype);
		//get貿易量
		public java.math.BigDecimal getWgt();

		//set貿易量
		public void setWgt(java.math.BigDecimal wgt);
		//get貿易值
		public java.math.BigDecimal getCifob();

		//set貿易值
		public void setCifob(java.math.BigDecimal cifob);

}
