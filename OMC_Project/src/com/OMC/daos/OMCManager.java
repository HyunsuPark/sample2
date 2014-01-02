package com.OMC.daos;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.OMC.dtos.LoginUserDto;
import com.OMC.dtos.NoticeDto;
import com.OMC.ibatis.SqlDaoSuport;


public class OMCManager extends SqlDaoSuport {

	public OMCManager(String pass) {
		super(pass);
	}//

	public OMCManager() {
		super();
	}//
	
	
	public LoginUserDto getUserLogin(LoginUserDto dto){
		System.out.println("--------login------------");
		System.out.println("id= "+dto.getStudent_cd());
		System.out.println("passwd= "+dto.getPasswd());
		System.out.println("-------------------------------");
		LoginUserDto result=null;
		try {
			result=(LoginUserDto)this.getSqlMapper().queryForObject("OMCSql.getUserLogin",dto);
		} catch (SQLException e) {

			System.out.println(e);
		}
		if(result != null){
		System.out.println("--------loginTO------------");
		System.out.println("id= "+result.getStudent_cd());
		System.out.println("passwd= "+result.getPasswd());
		System.out.println("kor_nm= "+result.getKor_nm());		
		System.out.println("-------------------------------");
		}else{
			System.out.println(result);
		}
		return result;
	}//
	
	public LoginUserDto getUserLogin(String id){
		System.out.println("--------login------------");
		System.out.println("id= "+id);
		
		System.out.println("-------------------------------");
		LoginUserDto result=null;
		try {
			result=(LoginUserDto)this.getSqlMapper().queryForObject("OMCSql.getUserLogin",id);
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return result;
	}//
	public NoticeDto getNotice(int seq){
		NoticeDto result = null;
		
		try {
			result=(NoticeDto)this.getSqlMapper().queryForObject("OMCSql.getNotice",seq);
		} catch (SQLException e) {

			System.out.println(e);
		}
		if(result==null){
			System.out.println("result가 null입니다.");
		}
		return result;
	}
	
	public List<NoticeDto> getAllNotice(int snum, int endnum){
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("startNum", snum);
		maps.put("endNum", endnum);
		List<NoticeDto> result=null;
		try {
			result=(List<NoticeDto>)this.getSqlMapper().queryForList("OMCSql.getNoticeList",maps);
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return result;
		
	}
	public Boolean addNotice(NoticeDto dto){
		Boolean isS = true;
		try {
			this.getSqlMapper().insert("OMCSql.addNotice", dto);
		} catch (SQLException e) {
			System.out.println(e);
			isS=false;
		}
		return isS;
	}
	public int totalNotice(){
		NoticeDto result = null;
		try {
			result=(NoticeDto)this.getSqlMapper().queryForObject("OMCSql.totalNotice");
		} catch (SQLException e) {

			System.out.println(e);
		}		 
		return result.getTotal();

	}
	public Boolean delNotice(int seq){
		boolean isS = true;
		try{
			this.getSqlMapper().delete("OMCSql.delNotice",seq);
		}catch (SQLException e) {
			isS = false;
			System.out.println(e);
		}
		return isS;
	}
	public Boolean setNotice(NoticeDto dto){
		boolean isS = true;
		try{
			this.getSqlMapper().update("OMCSql.setNotice",dto);
		}catch (SQLException e) {
			isS = false;
			System.out.println(e);
		}
		return isS;
	}
}//
