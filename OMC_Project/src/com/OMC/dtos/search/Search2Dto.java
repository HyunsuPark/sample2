package com.OMC.dtos.search;

import java.io.Serializable;

public class Search2Dto implements Serializable {

	private String sdcDeptNm;
	private String scmCuriNm;
	private String aemKorNm;
	private String sttStartTime;
	private String sttWeekDay;
	public Search2Dto() {
	}
	public Search2Dto(String sdcDeptNm, String scmCuriNm, String aemKorNm,
			String sttStartTime, String sttWeekDay) {
		super();
		this.sdcDeptNm = sdcDeptNm;
		this.scmCuriNm = scmCuriNm;
		this.aemKorNm = aemKorNm;
		this.sttStartTime = sttStartTime;
		this.sttWeekDay = sttWeekDay;
	}
	@Override
	public String toString() {
		return "Search2Dto [sdcDeptNm=" + sdcDeptNm + ", scmCuriNm="
				+ scmCuriNm + ", aemKorNm=" + aemKorNm + ", sttStartTime="
				+ sttStartTime + ", sttWeekDay=" + sttWeekDay + "]";
	}
	public String getSdcDeptNm() {
		return sdcDeptNm;
	}
	public void setSdcDeptNm(String sdcDeptNm) {
		this.sdcDeptNm = sdcDeptNm;
	}
	public String getScmCuriNm() {
		return scmCuriNm;
	}
	public void setScmCuriNm(String scmCuriNm) {
		this.scmCuriNm = scmCuriNm;
	}
	public String getAemKorNm() {
		return aemKorNm;
	}
	public void setAemKorNm(String aemKorNm) {
		this.aemKorNm = aemKorNm;
	}
	public String getSttStartTime() {
		return sttStartTime;
	}
	public void setSttStartTime(String sttStartTime) {
		this.sttStartTime = sttStartTime;
	}
	public String getSttWeekDay() {
		return sttWeekDay;
	}
	public void setSttWeekDay(String sttWeekDay) {
		this.sttWeekDay = sttWeekDay;
	}
	

}
