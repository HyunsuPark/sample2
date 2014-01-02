package com.OMC.dtos.student;

/*
 *  SELECT STUDENT_CD
       , KOR_NM
       , REPLACE(SSN1 || '-' || SSN2, SUBSTR(SSN1 || '-' || SSN2, 9), '******') AS SSN
       , CASE SCHOOL_STS
          WHEN '01' THEN '재학'
          WHEN '02' THEN '휴학'
          WHEN '03' THEN '재적'
          WHEN '04' THEN '졸업'
          END AS SCHOOL_STS
       , STUDENT_PERIOD
       , DECODE(CLASS_DIV, 1, '주간', '야간') AS CLASS_DIV
         , CURI_YEAR
         , OLG_DEPT_NM
        , OLG_MAJOR_NM
        , STUDENT_YEAR || '-' || STUDENT_CLASS || '-' || STUDENT_NUM AS STUDENT_NUM
        , DECODE(SCHOOL_STS, '졸업', 'Y', 'N') AS SCHOOL_CHK
          , PHONE
          , M_PHONE
          , E_MAIL
          , REAL_ZIP1 || '-' || REAL_ZIP2 AS ZIP
          , REAL_ADDR1 || '' || REAL_ADDR2 AS ADDR
          , REAL_ADDR1
          , NVL(REAL_ADDR2, '&nbsp;') AS REAL_ADDR2
          , DEG_NUM
          , REF_ACCT_NUM
          , CONT_DESC AS BANK
          , REF_DEPO_NM
  
 */

/**
 * SELECT DECODE(NATION, 'KR', '대한민국', ' ') AS NATION
		   	    , SCHOOL_NM
		        , TO_CHAR(SCHOOL_DT, 'YYYY-MM-DD') AS SCHOOL_DT
		        , ENG_NM
		        , ENTR_NM
		        , ENTR_PHONE
 */

/**
 *  SELECT NVL(DECODE(PROTEC_REL, '01', '부', '02', '모', '03', '배우자', '04', '자녀', '05', '형제'), '&nbsp;') AS PROTEC_REL
	      , NVL(PROTEC_NM, '&nbsp;') as PROTEC_NM
	      , NVL(PROTEC_JOB, '&nbsp;') as PROTEC_JOB
	      , NVL(PROTEC_PHONE, '&nbsp;') as PROTEC_PHONE
	      , PROTEC_ZIP1 || '-' || PROTEC_ZIP2 AS PROTEC_ZIP
	      , NVL(PORTEC_ADDR1 || ' ' || PROTEC_ADDR2, '&nbsp;') AS PROTEC_ADDR
 */

/**
 * SELECT sla.year as year
		      , DECODE(sla.smt, 10, '1학기', 11, '여름학기', 20, '2학기', 21, '겨울학기') as smt
		      , sla.curi_num as curi_num
		      , scm.curi_nm as curi_nm
		      , sla.curi_class as curi_class
		      , CCC.CONT_DESC as cont_desc
		      , DECODE(sla.class_div, '1', '주간', '야간') as class_div
		      , sla.cdt_num as cdt_num
		      , ar.times || '(' || SUBSTR(ar.BLD_NM, 1, 2) || ' ' || ar.room_nm || ')' as room_time
		      , ar.KOR_NM as pro_nm
		      , NVL(DECODE(sla.recourse_div, '01', '재수강', '02', '대체수강', '03', '타수강'), '&nbsp;') as recourse_div
 */

/** 은행코드명
 * SELECT distinct cont_desc as bankn,
		       ref_bank_cd as bankc
	FROM COMT_COM_CD ccc, SRGT_STUDENT_MASTER ssm
	WHERE ccc.small_div = ssm.REF_BANK_CD
	and large_div='COM19'
	order by ref_bank_cd;
 */
import java.io.Serializable;

public class StudentDto implements Serializable {
	
