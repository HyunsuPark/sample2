package com.OMC.dtos.search;

import java.io.Serializable;

public class Search3Dto implements Serializable {

	private String abcBldNm;
	private String arcRoomNm;
	private String scmCuriNm;
	private String sttWeekDay;
	private String sttStartTime;
	public Search3Dto() {
	}
	public Search3Dto(String abcBldNm, String arcRoomNm, String scmCuriNm,
			String sttWeekDay, String sttStartTime) {
		super();
		this.abcBldNm = abcBldNm;
		this.arcRoomNm = arcRoomNm;
		this.scmCuriNm = scmCuriNm;
		this.sttWeekDay = sttWeekDay;
		this.sttStartTime = sttStartTime;
	}
	@Override
	public String toString() {
		return "Search3Dto [abcBldNm=" + abcBldNm + ", arcRoomNm=" + arcRoomNm
				+ ", scmCuriNm=" + scmCuriNm + ", sttWeekDay=" + sttWeekDay
				+ ", sttStartTime=" + sttStartTime + "]";
	}
	public String getAbcBldNm() {
		return abcBldNm;
	}
	public void setAbcBldNm(String abcBldNm) {
		this.abcBldNm = abcBldNm;
	}
	public String getArcRoomNm() {
		return arcRoomNm;
	}
	public void setArcRoomNm(String arcRoomNm) {
		this.arcRoomNm = arcRoomNm;
	}
	public String getScmCuriNm() {
		return scmCuriNm;
	}
	public void setScmCuriNm(String scmCuriNm) {
		this.scmCuriNm = scmCuriNm;
	}
	public String getSttWeekDay() {
		return sttWeekDay;
	}
	public void setSttWeekDay(String sttWeekDay) {
		this.sttWeekDay = sttWeekDay;
	}
	public String getSttStartTime() {
		return sttStartTime;
	}
	public void setSttStartTime(String sttStartTime) {
		this.sttStartTime = sttStartTime;
	}
	
}
