package org.thinker.dao;

import java.io.Serializable;

public class EmpVO implements Serializable {

	private Long empno;
	private String ename;
	private int viewCount; 
	
	
	public Long getEmpno() {
		return empno;
	}
	public void setEmpno(Long empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	
	
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
	@Override
	public String toString() {
		return "EmpVO [empno=" + empno + ", ename=" + ename + ", viewCount="
				+ viewCount + "]";
	}
	
	
}
