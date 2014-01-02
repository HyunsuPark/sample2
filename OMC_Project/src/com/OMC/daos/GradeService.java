package com.OMC.daos;

import java.util.List;

import com.OMC.dtos.grade.GradeDto;
import com.OMC.dtos.grade.GradeSumDto;

public class GradeService {
	private GradeManager grademanager;
	private static GradeService OMCService;
	private GradeService() {
		grademanager = new GradeManager();
	}
	public static GradeService getInstance(){
		if(OMCService ==null ){
			OMCService = new GradeService();
		}
		return OMCService;
	}
	//grade manager부분
	public List<GradeDto> getGradeThis(GradeDto dto) {
		return grademanager.getGradeThis(dto);
	}
	public List<GradeDto> getGradeAll(GradeDto dto) {
		return grademanager.getGradeAll(dto);
	}
	//grade 끝
	
}
