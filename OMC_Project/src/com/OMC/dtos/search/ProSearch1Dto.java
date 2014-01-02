package com.OMC.dtos.search;

import java.io.Serializable;

public class ProSearch1Dto implements Serializable {

	private String aemEmpId;
	private String aemKorNm;
	private String aemSsn;
	private String coffCont;
	private String cgraCont;
	private String coccCont;
	private String sdcAttest;
	public ProSearch1Dto() {
	}
	public ProSearch1Dto(String aemEmpId, String aemKorNm, String aemSsn,
			String coffCont, String cgraCont, String coccCont, String sdcAttest) {
		super();
		this.aemEmpId = aemEmpId;
		this.aemKorNm = aemKorNm;
		this.aemSsn = aemSsn;
		this.coffCont = coffCont;
		this.cgraCont = cgraCont;
		this.coccCont = coccCont;
		this.sdcAttest = sdcAttest;
	}
	@Override
	public String toString() {
		return "ProSearch1Dto [aemEmpId=" + aemEmpId + ", aemKorNm=" + aemKorNm
				+ ", aemSsn=" + aemSsn + ", coffCont=" + coffCont
				+ ", cgraCont=" + cgraCont + ", coccCont=" + coccCont
				+ ", sdcAttest=" + sdcAttest + "]";
	}
	public String getAemEmpId() {
		return aemEmpId;
	}
	public void setAemEmpId(String aemEmpId) {
		this.aemEmpId = aemEmpId;
	}
	public String getAemKorNm() {
		return aemKorNm;
	}
	public void setAemKorNm(String aemKorNm) {
		this.aemKorNm = aemKorNm;
	}
	public String getAemSsn() {
		return aemSsn;
	}
	public void setAemSsn(String aemSsn) {
		this.aemSsn = aemSsn;
	}
	public String getCoffCont() {
		return coffCont;
	}
	public void setCoffCont(String coffCont) {
		this.coffCont = coffCont;
	}
	public String getCgraCont() {
		return cgraCont;
	}
	public void setCgraCont(String cgraCont) {
		this.cgraCont = cgraCont;
	}
	public String getCoccCont() {
		return coccCont;
	}
	public void setCoccCont(String coccCont) {
		this.coccCont = coccCont;
	}
	public String getSdcAttest() {
		return sdcAttest;
	}
	public void setSdcAttest(String sdcAttest) {
		this.sdcAttest = sdcAttest;
	}

}
