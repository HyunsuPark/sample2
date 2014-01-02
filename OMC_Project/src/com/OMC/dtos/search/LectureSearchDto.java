package com.OMC.dtos.search;
//com.OMC.dtos.search.LectureSearchDto
import java.io.Serializable;
import java.util.Date;

public class LectureSearchDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5232758895772147145L;
	private String curi_num;//학수번호
	private String curi_nm;//교과목명
	private String curi_nm_eng;//영문교과목명
	private String dept_nm;//주관학과명
	private String cre_dt;//신설일자
	private String close_dt;//폐지일자
	
	public LectureSearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LectureSearchDto(String curi_num, String curi_nm,
			String curi_nm_eng, String dept_nm, String cre_dt, String close_dt) {
		super();
		this.curi_num = curi_num;
		this.curi_nm = curi_nm;
		this.curi_nm_eng = curi_nm_eng;
		this.dept_nm = dept_nm;
		this.cre_dt = cre_dt;
		this.close_dt = close_dt;
	}

	@Override
	public String toString() {
		return "LectureSearchDto [curi_num=" + curi_num + ", curi_nm="
				+ curi_nm + ", curi_nm_eng=" + curi_nm_eng + ", dept_nm="
				+ dept_nm + ", cre_dt=" + cre_dt + ", close_dt=" + close_dt
				+ "]";
	}

	public String getCuri_num() {
		return curi_num;
	}

	public void setCuri_num(String curi_num) {
		this.curi_num = curi_num;
	}

	public String getCuri_nm() {
		return curi_nm;
	}

	public void setCuri_nm(String curi_nm) {
		this.curi_nm = curi_nm;
	}

	public String getCuri_nm_eng() {
		return curi_nm_eng;
	}

	public void setCuri_nm_eng(String curi_nm_eng) {
		this.curi_nm_eng = curi_nm_eng;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}

	public String getCre_dt() {
		return cre_dt;
	}

	public void setCre_dt(String cre_dt) {
		this.cre_dt = cre_dt;
	}

	public String getClose_dt() {
		return close_dt;
	}

	public void setClose_dt(String close_dt) {
		this.close_dt = close_dt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
