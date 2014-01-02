package com.OMC.dtos.lectureapply;

import java.io.Serializable;

public class StuSearchConDto implements Serializable {

	private String slaYear;
	private String slaSmt;
	private String slaStuId;
	public StuSearchConDto() {
	}
	public StuSearchConDto(String slaYear, String slaSmt, String slaStuId) {
		super();
		this.slaYear = slaYear;
		this.slaSmt = slaSmt;
		this.slaStuId = slaStuId;
	}
	@Override
	public String toString() {
		return "StuSearchConDto [slaYear=" + slaYear + ", slaSmt=" + slaSmt
				+ ", slaStuId=" + slaStuId + "]";
	}
	public String getSlaYear() {
		return slaYear;
	}
	public void setSlaYear(String slaYear) {
		this.slaYear = slaYear;
	}
	public String getSlaSmt() {
		return slaSmt;
	}
	public void setSlaSmt(String slaSmt) {
		this.slaSmt = slaSmt;
	}
	public String getSlaStuId() {
		return slaStuId;
	}
	public void setSlaStuId(String slaStuId) {
		this.slaStuId = slaStuId;
	}
	
	
}
