package com.OMC.dtos.lectureapply;

import java.io.Serializable;

public class StuSearchDto implements Serializable {

	private String slaCuriNm;
	private String aemKorNm;
	private String abcBldNm;
	private String arcRoomNm;
	private String sttWeekDay;
	private String sttStartTime;
	public StuSearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StuSearchDto(String slaCuriNm, String aemKorNm, String abcBldNm,
			String arcRoomNm, String sttWeekDay, String sttStartTime) {
		super();
		this.slaCuriNm = slaCuriNm;
		this.aemKorNm = aemKorNm;
		this.abcBldNm = abcBldNm;
		this.arcRoomNm = arcRoomNm;
		this.sttWeekDay = sttWeekDay;
		this.sttStartTime = sttStartTime;
	}
	@Override
	public String toString() {
		return "StuSearchDto [slaCuriNm=" + slaCuriNm + ", aemKorNm="
				+ aemKorNm + ", abcBldNm=" + abcBldNm + ", arcRoomNm="
				+ arcRoomNm + ", sttWeekDay=" + sttWeekDay + ", sttStartTime="
				+ sttStartTime + "]";
	}
	public String getSlaCuriNm() {
		return slaCuriNm;
	}
	public void setSlaCuriNm(String slaCuriNm) {
		this.slaCuriNm = slaCuriNm;
	}
	public String getAemKorNm() {
		return aemKorNm;
	}
	public void setAemKorNm(String aemKorNm) {
		this.aemKorNm = aemKorNm;
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
