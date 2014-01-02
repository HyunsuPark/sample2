package com.OMC.dtos.lectureapply;

import java.io.Serializable;
import java.util.Arrays;

public class CustUserDtos implements Serializable {
	
	
	private static final long serialVersionUID =-8653059912970844675L;

	
	private String student_cd;
	private String student_nm;
	private int student_year;
	private String lec_check;

	//여기용 get,set추가 해주세용
	private String over_check;
	private String time_check;
	
	private String smt;
	

	private String year;
	private String comdiv_cd;
	private String curi_num;
	private String curi_num1;
	
	private String curi_class;

	
	private String curi_nm;
	private String dept_nm;
	private String cont_desc;
	private int cdt_num;
	private String propessor_nm;
	private String class_div;
	private String dept_cd;
	private int wp_time;
	private String lesson_tp;
	private String com_year;
	private String com_class;
	private String cult_group;
	private String student_class;
	private String student_num;
	private String start_time;
	private String week_day;
	private String bld_nm;
	private String room_nm;
	
	
	
	public CustUserDtos() {
		super();
	}
	public CustUserDtos(String student_cd, int student_year) {
		super();
		this.student_cd = student_cd;
		this.student_year = student_year;
	}
	
	public CustUserDtos(String student_cd) {
		super();
		this.student_cd = student_cd;
	}
	public CustUserDtos(String student_cd, String curi_num, String curi_num1) {
		super();
		this.student_cd = student_cd;
		this.curi_num = curi_num;
		this.curi_num1 = curi_num1;
	}
	public CustUserDtos(int student_year, String dept_cd) {
		super();
		this.student_year = student_year;
		this.dept_cd = dept_cd;
	}
	
	

//	public CustUserDtos(String student_cd, String[] curi_num2,
//			String[] curi_num3) {
//		super();
//		this.student_cd = student_cd;
//		this.curi_num2 = curi_num2;
//		this.curi_num3 = curi_num3;
//	}
	
	public CustUserDtos(String student_cd, String curi_num, String curi_class,
			String dept_cd, String com_year,int cdt_num,String class_div,String comdiv_cd) {
		super();
		this.student_cd = student_cd;
		this.curi_num = curi_num;
		this.curi_class = curi_class;
		this.dept_cd = dept_cd;
		this.com_year = com_year;
		this.cdt_num=cdt_num;
		this.class_div=class_div;
		this.comdiv_cd=comdiv_cd;
	}
	
	public CustUserDtos(String curi_num, String curi_class) {
		super();
		this.curi_num = curi_num;
		this.curi_class=curi_class;
	}
	
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getBld_nm() {
		return bld_nm;
	}
	public String getTime_check() {
		return time_check;
	}
	public void setTime_check(String time_check) {
		this.time_check = time_check;
	}
	public void setOver_check(String over_check) {
		this.over_check = over_check;
	}
	public void setBld_nm(String bld_nm) {
		this.bld_nm = bld_nm;
	}
	public String getRoom_nm() {
		return room_nm;
	}
	public void setRoom_nm(String room_nm) {
		this.room_nm = room_nm;
	}
	public String getWeek_day() {
		return week_day;
	}
	public void setWeek_day(String week_day) {
		this.week_day = week_day;
	}
	
	public String getCuri_num1() {
		return curi_num1;
	}
	public void setCuri_num1(String curi_num1) {
		this.curi_num1 = curi_num1;
	}
	


	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	

	public String getLec_check() {
		return lec_check;
	}
	public void setLec_check(String lec_check) {
		this.lec_check = lec_check;
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

	public String getCom_class() {
		return com_class;
	}

	public void setCom_class(String com_class) {
		this.com_class = com_class;
	}

	public String getCult_group() {
		return cult_group;
	}

	public void setCult_group(String cult_group) {
		this.cult_group = cult_group;
	}

	
	public String getLesson_tp() {
		return lesson_tp;
	}

	public void setLesson_tp(String lesson_tp) {
		this.lesson_tp = lesson_tp;
	}
	public String getCom_year() {
		return com_year;
	}

	public void setCom_year(String com_year) {
		this.com_year = com_year;
	}

	public int getWp_time() {
		return wp_time;
	}

	public void setWp_time(int wp_time) {
		this.wp_time = wp_time;
	}

	public String getDept_cd() {
		return dept_cd;
	}

	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}

	public String getSmt() {
		return smt;
	}

	public void setSmt(String smt) {
		this.smt = smt;
	}
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getStudent_cd() {
		return student_cd;
	}

	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
	}

	public String getStudent_nm() {
		return student_nm;
	}

	public void setStudent_nm(String student_nm) {
		this.student_nm = student_nm;
	}

	public int getStudent_year() {
		return student_year;
	}

	public void setStudent_year(int student_year) {
		this.student_year = student_year;
	}

	public String getComdiv_cd() {
		return comdiv_cd;
	}

	public void setComdiv_cd(String comdiv_cd) {
		this.comdiv_cd = comdiv_cd;
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

	public int getCdt_num() {
		return cdt_num;
	}

	public void setCdt_num(int cdt_num) {
		this.cdt_num = cdt_num;
	}

	public String getPropessor_nm() {
		return propessor_nm;
	}

	public void setPropessor_nm(String propessor_nm) {
		this.propessor_nm = propessor_nm;
	}

	public String getClass_div() {
		return class_div;
	}

	public void setClass_div(String class_div) {
		this.class_div = class_div;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOver_check() {
		return over_check;
	}
	@Override
	public String toString() {
		return "CustUserDtos [student_cd=" + student_cd + ", student_nm="
				+ student_nm + ", student_year=" + student_year
				+ ", lec_check=" + lec_check + ", over_check=" + over_check
				+ ", time_check=" + time_check + ", smt=" + smt + ", year="
				+ year + ", comdiv_cd=" + comdiv_cd + ", curi_num=" + curi_num
				+ ", curi_num1=" + curi_num1 + ", curi_class=" + curi_class
				+ ", curi_nm=" + curi_nm + ", cont_desc=" + cont_desc
				+ ", cdt_num=" + cdt_num + ", propessor_nm=" + propessor_nm
				+ ", class_div=" + class_div + ", dept_cd=" + dept_cd
				+ ", wp_time=" + wp_time + ", lesson_tp=" + lesson_tp
				+ ", com_year=" + com_year + ", com_class=" + com_class
				+ ", cult_group=" + cult_group + ", student_class="
				+ student_class + ", student_num=" + student_num
				+ ", start_time=" + start_time + ", week_day=" + week_day
				+ ", bld_nm=" + bld_nm + ", room_nm=" + room_nm + "]";
	}
	
	
	
	
	
	


}
