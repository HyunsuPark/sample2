package com.OMC.dtos.search;

import java.io.Serializable;
//com.OMC.dtos.search.Search1Dto
public class Search1Dto implements Serializable {
	
	private String scmCuriNm;
	private String arcRoomNm;
	private String abcBldNm;
	private String aemKorNm;
	private String sttWeekDay;
	private String sttStartTime;
	private int sttComYear;
	private String sttComClass;
	
	public Search1Dto() {
	}

	public Search1Dto(String scmCuriNm, String arcRoomNm, String abcBldNm,
			String aemKorNm, String sttWeekDay, String sttStartTime,
			int sttComYear, String sttComClass) {
		super();
		this.scmCuriNm = scmCuriNm;
		this.arcRoomNm = arcRoomNm;
		this.abcBldNm = abcBldNm;
		this.aemKorNm = aemKorNm;
		this.sttWeekDay = sttWeekDay;
		this.sttStartTime = sttStartTime;
		this.sttComYear = sttComYear;
		this.sttComClass = sttComClass;
	}

	@Override
	public String toString() {
		return "Search1Dto [scmCuriNm=" + scmCuriNm + ", arcRoomNm="
				+ arcRoomNm + ", abcBldNm=" + abcBldNm + ", aemKorNm="
				+ aemKorNm + ", sttWeekDay=" + sttWeekDay + ", sttStartTime="
				+ sttStartTime + ", sttComYear=" + sttComYear
				+ ", sttComClass=" + sttComClass + "]";
	}

	public String getScmCuriNm() {
		return scmCuriNm;
	}

	public void setScmCuriNm(String scmCuriNm) {
		this.scmCuriNm = scmCuriNm;
	}

	public String getArcRoomNm() {
		return arcRoomNm;
	}

	public void setArcRoomNm(String arcRoomNm) {
		this.arcRoomNm = arcRoomNm;
	}

	public String getAbcBldNm() {
		return abcBldNm;
	}

	public void setAbcBldNm(String abcBldNm) {
		this.abcBldNm = abcBldNm;
	}

	public String getAemKorNm() {
		return aemKorNm;
	}

	public void setAemKorNm(String aemKorNm) {
		this.aemKorNm = aemKorNm;
	}

	public String getSttWeekDay() {
		return sttWeekDay;
	}

	public void setSttWeekDay(String sttWeekDay) {
		this.sttWeekDay = sttWeekDay;
	}

	public String getSttStartTime() {
		return sttStartTime;
	}

	public void setSttStartTime(String sttStartTime) {
		this.sttStartTime = sttStartTime;
	}

	public int getSttComYear() {
		return sttComYear;
	}

	public void setSttComYear(int sttComYear) {
		this.sttComYear = sttComYear;
	}

	public String getSttComClass() {
		return sttComClass;
	}

	public void setSttComClass(String sttComClass) {
		this.sttComClass = sttComClass;
	}


}


//--학년 반 별 조회
//SELECT scm.curi_nm, arc.room_nm, aem.kor_nm, stt.week_day, stt.start_time, stt.com_year, stt.com_class
//FROM (
//SELECT stt.year, stt.smt, stt.dept_cd, stt.com_year, stt.curi_num, stt.curi_class, stt.week_day, stt.start_time, sld.com_dept_cd, sld.com_class, stt.emp_id, stt.room_cd
//FROM scrt_time_table stt, scrt_lec_dept sld
//WHERE stt.year = sld.year and
//stt.smt = sld.smt and
//stt.dept_cd = sld.dept_cd and
//stt.com_year = sld.com_year and
//stt.curi_class = sld.curi_class and
//stt.curi_num = sld.curi_num
//) stt, scrt_curi_master scm, aeqt_room_cd arc, apst_emp_master aem
//WHERE stt.curi_num = scm.curi_num and
//stt.room_cd = arc.room_cd and
//stt.emp_id = aem.emp_id and
//stt.year = '2011' and
//stt.smt = '10' and
//stt.dept_cd = '1300110' and
//stt.com_year = '2' and
//stt.com_class = '2'
//order by stt.week_day, start_time;