	public String student_cd;
	public String kor_nm;
	public String ssn;
	public String school_sts;
	public int student_period;
	public String class_div;
	public String curi_year;
	public String olg_dept_nm;
	public String olg_major_nm;
	public String student_num;
	public String school_chk;
	public String phone;
	public String m_phone;
	public String e_mail;
	public String zip;
	public String addr;
	public String real_addr1;
	public String real_addr2;
	public String deg_num;
	public String ref_acct_num;
	public String bank;
	public String ref_depo_nm;
	
	public String nation;
	public String school_nm;
	public String school_dt;
	public String eng_nm;
	public String entr_nm;
	public String entr_phone;
	
	public String protec_rel;
	public String protec_nm;
	public String protec_job;
	public String protec_phone;
	public String protec_zip;
	public String protec_addr;
	
	public String year;
	public String smt;
	public String curi_nm;
	public String curi_num;
	public String curi_class;
	public String cont_desc;
	//public String class_div;
	public String cdt_num;
	public String room_time;
	public String pro_nm;
	public String recourse_div;
	
	public String bankn;
	public String bankc;
	public String ref_bank_cd;
	
	public StudentDto() {
		super();
	}

	public StudentDto(String student_cd, String kor_nm, String ssn,
			String school_sts, int student_period, String class_div,
			String curi_year, String olg_dept_nm, String olg_major_nm,
			String student_num, String school_chk, String phone,
			String m_phone, String e_mail, String zip, String addr,
			String real_addr1, String real_addr2, String deg_num,
			String ref_acct_num, String bank, String ref_depo_nm,
			String nation, String school_nm, String school_dt, String eng_nm,
			String entr_nm, String entr_phone, String protec_rel,
			String protec_nm, String protec_job, String protec_phone,
			String protec_zip, String protec_addr, String year, String smt,
			String curi_nm, String curi_num, String curi_class,
			String cont_desc, String cdt_num, String room_time, String pro_nm,
			String recourse_div, String bankn, String bankc, String ref_bank_cd) {
		super();
		this.student_cd = student_cd;
		this.kor_nm = kor_nm;
		this.ssn = ssn;
		this.school_sts = school_sts;
		this.student_period = student_period;
		this.class_div = class_div;
		this.curi_year = curi_year;
		this.olg_dept_nm = olg_dept_nm;
		this.olg_major_nm = olg_major_nm;
		this.student_num = student_num;
		this.school_chk = school_chk;
		this.phone = phone;
		this.m_phone = m_phone;
		this.e_mail = e_mail;
		this.zip = zip;
		this.addr = addr;
		this.real_addr1 = real_addr1;
		this.real_addr2 = real_addr2;
		this.deg_num = deg_num;
		this.ref_acct_num = ref_acct_num;
		this.bank = bank;
		this.ref_depo_nm = ref_depo_nm;
		this.nation = nation;
		this.school_nm = school_nm;
		this.school_dt = school_dt;
		this.eng_nm = eng_nm;
		this.entr_nm = entr_nm;
		this.entr_phone = entr_phone;
		this.protec_rel = protec_rel;
		this.protec_nm = protec_nm;
		this.protec_job = protec_job;
		this.protec_phone = protec_phone;
		this.protec_zip = protec_zip;
		this.protec_addr = protec_addr;
		this.year = year;
		this.smt = smt;
		this.curi_nm = curi_nm;
		this.curi_num = curi_num;
		this.curi_class = curi_class;
		this.cont_desc = cont_desc;
		this.cdt_num = cdt_num;
		this.room_time = room_time;
		this.pro_nm = pro_nm;
		this.recourse_div = recourse_div;
		this.bankn = bankn;
		this.bankc = bankc;
		this.ref_bank_cd = ref_bank_cd;
	}
	
	public StudentDto(String student_cd) {
		super();
		this.student_cd = student_cd;
	}

	public String getStudent_cd() {
		return student_cd;
	}
	
	// update
	

