package co.kr.parkprice.model;

import java.io.Serializable;

public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	private String m_idx;
	private String m_userid;
	private String m_password;
	private String m_registdate;
	private String m_1daykey;
	private String m_7daykey;
	private String m_30daykey;
	private String m_distance;
	private String m_point;
	private String m_code;
	private String m_phone;
	private String m_recommandee;
	private String m_commentdate;
	private String m_logindate;
	private int pageNo;
	private int totalCnt;
	public String getM_idx() {
		return m_idx;
	}
	public void setM_idx(String m_idx) {
		this.m_idx = m_idx;
	}
	public String getM_userid() {
		return m_userid;
	}
	public void setM_userid(String m_userid) {
		this.m_userid = m_userid;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_registdate() {
		return m_registdate;
	}
	public void setM_registdate(String m_registdate) {
		this.m_registdate = m_registdate;
	}
	public String getM_1daykey() {
		return m_1daykey;
	}
	public void setM_1daykey(String m_1daykey) {
		this.m_1daykey = m_1daykey;
	}
	public String getM_7daykey() {
		return m_7daykey;
	}
	public void setM_7daykey(String m_7daykey) {
		this.m_7daykey = m_7daykey;
	}
	public String getM_30daykey() {
		return m_30daykey;
	}
	public void setM_30daykey(String m_30daykey) {
		this.m_30daykey = m_30daykey;
	}
	public String getM_distance() {
		return m_distance;
	}
	public void setM_distance(String m_distance) {
		this.m_distance = m_distance;
	}
	public String getM_point() {
		return m_point;
	}
	public void setM_point(String m_point) {
		this.m_point = m_point;
	}
	public String getM_code() {
		return m_code;
	}
	public void setM_code(String m_code) {
		this.m_code = m_code;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_recommandee() {
		return m_recommandee;
	}
	public void setM_recommandee(String m_recommandee) {
		this.m_recommandee = m_recommandee;
	}
	public String getM_commentdate() {
		return m_commentdate;
	}
	public void setM_commentdate(String m_commentdate) {
		this.m_commentdate = m_commentdate;
	}
	public String getM_logindate() {
		return m_logindate;
	}
	public void setM_logindate(String m_logindate) {
		this.m_logindate = m_logindate;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
}
