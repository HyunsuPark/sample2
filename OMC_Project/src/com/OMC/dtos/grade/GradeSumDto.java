package com.OMC.dtos.grade;

import java.io.Serializable;

public class GradeSumDto implements Serializable {
	private String sum_year;
	private String sum_smt;
	private String sum_student_cd;
	private int sum_cdt_num;
	private int sum_student_year;
	private String sum_student_class;
	private String sum_student_num;
	private int sum_time;
	private String sum_grade;
	private double sum_grade_avg;
	
	
	public GradeSumDto(String sum_student_cd) {
		super();
		this.sum_student_cd = sum_student_cd;
	}
	


	public GradeSumDto(String sum_year, String sum_smt, String sum_student_cd) {
		super();
		this.sum_year = sum_year;
		this.sum_smt = sum_smt;
		this.sum_student_cd = sum_student_cd;
	}



	public GradeSumDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GradeSumDto(String sum_year, String sum_smt, String sum_student_cd,
			int sum_cdt_num, int sum_student_year, String sum_student_class,
			String sum_student_num, int sum_time, String sum_grade,
			double sum_grade_avg) {
		super();
		this.sum_year = sum_year;
		this.sum_smt = sum_smt;
		this.sum_student_cd = sum_student_cd;
		this.sum_cdt_num = sum_cdt_num;
		this.sum_student_year = sum_student_year;
		this.sum_student_class = sum_student_class;
		this.sum_student_num = sum_student_num;
		this.sum_time = sum_time;
		this.sum_grade = sum_grade;
		this.sum_grade_avg = sum_grade_avg;
	}


	public String getSum_year() {
		return sum_year;
	}


	public void setSum_year(String sum_year) {
		this.sum_year = sum_year;
	}


	public String getSum_smt() {
		return sum_smt;
	}


	public void setSum_smt(String sum_smt) {
		this.sum_smt = sum_smt;
	}


	public String getSum_student_cd() {
		return sum_student_cd;
	}


	public void setSum_student_cd(String sum_student_cd) {
		this.sum_student_cd = sum_student_cd;
	}


	public int getSum_cdt_num() {
		return sum_cdt_num;
	}


	public void setSum_cdt_num(int sum_cdt_num) {
		this.sum_cdt_num = sum_cdt_num;
	}


	public int getSum_student_year() {
		return sum_student_year;
	}


	public void setSum_student_year(int sum_student_year) {
		this.sum_student_year = sum_student_year;
	}


	public String getSum_student_class() {
		return sum_student_class;
	}


	public void setSum_student_class(String sum_student_class) {
		this.sum_student_class = sum_student_class;
	}


	public String getSum_student_num() {
		return sum_student_num;
	}


	public void setSum_student_num(String sum_student_num) {
		this.sum_student_num = sum_student_num;
	}


	public int getSum_time() {
		return sum_time;
	}


	public void setSum_time(int sum_time) {
		this.sum_time = sum_time;
	}


	public String getSum_grade() {
		return sum_grade;
	}


	public void setSum_grade(String sum_grade) {
		this.sum_grade = sum_grade;
	}


	public double getSum_grade_avg() {
		return sum_grade_avg;
	}


	public void setSum_grade_avg(double sum_grade_avg) {
		this.sum_grade_avg = sum_grade_avg;
	}



	@Override
	public String toString() {
		return "GradeSumDto [sum_year=" + sum_year + ", sum_smt=" + sum_smt
				+ ", sum_student_cd=" + sum_student_cd + ", sum_cdt_num="
				+ sum_cdt_num + ", sum_student_year=" + sum_student_year
				+ ", sum_student_class=" + sum_student_class
				+ ", sum_student_num=" + sum_student_num + ", sum_time="
				+ sum_time + ", sum_grade=" + sum_grade + ", sum_grade_avg="
				+ sum_grade_avg + "]";
	}

	
}
