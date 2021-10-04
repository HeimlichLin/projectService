package com.heimlich.domain.project.po;

public class FospFtzWorkStatsPo implements FospFtzWorkStatsPoImpl {
	
	public enum COLUMNS {
		YEAR("年度YYYY", true), //
		MONTH("月份MM", true), //
		BONDNO("監管編號", true), //
		CUSTOMS("港區", false), //
		HS("稅則代碼", true), //
		IMPORT_NAT("目的國代碼", true), //
		OPTYPE("作業類別：A3委託加工、A5委託維修檢測、P區內加工、R 區內分割拆料、其他代碼物流", true), //
		WGT("貿易量", false), //
		CIFOB("貿易值", false), //
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
	}

	private String year;// 年度yyyy
	private String month;// 月份mm
	private String bondno;// 監管編號
	private String customs;// 港區
	private String hs;// 稅則代碼
	private String importNat;// 目的國代碼
	private String optype;// 作業類別：a3委託加工、a5委託維修檢測、p區內加工、r 區內分割拆料、其他代碼物流
	private java.math.BigDecimal wgt;// 貿易量
	
	private java.math.BigDecimal cifob;// 貿易值

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getBondno() {
		return bondno;
	}

	public void setBondno(String bondno) {
		this.bondno = bondno;
	}

	public String getCustoms() {
		return customs;
	}

	public void setCustoms(String customs) {
		this.customs = customs;
	}

	public String getHs() {
		return hs;
	}

	public void setHs(String hs) {
		this.hs = hs;
	}

	public String getImportNat() {
		return importNat;
	}

	public void setImportNat(String importNat) {
		this.importNat = importNat;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public java.math.BigDecimal getWgt() {
		return wgt;
	}

	public void setWgt(java.math.BigDecimal wgt) {
		this.wgt = wgt;
	}

	public java.math.BigDecimal getCifob() {
		return cifob;
	}

	public void setCifob(java.math.BigDecimal cifob) {
		this.cifob = cifob;
	}

}
