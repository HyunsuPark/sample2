package com.OMC.dtos.search;

import java.io.Serializable;

public class ProSearch3ConDto implements Serializable {

	private String sdcComtDept;
	private String aemKorNm;
	public ProSearch3ConDto() {
	}
	public ProSearch3ConDto(String sdcComtDept, String aemKorNm) {
		super();
		this.sdcComtDept = sdcComtDept;
		this.aemKorNm = aemKorNm;
	}
	@Override
	public String toString() {
		return "ProSearch3ConDto [sdcComtDept=" + sdcComtDept + ", aemKorNm="
				+ aemKorNm + "]";
	}
	public String getSdcComtDept() {
		return sdcComtDept;
	}
	public void setSdcComtDept(String sdcComtDept) {
		this.sdcComtDept = sdcComtDept;
	}
	public String getAemKorNm() {
		return aemKorNm;
	}
	public void setAemKorNm(String aemKorNm) {
		this.aemKorNm = aemKorNm;
	}
	
}
