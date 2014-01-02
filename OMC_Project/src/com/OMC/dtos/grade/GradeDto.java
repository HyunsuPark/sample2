package com.OMC.dtos.grade;
import java.io.Serializable;

public class GradeDto implements Serializable {
	private static final long serialVersionUID = -8653059912970844675L;
	private String year;
	private String smt;
	private String student_cd;
	private String st_kor_nm;
	
	private String curi_num;
	private String curi_nm;
	private String curi_class;
	
	private int student_year;
	private String student_class;
	private String comdiv_cd;
	
	private int cdt_num;
	private int time;
	private String emp_kor_nm;
	private String grade;
	
	private double grade_avg;
	
	private String pass_fail;
	private String recourse_div;	
	
	private String recourse_year;
	private String recourse_smt;
	
	private String sudelete_mark;
	private int student_period;
	
	public GradeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradeDto(String year, String smt, String student_cd) {
		super();
		this.year = year;
		this.smt = smt;
		this.student_cd = student_cd;
	}
	public GradeDto(String student_cd) {
		super();
		this.student_cd = student_cd;
	}
	public GradeDto(String year, String smt, String student_cd,
			String st_kor_nm, String curi_num, String curi_nm,
			String curi_class, int student_year, String student_class,
			String comdiv_cd, int cdt_num, int time, String emp_kor_nm,
			String grade, double grade_avg, String pass_fail,
			String recourse_div, String recourse_year, String recourse_smt,
			String sudelete_mark, int student_period) {
		super();
		this.year = year;
		this.smt = smt;
		this.student_cd = student_cd;
		this.st_kor_nm = st_kor_nm;
		this.curi_num = curi_num;
		this.curi_nm = curi_nm;
		this.curi_class = curi_class;
		this.student_year = student_year;
		this.student_class = student_class;
		this.comdiv_cd = comdiv_cd;
		this.cdt_num = cdt_num;
		this.time = time;
		this.emp_kor_nm = emp_kor_nm;
		this.grade = grade;
		this.grade_avg = grade_avg;
		this.pass_fail = pass_fail;
		this.recourse_div = recourse_div;
		this.recourse_year = recourse_year;
		this.recourse_smt = recourse_smt;
		this.sudelete_mark = sudelete_mark;
		this.student_period = student_period;
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
	public String getStudent_cd() {
		return student_cd;
	}
	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
	}
	public String getSt_kor_nm() {
		return st_kor_nm;
	}
	public void setSt_kor_nm(String st_kor_nm) {
		this.st_kor_nm = st_kor_nm;
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
	public int getStudent_year() {
		return student_year;
	}
	public void setStudent_year(int student_year) {
		this.student_year = student_year;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public String getComdiv_cd() {
		return comdiv_cd;
	}
	public void setComdiv_cd(String comdiv_cd) {
		this.comdiv_cd = comdiv_cd;
	}
	public int getCdt_num() {
		return cdt_num;
	}
	public void setCdt_num(int cdt_num) {
		this.cdt_num = cdt_num;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getEmp_kor_nm() {
		return emp_kor_nm;
	}
	public void setEmp_kor_nm(String emp_kor_nm) {
		this.emp_kor_nm = emp_kor_nm;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getGrade_avg() {
		return grade_avg;
	}
	public void setGrade_avg(double grade_avg) {
		this.grade_avg = grade_avg;
	}
	public String getPass_fail() {
		return pass_fail;
	}
	public void setPass_fail(String pass_fail) {
		this.pass_fail = pass_fail;
	}
	public String getRecourse_div() {
		return recourse_div;
	}
	public void setRecourse_div(String recourse_div) {
		this.recourse_div = recourse_div;
	}
	public String getRecourse_year() {
		return recourse_year;
	}
	public void setRecourse_year(String recourse_year) {
		this.recourse_year = recourse_year;
	}
	public String getRecourse_smt() {
		return recourse_smt;
	}
	public void setRecourse_smt(String recourse_smt) {
		this.recourse_smt = recourse_smt;
	}
	public String getSudelete_mark() {
		return sudelete_mark;
	}
	public void setSudelete_mark(String sudelete_mark) {
		this.sudelete_mark = sudelete_mark;
	}
	public int getStudent_period() {
		return student_period;
	}
	public void setStudent_period(int student_period) {
		this.student_period = student_period;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "GradeDto [year=" + year + ", smt=" + smt + ", student_cd="
				+ student_cd + ", st_kor_nm=" + st_kor_nm + ", curi_num="
				+ curi_num + ", curi_nm=" + curi_nm + ", curi_class="
				+ curi_class + ", student_year=" + student_year
				+ ", student_class=" + student_class + ", comdiv_cd="
				+ comdiv_cd + ", cdt_num=" + cdt_num + ", time=" + time
				+ ", emp_kor_nm=" + emp_kor_nm + ", grade=" + grade
				+ ", grade_avg=" + grade_avg + ", pass_fail=" + pass_fail
				+ ", recourse_div=" + recourse_div + ", recourse_year="
				+ recourse_year + ", recourse_smt=" + recourse_smt
				+ ", sudelete_mark=" + sudelete_mark + ", student_period="
				+ student_period + "]";
	}
	
}//
