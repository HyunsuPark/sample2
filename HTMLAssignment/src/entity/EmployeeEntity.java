package entity;

public class EmployeeEntity {
	String no;
	String name;
	String jik;
	String tel;
	String hobby;
	String etc;

	public EmployeeEntity() {
		super();
	}
	
	public EmployeeEntity(String no, String name, String jik, String tel,
			String hobby, String etc) {
		super();
		this.no = no;
		this.name = name;
		this.jik = jik;
		this.tel = tel;
		this.hobby = hobby;
		this.etc = etc;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJik() {
		return jik;
	}

	public void setJik(String jik) {
		this.jik = jik;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	 
}
