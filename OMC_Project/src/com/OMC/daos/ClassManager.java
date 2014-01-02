package com.OMC.daos;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.OMC.dtos.lectureapply.CustUserDtos;
import com.OMC.dtos.lectureapply.LectureConfirmDto;
import com.OMC.dtos.lectureapply.StuSearchConDto;
import com.OMC.dtos.lectureapply.StuSearchDto;
import com.OMC.ibatis.SqlDaoSuport;


public class ClassManager extends SqlDaoSuport {

	public ClassManager() {
		super();
		
	}

	public ClassManager(String path) {
		super(path);
	}

		public LectureConfirmDto getStudentInfo(String student_cd){
		LectureConfirmDto dto=null;
//		String student_cd=dto.getStudent_cd();
		System.out.println(student_cd);
		Map< String , String> para=new HashMap<String, String>();
		para.put("student_cd", student_cd);
		//String student_cd = dto.getStudent_cd();

		try {
		
			dto=(LectureConfirmDto)this.getSqlMapper().queryForObject("LectureApply.getStudentInfo",para);
		} catch (SQLException e) {
		System.out.println(e);	
		}
		if(dto == null){
		}
		System.out.println(dto);
		return dto;
	}
		
		
		public List<LectureConfirmDto> getLactureConfirmList(LectureConfirmDto dto){
			List<LectureConfirmDto> lists=null;
			System.out.println("student_cd = "+dto.getStudent_cd());
			System.out.println("year = "+dto.getYear());
			System.out.println("smt = "+dto.getSmt());
			Map< String , String> para=new HashMap<String, String>();
			para.put("student_cd1", dto.getStudent_cd());
			para.put("year1", dto.getYear());
			para.put("smt1", dto.getSmt());
			para.put("student_cd2", dto.getStudent_cd());
			para.put("year2", dto.getYear());
			para.put("smt2", dto.getSmt());
			try {
				lists=(List<LectureConfirmDto>)this.getSqlMapper().queryForList("LectureApply.getLactureConfirmList",para);
			} catch (SQLException e) {
				System.out.println(e);
			}
			if(lists == null){
			}
			System.out.println(lists);
			return lists;
		}
		
		public List<StuSearchDto> getStuSearch1List(StuSearchConDto cDto) {
			List<StuSearchDto> lists=new ArrayList<StuSearchDto>();
			String yer = cDto.getSlaYear();
			String smt =cDto.getSlaSmt();
			String sti =cDto.getSlaStuId();

			System.out.println("123"+yer+smt+sti);
		try {
			lists=(List<StuSearchDto>)this.getSqlMapper().queryForList("LectureApply.getStuSearchList",cDto);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return lists;
		}//
		
		public LectureConfirmDto getGradeStandard(String student_cd){
			LectureConfirmDto lists=null;
			System.out.println("getGradeStandard"+student_cd);
			try {
				lists=(LectureConfirmDto)this.getSqlMapper().queryForObject("LectureApply.getGradeStandard",student_cd);
			} catch (SQLException e) {
				System.out.println(e);
			}
			if(lists == null){
			}
			
			return lists;
		}
		public CustUserDtos getCustUser(CustUserDtos dto){
			
			try {
				dto=(CustUserDtos) getSqlMapper().queryForObject("stclasses.getCustUser",dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
			
		}
		@SuppressWarnings("unchecked")
		public List<CustUserDtos> getAllList(CustUserDtos dto){
			System.out.println("getalllist");
			System.out.println(dto.getDept_cd());
			System.out.println(dto.getStudent_year());
			List<CustUserDtos> lists= new ArrayList<CustUserDtos>();
			
			try {
			
				lists=(List<CustUserDtos>)getSqlMapper().queryForList("stclasses.getAllList",dto);
//				System.out.println(lists.get(0));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lists;
		}
		
		public CustUserDtos getCheck(CustUserDtos dto){
			try {
				System.out.println("getCheck");
				dto=(CustUserDtos) getSqlMapper().queryForObject("stclasses.getCheck", dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return dto;
		}
		public CustUserDtos getOverlapCheck(CustUserDtos dto){
			
			System.out.println("getoverlap");
			try {
				dto = (CustUserDtos)getSqlMapper().queryForObject("stclasses.getOverlapCheck",dto);
				System.out.println(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			System.out.println(dto);
			return dto;
			
			
		}
		public boolean insertLecture(CustUserDtos dto){
			boolean iss=false;
		
			try {
				getSqlMapper().insert("stclasses.insertLecture", dto);
				iss=true;
		
			} catch (SQLException e) {
				System.out.println(e);
			
				
			}
			System.out.println(iss);
			return iss;
		}
		public List<CustUserDtos> getShowLec(String student_cd){
			List<CustUserDtos> lists=new ArrayList<CustUserDtos>();
			try {
				lists=getSqlMapper().queryForList("stclasses.getShowLec", student_cd);
				System.out.println(lists);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lists;
		}
		public CustUserDtos getLecInfo(CustUserDtos dto){
			try {
				dto=(CustUserDtos) getSqlMapper().queryForObject("stclasses.getLecInfo", dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
		//여기용
		public CustUserDtos getTimeCheck(String student_cd,String curi_num,String curi_class){
			CustUserDtos dto=new CustUserDtos();

			
			Map<String,String> map=new HashMap<String,String>();
			map.put("student_cd",student_cd);
			map.put("curi_num",curi_num);
			map.put("curi_class",curi_class);
			try {
				System.out.println("++++++++++++++++++++++++++++++++++");
			System.out.println(map.get("student_cd"));
			
				dto=(CustUserDtos) getSqlMapper().queryForObject("stclasses.getTimeCheck", map);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
			
		}
		
		public boolean mulDelLecture(String[] id) {
			boolean isS= false;
			try {
				this.getSqlMapper().startTransaction();
				this.getSqlMapper().startBatch();
				for (int i = 0; i < id.length; i++) {
					this.getSqlMapper().update("stclasses.muldelLec", id[i]);
				}
				this.getSqlMapper().executeBatch();
				this.getSqlMapper().commitTransaction();
				isS = true;
			} catch (SQLException e) {
				System.out.println("deleteCustUser f");
				isS= false;
			}finally{
				try {
					this.getSqlMapper().endTransaction();
				} catch (SQLException e) {
				}
			}
			return isS;
		}
		public CustUserDtos getDeptInfo(String dept_cd){
			CustUserDtos dto =new CustUserDtos();
			try {
				dto=(CustUserDtos) getSqlMapper().queryForObject("stclasses.getDeptInfo", dept_cd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dto;
		}
		
	
}
