package com.OMC.dtos.search;

import java.io.Serializable;

public class Search1ConDto implements Serializable {
	/**
	 * @uml.property  name="sttComYear"
	 */
	private int sttComYear;
	/**
	 * @uml.property  name="sttComClass"
	 */
	private String sttComClass;
	/**
	 * @uml.property  name="sttYear"
	 */
	private String sttYear;
	/**
	 * @uml.property  name="sttSmt"
	 */
	private String sttSmt;
	/**
	 * @uml.property  name="sttDeptCd"
	 */
	private String sttDeptCd;
	public Search1ConDto() {}
	public Search1ConDto(int sttComYear, String sttComClass, String sttYear,
			String sttSmt, String sttDeptCd) {
		super();
		this.sttComYear = sttComYear;
		this.sttComClass = sttComClass;
		this.sttYear = sttYear;
		this.sttSmt = sttSmt;
		this.sttDeptCd = sttDeptCd;
	}
	/**
	 * @return
	 * @uml.property  name="sttComYear"
	 */
	public int getSttComYear() {
		return sttComYear;
	}
	/**
	 * @param sttComYear
	 * @uml.property  name="sttComYear"
	 */
	public void setSttComYear(int sttComYear) {
		this.sttComYear = sttComYear;
	}
	/**
	 * @return
	 * @uml.property  name="sttComClass"
	 */
	public String getSttComClass() {
		return sttComClass;
	}
	/**
	 * @param sttComClass
	 * @uml.property  name="sttComClass"
	 */
	public void setSttComClass(String sttComClass) {
		this.sttComClass = sttComClass;
	}
	/**
	 * @return
	 * @uml.property  name="sttYear"
	 */
	public String getSttYear() {
		return sttYear;
	}
	/**
	 * @param sttYear
	 * @uml.property  name="sttYear"
	 */
	public void setSttYear(String sttYear) {
		this.sttYear = sttYear;
	}
	/**
	 * @return
	 * @uml.property  name="sttSmt"
	 */
	public String getSttSmt() {
		return sttSmt;
	}
	/**
	 * @param sttSmt
	 * @uml.property  name="sttSmt"
	 */
	public void setSttSmt(String sttSmt) {
		this.sttSmt = sttSmt;
	}
	/**
	 * @return
	 * @uml.property  name="sttDeptCd"
	 */
	public String getSttDeptCd() {
		return sttDeptCd;
	}
	/**
	 * @param sttDeptCd
	 * @uml.property  name="sttDeptCd"
	 */
	public void setSttDeptCd(String sttDeptCd) {
		this.sttDeptCd = sttDeptCd;
	}
	@Override
	public String toString() {
		return "Search1ConDto [sttComYear=" + sttComYear + ", sttComClass="
				+ sttComClass + ", sttYear=" + sttYear + ", sttSmt=" + sttSmt
				+ ", sttDeptCd=" + sttDeptCd + "]";
	}
}
