package com.OMC.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OMC.dtos.grade.GradeDto;
import com.OMC.dtos.grade.GradeSumDto;
import com.OMC.ibatis.SqlDaoSuport;

public class GradeManager extends SqlDaoSuport {

	public GradeManager() {
		super();
	}

	public GradeManager(String path) {
		super(path);
	}
	public List<GradeDto> getGradeThis(GradeDto dto){
		List<GradeDto> lists = new ArrayList<GradeDto>();
		try {
			lists=(List<GradeDto>)this.getSqlMapper().queryForList("grade.getGradeThis",dto);
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getgradethis error");
		}
		return lists;
	}//
	
	public List<GradeDto> getGradeAll(GradeDto dto){
		List<GradeDto> lists = new ArrayList<GradeDto>();
		try {
			lists=(List<GradeDto>)this.getSqlMapper().queryForList("grade.getGradeAll",dto);
			
		} catch (SQLException e) {
			System.out.println("getGradeAll error");
		}
		return lists;
	}//
}
