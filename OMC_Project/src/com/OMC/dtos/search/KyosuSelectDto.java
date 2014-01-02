package com.OMC.dtos.search;

import java.io.Serializable;

public class KyosuSelectDto implements Serializable {
	/**
	 * 
	 */
	private String dept_cd;//학과코드
	private String dept_nm;//학과명
	public KyosuSelectDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KyosuSelectDto(String dept_cd, String dept_nm) {
		super();
		this.dept_cd = dept_cd;
		this.dept_nm = dept_nm;
	}
	@Override
	public String toString() {
		return "KyosuSelectDto [dept_cd=" + dept_cd + ", dept_nm=" + dept_nm
				+ "]";
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
}
