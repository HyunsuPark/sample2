package com.OMC.dtos.search;

import java.io.Serializable;

public class Search3ConDto implements Serializable {

	private String aemEmpId;
	private String sttYear;
	private String sttSmt;
	
	public Search3ConDto() {
	}

	public String getAemEmpId() {
		return aemEmpId;
	}

	public void setAemEmpId(String aemEmpId) {
		this.aemEmpId = aemEmpId;
	}

	public String getSttYear() {
		return sttYear;
	}

	public void setSttYear(String sttYear) {
		this.sttYear = sttYear;
	}

	public String getSttSmt() {
		return sttSmt;
	}

	public void setSttSmt(String sttSmt) {
		this.sttSmt = sttSmt;
	}

	@Override
	public String toString() {
		return "Search3ConDto [aemEmpId=" + aemEmpId + ", sttYear=" + sttYear
				+ ", sttSmt=" + sttSmt + "]";
	}

	public Search3ConDto(String aemEmpId, String sttYear, String sttSmt) {
		super();
		this.aemEmpId = aemEmpId;
		this.sttYear = sttYear;
		this.sttSmt = sttSmt;
	}

	
}
