package com.OMC.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OMC.dtos.grade.GradeDto;
import com.OMC.dtos.student.StudentDto;
import com.OMC.ibatis.SqlDaoSuport;

public class StudentManager extends SqlDaoSuport {

	public StudentManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentManager(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}
	
public StudentDto getStudent(String student_cd){
		
		StudentDto dto = new StudentDto();
		System.out.println("getStudent manager");
		
		try {
			dto = (StudentDto)getSqlMapper().queryForObject("students.getStudent", student_cd);
			System.out.println("---dto");
			System.out.println("--------------"+dto);
//			System.out.println("예금주"+dto.getRef_depo_nm());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리턴");
		return dto;
		
	}
	
	public StudentDto getStudentTab1(String student_cd){
		StudentDto dto = new StudentDto();
		System.out.println("getStudentTab1 manager");
		
		try {
			dto = (StudentDto)getSqlMapper().queryForObject("students.getStudentTab1", student_cd);
			System.out.println("---dto");
			System.out.println("--------------"+dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리턴");
		return dto;
	}
	
	public StudentDto getStudentTab2(String student_cd){
		StudentDto dto = new StudentDto();
		System.out.println("getStudentTab2 manager");
		
		try {
			dto = (StudentDto)this.getSqlMapper().queryForObject("students.getStudentTab2", student_cd);
			System.out.println("---dto");
			System.out.println("--------------"+dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("리턴");
		return dto;
	}
	
	
	public List<StudentDto> getStudentTab4(String student_cd){
		List<StudentDto> lists = new ArrayList<StudentDto>();
		System.out.println("getStudentTab4 manager");
		
		try {
			lists = (List<StudentDto>)this.getSqlMapper().queryForList("students.getStudentTab4", student_cd);
			System.out.println("---lists");
			System.out.println("--------------"+lists);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("리턴");
		return lists;		
	}
	
	public List<StudentDto> getBankList(){
		List<StudentDto> lists = new ArrayList<StudentDto>();
		System.out.println("getBankList");
		
		try {
			lists = (List<StudentDto>)this.getSqlMapper().queryForList("students.getBankList");
			System.out.println("---lists");
			System.out.println("--------------"+lists);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	public List<GradeDto> getStudentTab5(GradeDto dto){
		List<GradeDto> lists = new ArrayList<GradeDto>();
		try {
			
			lists=(List<GradeDto>)this.getSqlMapper().queryForList("grade.getGradeAll",dto);
			
		} catch (SQLException e) {
			System.out.println("getStudentTab5 error");
		}
		return lists;
	}//
	
	public boolean updateStudent(StudentDto dto){
		boolean isS = false;
		
		try {
			System.out.println("updateStudent메니저부분 ");
			this.getSqlMapper().update("students.updateStudent", dto);
			isS = true;
			
		} catch (SQLException e) {
			
			System.out.println("updateStudent error : " + e );
			isS = false;
		}
		
		return isS;
	}

}
