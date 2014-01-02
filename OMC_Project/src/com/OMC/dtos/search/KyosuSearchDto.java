package com.OMC.dtos.search;
//com.OMC.dtos.search.KyosuSearchDto
import java.io.Serializable;

public class KyosuSearchDto implements Serializable {
	private String emp_id;//학수번호
	private	String kor_nm;//교수명
	private String ssn;//주민등록번호
	private String jacont;//재직구분
	private String jikcont;//직급명
	private String jocont;//직종명
	private String dept_nm;//소속학과명
	
	public KyosuSearchDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KyosuSearchDto(String emp_id, String kor_nm, String ssn,
			String jacont, String jikcont, String jocont, String dept_nm) {
		super();
		this.emp_id = emp_id;
		this.kor_nm = kor_nm;
		this.ssn = ssn;
		this.jacont = jacont;
		this.jikcont = jikcont;
		this.jocont = jocont;
		this.dept_nm = dept_nm;
	}

	@Override
	public String toString() {
		return "KyosuSearchDto [emp_id=" + emp_id + ", kor_nm=" + kor_nm
				+ ", ssn=" + ssn + ", jacont=" + jacont + ", jikcont="
				+ jikcont + ", jocont=" + jocont + ", dept_nm=" + dept_nm + "]";
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getKor_nm() {
		return kor_nm;
	}

	public void setKor_nm(String kor_nm) {
		this.kor_nm = kor_nm;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getJacont() {
		return jacont;
	}

	public void setJacont(String jacont) {
		this.jacont = jacont;
	}

	public String getJikcont() {
		return jikcont;
	}

	public void setJikcont(String jikcont) {
		this.jikcont = jikcont;
	}

	public String getJocont() {
		return jocont;
	}

	public void setJocont(String jocont) {
		this.jocont = jocont;
	}

	public String getDept_nm() {
		return dept_nm;
	}

	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
}
