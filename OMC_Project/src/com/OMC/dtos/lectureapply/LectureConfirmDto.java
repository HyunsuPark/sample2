package com.OMC.dtos.lectureapply;

public class LectureConfirmDto {

	//----------------------수강내역 조회
	private String curi_num; 		//학수번호
	private String curi_nm;			//과목명
	private String curi_class;		//강좌
	private String cont_desc;		//이수구분
	private String class_div;		//주야구분
	private String cdt_num;			//학점
	private String time_sheet;		//요일교시(강의실)
	private String kor_nm;			//담당교수
	private String recourse_div;	//수강구분
	private String pass_fail;		//승인
	
	//-----------------------학생정보 출력
	private String student_cd;
	//private String kor_nm;
	private String student_year;
	private String student_class;
	private String student_num;
	private String dept_nm;
	private String ent_year;
	
	//----------------------수강내역 조회조건
	//private String student_cd;
	private String year;
	private String smt;

	//----------------------졸업기준
	private String student_period;
	private String comdiv_cd1;		//교양
	private String comdiv_cd2;		//전공
	private String comdiv_cd3;		//PF
	
	public LectureConfirmDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getCuri_class() {
		return curi_class;
	}
	public void setCuri_class(String curi_class) {
		this.curi_class = curi_class;
	}
	public String getCont_desc() {
		return cont_desc;
	}
	public void setCont_desc(String cont_desc) {
		this.cont_desc = cont_desc;
	}
	public String getClass_div() {
		return class_div;
	}
	public void setClass_div(String class_div) {
		this.class_div = class_div;
	}
	public String getCdt_num() {
		return cdt_num;
	}
	public void setCdt_num(String cdt_num) {
		this.cdt_num = cdt_num;
	}
	public String getTime_sheet() {
		return time_sheet;
	}
	public void setTime_sheet(String time_sheet) {
		this.time_sheet = time_sheet;
	}
	public String getKor_nm() {
		return kor_nm;
	}
	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
	public String getRecourse_div() {
		return recourse_div;
	}
	public void setRecourse_div(String recourse_div) {
		this.recourse_div = recourse_div;
	}
	public String getPass_fail() {
		return pass_fail;
	}
	public void setPass_fail(String pass_fail) {
		this.pass_fail = pass_fail;
	}
	public String getStudent_cd() {
		return student_cd;
	}
	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
	}
	public String getStudent_year() {
		return student_year;
	}
	public void setStudent_year(String student_year) {
		this.student_year = student_year;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public String getStudent_num() {
		return student_num;
	}
	public void setStudent_num(String student_num) {
		this.student_num = student_num;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSmt() {
		return smt;
	}
	public void setSmt(String smt) {
		this.smt = smt;
	}
	public String getStudent_period() {
		return student_period;
	}
	public void setStudent_period(String student_period) {
		this.student_period = student_period;
	}
	public String getComdiv_cd1() {
		return comdiv_cd1;
	}
	public void setComdiv_cd1(String comdiv_cd1) {
		this.comdiv_cd1 = comdiv_cd1;
	}
	public String getComdiv_cd2() {
		return comdiv_cd2;
	}
	public void setComdiv_cd2(String comdiv_cd2) {
		this.comdiv_cd2 = comdiv_cd2;
	}
	public String getComdiv_cd3() {
		return comdiv_cd3;
	}
	public void setComdiv_cd3(String comdiv_cd3) {
		this.comdiv_cd3 = comdiv_cd3;
	}

	public String getEnt_year() {
		return ent_year;
	}

	public void setEnt_year(String ent_year) {
		this.ent_year = ent_year;
	}


	public LectureConfirmDto(String student_cd, String year, String smt) {
		super();
		this.student_cd = student_cd;
		this.year = year;
		this.smt = smt;
	}


	@Override
	public String toString() {
		return "LectureConfirmDto [curi_num=" + curi_num + ", curi_nm="
				+ curi_nm + ", curi_class=" + curi_class + ", cont_desc="
				+ cont_desc + ", class_div=" + class_div + ", cdt_num="
				+ cdt_num + ", time_sheet=" + time_sheet + ", kor_nm=" + kor_nm
				+ ", recourse_div=" + recourse_div + ", pass_fail=" + pass_fail
				+ ", student_cd=" + student_cd + ", student_year="
				+ student_year + ", student_class=" + student_class
				+ ", student_num=" + student_num + ", dept_nm=" + dept_nm
				+ ", ent_year=" + ent_year + ", year=" + year + ", smt=" + smt
				+ ", student_period=" + student_period + ", comdiv_cd1="
				+ comdiv_cd1 + ", comdiv_cd2=" + comdiv_cd2 + ", comdiv_cd3="
				+ comdiv_cd3 + "]";
	}
	public LectureConfirmDto(String curi_num, String curi_nm,
			String curi_class, String cont_desc, String class_div,
			String cdt_num, String time_sheet, String kor_nm,
			String recourse_div, String pass_fail, String student_cd,
			String student_year, String student_class, String student_num,
			String dept_nm, String year, String smt, String student_cd1,
			String student_cd2) {
		super();
		this.curi_num = curi_num;
		this.curi_nm = curi_nm;
		this.curi_class = curi_class;
		this.cont_desc = cont_desc;
		this.class_div = class_div;
		this.cdt_num = cdt_num;
		this.time_sheet = time_sheet;
		this.kor_nm = kor_nm;
		this.recourse_div = recourse_div;
		this.pass_fail = pass_fail;
		this.student_cd = student_cd;
		this.student_year = student_year;
		this.student_class = student_class;
		this.student_num = student_num;
		this.dept_nm = dept_nm;
		this.year = year;
		this.smt = smt;
	}
	public LectureConfirmDto(String kor_nm, String student_cd,
			String student_year, String student_class, String student_num,
			String dept_nm,String ent_year) {
		super();
		this.kor_nm = kor_nm;
		this.student_cd = student_cd;
		this.student_year = student_year;
		this.student_class = student_class;
		this.student_num = student_num;
		this.dept_nm = dept_nm;
		this.ent_year = ent_year;
	}


	public LectureConfirmDto(String student_period, String comdiv_cd1,
			String comdiv_cd2, String comdiv_cd3) {
		super();
		this.student_period = student_period;
		this.comdiv_cd1 = comdiv_cd1;
		this.comdiv_cd2 = comdiv_cd2;
		this.comdiv_cd3 = comdiv_cd3;
	}

	
}
