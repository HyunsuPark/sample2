package com.OMC.daos;

import java.util.List;

import com.OMC.dtos.LoginUserDto;
import com.OMC.dtos.NoticeDto;
import com.OMC.dtos.grade.GradeDto;
import com.OMC.dtos.grade.GradeSumDto;
import com.OMC.dtos.search.KyosuSearchDto;
import com.OMC.dtos.search.KyosuSelectDto;
import com.OMC.dtos.search.LecturePlanDto;
import com.OMC.dtos.search.LectureSearchDto;

public class SearchService {
	private SearchManager srcmanager;
	private static SearchService OMCService;
	private SearchService() {
		srcmanager = new SearchManager();
	}
	public static SearchService getInstance(){
		if(OMCService ==null ){
			OMCService = new SearchService();
		}
		return OMCService;
	}

	public List<LectureSearchDto> getLectureSearch(String curi_num) {
		return srcmanager.getLectureSearch(curi_num);
	}//
	
	public List<LectureSearchDto> getLectureSearch1(String curi_nm) {
		return srcmanager.getLectureSearch1(curi_nm);
	}//
	
	public List<LectureSearchDto> getLectureSearch2(String curi_num,String curi_nm) {
		return srcmanager.getLectureSearch2(curi_num, curi_nm);
	}//
	
	public List<LectureSearchDto> getLectureSearch3() {
		return srcmanager.getLectureSearch3();
	}//
	
	public List<KyosuSelectDto> getKyosuSelect() {
		return srcmanager.getKyosuSelect();
	}//
	
	public List<KyosuSearchDto> getKyosuSearch(String kor_nm) {
		return srcmanager.getKyosuSearch(kor_nm);
	}//
	
	public List<KyosuSearchDto> getKyosuSearch1() {
		return srcmanager.getKyosuSearch1();
	}//
	
	public List<KyosuSearchDto> getKyosuSearch2(String subject) {
		return srcmanager.getKyosuSearch2(subject);
	}//
	
	public List<KyosuSearchDto> getKyosuSearch3(String kor_nm,String subject) {
		return srcmanager.getKyosuSearch3(kor_nm,subject);
	}//
	
	public List<LecturePlanDto> getLecturePlan(String curi_num1,String curi_nm1,String kor_nm1,String semester) {
		return srcmanager.getLecturePlan(curi_num1,curi_nm1,kor_nm1,semester);
	}//
	
	public List<LecturePlanDto> getLecturePlan1() {
		return srcmanager.getLecturePlan1();
	}//
	
	public List<LecturePlanDto> getLecturePlan2(String curi_num1,String curi_nm1,String semester) {
		return srcmanager.getLecturePlan2(curi_num1,curi_nm1,semester);
	}//
	
	public List<LecturePlanDto> getLecturePlan3(String kor_nm1,String semester) {
		return srcmanager.getLecturePlan3(kor_nm1,semester);
	}//
	
	public List<LecturePlanDto> getLecturePlan4(String curi_nm1,String semester) {
		return srcmanager.getLecturePlan3(curi_nm1,semester);
	}//
}
