package member.model.dto;

public class Member {
    private String memberId;
    private String name;
    private String password;
    private String address;
    private String phone;
    private String passwordQuestion;
    private String passwordAnswer;
    private String marriage;
    private String hobby;
    private String etc;
    
     
    public Member() {
		super();
	}
    
    
    
	public Member(String memberId, String password, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
	}

	public Member(String memberId, String name, String password,
			String address, String phone, String passwordQuestion,
			String passwordAnswer, String marriage, String hobby, String etc) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.passwordQuestion = passwordQuestion;
		this.passwordAnswer = passwordAnswer;
		this.marriage = marriage;
		this.hobby = hobby;
		this.etc = etc;
	}



	public void setMemberId( String memberId ){
        this.memberId = memberId;
    }
    public void setName( String name ){
        this.name = name;
    }
    public void setPassword( String password ) {
        this.password = password;
    }
    public void setAddress( String address ) {
        this.address = address;
    }
    public void setPhone( String phone ){
        this.phone = phone;
    }
    public void setPasswordQuestion( String passwordQuestion ){
        this.passwordQuestion = passwordQuestion;
    }
    public void setPasswordAnswer( String passwordAnswer ){
        this.passwordAnswer = passwordAnswer;
    }
    public void setMarriage( String marriage ){
        this.marriage = marriage;
    }
    public void setHobby( String hobby ){
        this.hobby = hobby;
    }
    public void setEtc( String etc ){
        this.etc = etc;
    }
    public String getMemberId(){ return this.memberId; }
    public String getName(){ return this.name; }
    public String getPassword(){ return this.password; }
    public String getAddress(){ return this.address; }
    public String getPhone(){ return this.phone; }
    public String getPasswordQuestion(){ return this.passwordQuestion; }
    public String getPasswordAnswer(){ return this.passwordAnswer; }
    public String getMarriage(){ return this.marriage; }
    public String getHobby(){ return this.hobby; }
    public String getEtc(){ return this.etc; }

}
















