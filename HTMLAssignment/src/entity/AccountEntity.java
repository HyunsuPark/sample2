package entity;

public class AccountEntity {
	private String user_id;
	private String password;
	private String name;
	private String phone;
	
	
	public AccountEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AccountEntity(String user_id, String password, String name,
			String phone) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
