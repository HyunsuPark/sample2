package co.kr.parkprice.model;

import java.io.Serializable;

public class Contact implements Serializable{
	private static final long serialVersionUID = 1L;
	private String subject;
	private String phone;
	private String email;
	private String question;
	
	public Contact(String subject, String phone, String email, String question) {
		super();
		this.subject = subject;
		this.phone = phone;
		this.email = email;
		this.question = question;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	
}
