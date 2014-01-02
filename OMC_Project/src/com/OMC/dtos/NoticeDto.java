package com.OMC.dtos;

import java.io.Serializable;
import java.sql.Timestamp;

public class NoticeDto implements Serializable {
private int seq; 						//공지 테이블의 일련번호
private String userid;					//공지 테이블의 아이디
private String title;					//공지 테이블의 제목
private String content;					//공지 테이블의 내용
private java.sql.Timestamp  regi;		//공지 테이블의 날짜
private int num;						//공지 테이블의 번호
private int total;						//공지 테이블의 레코드 합계
public NoticeDto() {
	super();
	// TODO Auto-generated constructor stub
}

public NoticeDto(int seq, String userid, String title, String content,
		Timestamp regi) {
	super();
	this.seq = seq;
	this.userid = userid;
	this.title = title;
	this.content = content;
	this.regi = regi;
}

public NoticeDto(int seq, String title, String content) {
	super();
	this.seq = seq;
	this.title = title;
	this.content = content;
}

public NoticeDto(String userid, String title, String content) {
	super();
	this.userid = userid;
	this.title = title;
	this.content = content;
}
@Override
public String toString() {
	return "NoticeDto [seq=" + seq + ", userid=" + userid + ", title=" + title
			+ ", content=" + content + ", regi=" + regi + "]";
}

public int getTotal() {
	return total;
}

public void setTotal(int total) {
	this.total = total;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public int getSeq() {
	return seq;
}

public void setSeq(int seq) {
	this.seq = seq;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public java.sql.Timestamp getRegi() {
	return regi;
}

public void setRegi(java.sql.Timestamp regi) {
	this.regi = regi;
}

}
