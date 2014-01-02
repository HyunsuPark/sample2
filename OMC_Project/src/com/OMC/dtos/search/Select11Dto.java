package com.OMC.dtos.search;

import java.io.Serializable;

public class Select11Dto implements Serializable {

	private String deptCd;
	private String deptNm;
	public Select11Dto() {
	}
	public Select11Dto(String deptCd, String deptNm) {
		super();
		this.deptCd = deptCd;
		this.deptNm = deptNm;
	}
	@Override
	public String toString() {
		return "Select11Dto [deptCd=" + deptCd + ", deptNm=" + deptNm + "]";
	}
	public String getDeptCd() {
		return deptCd;
	}
	public void setDeptCd(String deptCd) {
		this.deptCd = deptCd;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	
}
