package com.OMC.daos;

import java.util.List;

import com.OMC.dtos.LoginUserDto;
import com.OMC.dtos.grade.GradeDto;
import com.OMC.dtos.student.StudentDto;

public class StudentService {
	private StudentManager studentmanager;
	private static StudentService OMCService;
	//private OMCManager manager;
	private StudentService() {
		studentmanager = new StudentManager();
	}
	public static StudentService getInstance(){
		if(OMCService ==null ){
			OMCService = new StudentService();
		}
		return OMCService;
	}
	
	public StudentDto getStudent(String student_cd){
		return studentmanager.getStudent(student_cd);
	}
	
	public StudentDto getStudentTab1(String student_cd){
		return studentmanager.getStudentTab1(student_cd);
	}
	
	public StudentDto getStudentTab2(String student_cd){
		return studentmanager.getStudentTab2(student_cd);
	}
	
	public List<StudentDto> getStudentTab4(String student_cd){
		return studentmanager.getStudentTab4(student_cd);
	}
	
	public List<GradeDto> getStudentTab5(GradeDto dto){
		return studentmanager.getStudentTab5(dto);
	}
	
	public List<StudentDto> getBankList(){
		return studentmanager.getBankList();
	}
	
	public boolean updateStudent(StudentDto dto){
		return studentmanager.updateStudent(dto);
	}
}