	public StudentDto(String phone, String m_phone, String e_mail,
			String real_addr1, String real_addr2, String ref_acct_num,
			String ref_depo_nm, String eng_nm, String ref_bank_cd , String student_cd) {
		super();
		this.phone = phone;
		this.m_phone = m_phone;
		this.e_mail = e_mail;
		this.real_addr1 = real_addr1;
		this.real_addr2 = real_addr2;
		this.ref_acct_num = ref_acct_num;
		this.ref_depo_nm = ref_depo_nm;
		this.eng_nm = eng_nm;
		this.ref_bank_cd = ref_bank_cd;
		this.student_cd = student_cd;
	}

	public void setStudent_cd(String student_cd) {
		this.student_cd = student_cd;
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

	public String getSchool_sts() {
		return school_sts;
	}

	public void setSchool_sts(String school_sts) {
		this.school_sts = school_sts;
	}

	public int getStudent_period() {
		return student_period;
	}

	public void setStudent_period(int student_period) {
		this.student_period = student_period;
	}

	public String getClass_div() {
		return class_div;
	}

	public void setClass_div(String class_div) {
		this.class_div = class_div;
	}

	public String getCuri_year() {
		return curi_year;
	}

	public void setCuri_year(String curi_year) {
		this.curi_year = curi_year;
	}

	public String getOlg_dept_nm() {
		return olg_dept_nm;
	}

	public void setOlg_dept_nm(String olg_dept_nm) {
		this.olg_dept_nm = olg_dept_nm;
	}

	public String getOlg_major_nm() {
		return olg_major_nm;
	}

	public void setOlg_major_nm(String olg_major_nm) {
		this.olg_major_nm = olg_major_nm;
	}

	public String getStudent_num() {
		return student_num;
	}

	public void setStudent_num(String student_num) {
		this.student_num = student_num;
	}

	public String getSchool_chk() {
		return school_chk;
	}

	public void setSchool_chk(String school_chk) {
		this.school_chk = school_chk;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	

	public String getReal_addr1() {
		return real_addr1;
	}




	public void setReal_addr1(String real_addr1) {
		this.real_addr1 = real_addr1;
	}




	public String getReal_addr2() {
		return real_addr2;
	}




	public void setReal_addr2(String real_addr2) {
		this.real_addr2 = real_addr2;
	}




	public String getDeg_num() {
		return deg_num;
	}

	public void setDeg_num(String deg_num) {
		this.deg_num = deg_num;
	}

	public String getRef_acct_num() {
		return ref_acct_num;
	}

	public void setRef_acct_num(String ref_acct_num) {
		this.ref_acct_num = ref_acct_num;
	}


	public String getBank() {
		return bank;
	}


	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getRef_depo_nm() {
		return ref_depo_nm;
	}

	public void setRef_depo_nm(String ref_depo_nm) {
		this.ref_depo_nm = ref_depo_nm;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSchool_nm() {
		return school_nm;
	}

	public void setSchool_nm(String school_nm) {
		this.school_nm = school_nm;
	}

	public String getSchool_dt() {
		return school_dt;
	}

	public void setSchool_dt(String school_dt) {
		this.school_dt = school_dt;
	}

	public String getEng_nm() {
		return eng_nm;
	}

	public void setEng_nm(String eng_nm) {
		this.eng_nm = eng_nm;
	}

	public String getEntr_nm() {
		return entr_nm;
	}

	public void setEntr_nm(String entr_nm) {
		this.entr_nm = entr_nm;
	}

	public String getEntr_phone() {
		return entr_phone;
	}

	public void setEntr_phone(String entr_phone) {
		this.entr_phone = entr_phone;
	}

	public String getProtec_rel() {
		return protec_rel;
	}

	public void setProtec_rel(String protec_rel) {
		this.protec_rel = protec_rel;
	}

	public String getProtec_nm() {
		return protec_nm;
	}

	public void setProtec_nm(String protec_nm) {
		this.protec_nm = protec_nm;
	}

	public String getProtec_job() {
		return protec_job;
	}

	public void setProtec_job(String protec_job) {
		this.protec_job = protec_job;
	}

	public String getProtec_phone() {
		return protec_phone;
	}

	public void setProtec_phone(String protec_phone) {
		this.protec_phone = protec_phone;
	}

	public String getProtec_zip() {
		return protec_zip;
	}

	public void setProtec_zip(String protec_zip) {
		this.protec_zip = protec_zip;
	}

	public String getProtec_addr() {
		return protec_addr;
	}

	public void setProtec_addr(String protec_addr) {
		this.protec_addr = protec_addr;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSmt() {
		return smt;
	}

	public void setSmt(String smt) {
		this.smt = smt;
	}

	public String getCuri_nm() {
		return curi_nm;
	}

	public void setCuri_nm(String curi_nm) {
		this.curi_nm = curi_nm;
	}

	public String getCuri_num() {
		return curi_num;
	}

	public void setCuri_num(String curi_num) {
		this.curi_num = curi_num;
	}

	public String getCuri_class() {
		return curi_class;
	}

	public void setCuri_class(String curi_class) {
		this.curi_class = curi_class;
	}

	public String getCont_desc() {
		return cont_desc;
	}

	public void setCont_desc(String cont_desc) {
		this.cont_desc = cont_desc;
	}

	public String getCdt_num() {
		return cdt_num;
	}

	public void setCdt_num(String cdt_num) {
		this.cdt_num = cdt_num;
	}

	public String getRoom_time() {
		return room_time;
	}

	public void setRoom_time(String room_time) {
		this.room_time = room_time;
	}

	public String getPro_nm() {
		return pro_nm;
	}

	public void setPro_nm(String pro_nm) {
		this.pro_nm = pro_nm;
	}

	public String getRecourse_div() {
		return recourse_div;
	}

	public void setRecourse_div(String recourse_div) {
		this.recourse_div = recourse_div;
	}


	public String getBankn() {
		return bankn;
	}


	public void setBankn(String bankn) {
		this.bankn = bankn;
	}


	public String getBankc() {
		return bankc;
	}


	public void setBankc(String bankc) {
		this.bankc = bankc;
	}

	public String getRef_bank_cd() {
		return ref_bank_cd;
	}

	public void setRef_bank_cd(String ref_bank_cd) {
		this.ref_bank_cd = ref_bank_cd;
	}

	@Override
	public String toString() {
		return "StudentDto [student_cd=" + student_cd + ", kor_nm=" + kor_nm
				+ ", ssn=" + ssn + ", school_sts=" + school_sts
				+ ", student_period=" + student_period + ", class_div="
				+ class_div + ", curi_year=" + curi_year + ", olg_dept_nm="
				+ olg_dept_nm + ", olg_major_nm=" + olg_major_nm
				+ ", student_num=" + student_num + ", school_chk=" + school_chk
				+ ", phone=" + phone + ", m_phone=" + m_phone + ", e_mail="
				+ e_mail + ", zip=" + zip + ", addr=" + addr + ", real_addr1="
				+ real_addr1 + ", real_addr2=" + real_addr2 + ", deg_num="
				+ deg_num + ", ref_acct_num=" + ref_acct_num + ", bank=" + bank
				+ ", ref_depo_nm=" + ref_depo_nm + ", nation=" + nation
				+ ", school_nm=" + school_nm + ", school_dt=" + school_dt
				+ ", eng_nm=" + eng_nm + ", entr_nm=" + entr_nm
				+ ", entr_phone=" + entr_phone + ", protec_rel=" + protec_rel
				+ ", protec_nm=" + protec_nm + ", protec_job=" + protec_job
				+ ", protec_phone=" + protec_phone + ", protec_zip="
				+ protec_zip + ", protec_addr=" + protec_addr + ", year="
				+ year + ", smt=" + smt + ", curi_nm=" + curi_nm
				+ ", curi_num=" + curi_num + ", curi_class=" + curi_class
				+ ", cont_desc=" + cont_desc + ", cdt_num=" + cdt_num
				+ ", room_time=" + room_time + ", pro_nm=" + pro_nm
				+ ", recourse_div=" + recourse_div + ", bankn=" + bankn
				+ ", bankc=" + bankc + ", ref_bank_cd=" + ref_bank_cd + "]";
	}	
	
	
	
	
	
}