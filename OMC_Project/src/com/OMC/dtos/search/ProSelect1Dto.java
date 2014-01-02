package com.OMC.dtos.search;

import java.io.Serializable;

public class ProSelect1Dto implements Serializable {

	private String comDeptCd;
	private String attest;
	public ProSelect1Dto() {
	}
	public ProSelect1Dto(String comDeptCd, String attest) {
		super();
		this.comDeptCd = comDeptCd;
		this.attest = attest;
	}
	@Override
	public String toString() {
		return "ProSelect1Dto [comDeptCd=" + comDeptCd + ", attest=" + attest
				+ "]";
	}
	public String getComDeptCd() {
		return comDeptCd;
	}
	public void setComDeptCd(String comDeptCd) {
		this.comDeptCd = comDeptCd;
	}
	public String getAttest() {
		return attest;
	}
	public void setAttest(String attest) {
		this.attest = attest;
	}
	
}
