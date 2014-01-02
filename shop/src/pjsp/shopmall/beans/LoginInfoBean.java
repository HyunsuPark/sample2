package pjsp.shopmall.beans;
import javax.servlet.http.*;
public class LoginInfoBean {
	private String id;
	private String name;
	private String passwd;
	private String address;
	private String phone;
	public LoginInfoBean () {}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void setAddress (String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
}
