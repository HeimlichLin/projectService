package com.heimlich.domain.project.dto.fospm2;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.heimlich.domain.project.dao.impl.FospFtzWorkStatsDAOImpl;

public class Fospm202DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String file1ContentType;
	private File file1;
	private String file1FileName;
	private String openId;
	private String year;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	private List<FospFtzWorkStatsDAOImpl> mccsList = new ArrayList<FospFtzWorkStatsDAOImpl>();

	public String getFile1ContentType() {
		return file1ContentType;
	}

	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}

	public File getFile1() {
		return file1;
	}

	public void setFile1(File file1) {
		this.file1 = file1;
	}

	public String getFile1FileName() {
		return file1FileName;
	}

	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}

	public List<FospFtzWorkStatsDAOImpl> getMccsList() {
		return mccsList;
	}

	public void setMccsList(List<FospFtzWorkStatsDAOImpl> mccsList) {
		this.mccsList = mccsList;
	}

	@Override
	public String toString() {
		return "Fospm202DTO [file1ContentType=" + file1ContentType + ", file1=" + file1 + ", file1FileName="
				+ file1FileName + ", openId=" + openId + ", year=" + year + ", mccsList=" + mccsList + "]";
	}

}
