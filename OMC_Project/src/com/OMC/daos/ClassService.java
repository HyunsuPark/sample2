package com.OMC.daos;

import java.util.List;

import com.OMC.dtos.lectureapply.CustUserDtos;
import com.OMC.dtos.lectureapply.LectureConfirmDto;


public class ClassService {
	private ClassManager classmanager;
	private static ClassService OMCService;
	//private OMCManager manager;
	private ClassService() {
		classmanager = new ClassManager();
	}
	public static ClassService getInstance(){
		if(OMCService ==null ){
			OMCService = new ClassService();
		}
		return OMCService;
	}
	
	public List<LectureConfirmDto> getLactureConfirmList(LectureConfirmDto dto){
	return classmanager.getLactureConfirmList(dto);
	}
	
	public LectureConfirmDto getStudentInfo(String student_cd){
		return classmanager.getStudentInfo(student_cd);	
	}
	public LectureConfirmDto getGradeStandard(String student_cd){ 
	return classmanager.getGradeStandard(student_cd);
	}
	public CustUserDtos getCustUser(CustUserDtos dto){
		return classmanager.getCustUser(dto);
	}
	public List<CustUserDtos> getAllList(CustUserDtos dto){
	return classmanager.getAllList(dto);	
	}
	public CustUserDtos getCheck(CustUserDtos dto){
	return classmanager.getCheck(dto);	
	
	}
	public CustUserDtos getOverlapCheck(CustUserDtos dto){
		return classmanager.getOverlapCheck(dto);
	}
	public boolean insertLecture(CustUserDtos dto){
		return classmanager.insertLecture(dto);
	}
	public List<CustUserDtos> getShowLec(String student_cd){
		return classmanager.getShowLec(student_cd);
	}
	public CustUserDtos getLecInfo(CustUserDtos dto){
		return classmanager.getLecInfo(dto);
	}
	//여기용
	public CustUserDtos getTimeCheck(String student_cd,String curi_num,String curi_class){
		return classmanager.getTimeCheck( student_cd, curi_num, curi_class);
	}
	
	public boolean mulDelLecture(String[] id){
		return classmanager.mulDelLecture(id);
	}
	public CustUserDtos getDeptInfo(String dept_cd){
		return classmanager.getDeptInfo(dept_cd);
	}
}
