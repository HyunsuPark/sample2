package com.OMC.dtos.search;

import java.io.Serializable;

public class Select21Dto implements Serializable {

	private String bldCd;
	private String bldNm;
	public Select21Dto() {
	}
	public Select21Dto(String bldCd, String bldNm) {
		super();
		this.bldCd = bldCd;
		this.bldNm = bldNm;
	}
	@Override
	public String toString() {
		return "Select21Dto [bldCd=" + bldCd + ", bldNm=" + bldNm + "]";
	}
	public String getBldCd() {
		return bldCd;
	}
	public void setBldCd(String bldCd) {
		this.bldCd = bldCd;
	}
	public String getBldNm() {
		return bldNm;
	}
	public void setBldNm(String bldNm) {
		this.bldNm = bldNm;
	}

	
}
