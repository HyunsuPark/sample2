package com.OMC.dtos.search;

import java.io.Serializable;

public class LecturePlanDto implements Serializable {
	private String curi_num1;//학수번호
	private String curi_nm1;//교과목명
	private String kor_nm1;//담당교수명
	private String smt;//학기
	
	public LecturePlanDto() {
		
	}
	
	public LecturePlanDto(String curi_num1, String curi_nm1, String kor_nm1,
			String smt) {
		super();
		this.curi_num1 = curi_num1;
		this.curi_nm1 = curi_nm1;
		this.kor_nm1 = kor_nm1;
		this.smt = smt;
	}
	@Override
	public String toString() {
		return "LecturePlanDto [curi_num1=" + curi_num1 + ", curi_nm1="
				+ curi_nm1 + ", kor_nm1=" + kor_nm1 + ", smt=" + smt + "]";
	}
	public String getCuri_num1() {
		return curi_num1;
	}
	public void setCuri_num1(String curi_num1) {
		this.curi_num1 = curi_num1;
	}
	public String getCuri_nm1() {
		return curi_nm1;
	}
	public void setCuri_nm1(String curi_nm1) {
		this.curi_nm1 = curi_nm1;
	}
	public String getKor_nm1() {
		return kor_nm1;
	}
	public void setKor_nm1(String kor_nm1) {
		this.kor_nm1 = kor_nm1;
	}
	public String getSmt() {
		return smt;
	}
	public void setSmt(String smt) {
		this.smt = smt;
	}
}
