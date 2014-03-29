package co.kr.parkprice.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;
	private int seq;
	private String id;
	private String parking_name;
	private String owner;
	private String phone;
	private String addr;
	private String owner_phone;
	private String parking_type;
	private String all_cnt;
	private String avg_cnt;
	private String pay1;
	private String pay2;
	private String pay3;
	private String cnt1;
	private String cnt2;
	private String time1;
	private String time2;
	private String dc_type;
	private String system;
	private String regdate;
	private List<MultipartFile> files;
	private String file1;
	private String file2;
	private String file3;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParking_name() {
		return parking_name;
	}

	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getOwner_phone() {
		return owner_phone;
	}

	public void setOwner_phone(String owner_phone) {
		this.owner_phone = owner_phone;
	}

	public String getParking_type() {
		return parking_type;
	}

	public void setParking_type(String parking_type) {
		this.parking_type = parking_type;
	}

	public String getAll_cnt() {
		return all_cnt;
	}

	public void setAll_cnt(String all_cnt) {
		this.all_cnt = all_cnt;
	}

	public String getAvg_cnt() {
		return avg_cnt;
	}

	public void setAvg_cnt(String avg_cnt) {
		this.avg_cnt = avg_cnt;
	}

	public String getPay1() {
		return pay1;
	}

	public void setPay1(String pay1) {
		this.pay1 = pay1;
	}

	public String getPay2() {
		return pay2;
	}

	public void setPay2(String pay2) {
		this.pay2 = pay2;
	}

	public String getPay3() {
		return pay3;
	}

	public void setPay3(String pay3) {
		this.pay3 = pay3;
	}

	public String getCnt1() {
		return cnt1;
	}

	public void setCnt1(String cnt1) {
		this.cnt1 = cnt1;
	}

	public String getCnt2() {
		return cnt2;
	}

	public void setCnt2(String cnt2) {
		this.cnt2 = cnt2;
	}

	public String getTime1() {
		return time1;
	}

	public void setTime1(String time1) {
		this.time1 = time1;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

	public String getDc_type() {
		return dc_type;
	}

	public void setDc_type(String dc_type) {
		this.dc_type = dc_type;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}
	
}
