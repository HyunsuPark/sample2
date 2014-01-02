package com.OMC.dtos;

import java.io.Serializable;

public class LoginUserDto implements Serializable {
	private String student_cd; //학생 테이블의 학번
	private String passwd;  //학생 테이블의 비밀번호
	private String kor_nm;  //학생 테이블의 한국 이름
	public LoginUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LoginUserDto(String student_cd, String passwd) {
		super();
		this.student_cd = student_cd;
		this.passwd = passwd;
	}

	public LoginUserDto(String student_cd, String passwd, String kor_nm) {
		super();
		this.student_cd = student_cd;
		this.passwd = passwd;
		this.kor_nm = kor_nm;
	}
	public String getStudent_cd() {
		return student_cd;
	}
	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getKor_nm() {
		return kor_nm;
	}
	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}
	@Override
	public String toString() {
		return "LoginUserDto [student_cd=" + student_cd + ", passwd=" + passwd
				+ ", kor_nm=" + kor_nm + "]";
	}
	
		
}
