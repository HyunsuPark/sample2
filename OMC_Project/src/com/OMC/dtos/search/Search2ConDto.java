package com.OMC.dtos.search;

import java.io.Serializable;

public class Search2ConDto implements Serializable {

	private String sttBldCd;
	private String arcRoomCd;
	private String sttYear;
	private String sttSmt;
	public Search2ConDto() {
	}
	public Search2ConDto(String sttBldCd, String arcRoomCd, String sttYear,
			String sttSmt) {
		super();
		this.sttBldCd = sttBldCd;
		this.arcRoomCd = arcRoomCd;
		this.sttYear = sttYear;
		this.sttSmt = sttSmt;
	}
	@Override
	public String toString() {
		return "Search2ConDto [sttBldCd=" + sttBldCd + ", arcRoomCd="
				+ arcRoomCd + ", sttYear=" + sttYear + ", sttSmt=" + sttSmt
				+ "]";
	}
	public String getSttBldCd() {
		return sttBldCd;
	}
	public void setSttBldCd(String sttBldCd) {
		this.sttBldCd = sttBldCd;
	}
	public String getArcRoomCd() {
		return arcRoomCd;
	}
	public void setArcRoomCd(String arcRoomCd) {
		this.arcRoomCd = arcRoomCd;
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
	
}
