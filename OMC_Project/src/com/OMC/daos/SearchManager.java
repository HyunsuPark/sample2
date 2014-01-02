package com.OMC.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.OMC.dtos.search.ProSearch1Dto;
import com.OMC.dtos.search.ProSearch3ConDto;
import com.OMC.dtos.search.ProSelect1Dto;
import com.OMC.dtos.search.Search1ConDto;
import com.OMC.dtos.search.Search1Dto;
import com.OMC.dtos.search.Search2ConDto;
import com.OMC.dtos.search.Search2Dto;
import com.OMC.dtos.search.Search3ConDto;
import com.OMC.dtos.search.Search3Dto;
import com.OMC.dtos.search.Select11Dto;
import com.OMC.dtos.search.Select21Dto;
import com.OMC.dtos.search.Select22Dto;
import com.OMC.dtos.search.KyosuSearchDto;
import com.OMC.dtos.search.KyosuSelectDto;
import com.OMC.dtos.search.LecturePlanDto;
import com.OMC.dtos.search.LectureSearchDto;
import com.OMC.ibatis.SqlDaoSuport;

public class SearchManager extends SqlDaoSuport {

	public SearchManager() {
		super();
	}

	public SearchManager(String path) {
		super(path);
	}

	
		public List<Search1Dto> getSearch1List(Search1ConDto cDto) {
		List<Search1Dto> lists=new ArrayList<Search1Dto>();
		String cla = cDto.getSttComClass();
		int yer =cDto.getSttComYear();
		String cd =cDto.getSttDeptCd();
		String st =cDto.getSttSmt();
		String stt =cDto.getSttYear();
		System.out.println(cla+yer+cd+st+stt);
	try {
		lists=(List<Search1Dto>)this.getSqlMapper().queryForList("search.getSearch1List", cDto);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//

	
	public List<Search2Dto> getSearch2List(Search2ConDto cDto) {
		List<Search2Dto> lists=new ArrayList<Search2Dto>();
		String bld = cDto.getSttBldCd();
		String room = cDto.getArcRoomCd();
		String st = cDto.getSttSmt();
		String yer = cDto.getSttYear();
		System.out.println(bld+room+st+yer);
	try {
		lists=(List<Search2Dto>)this.getSqlMapper().queryForList("search.getSearch2List", cDto);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//	
	
	
	
	public List<Select11Dto> getSelect11List( ) {
		List<Select11Dto> lists=new ArrayList<Select11Dto>();
	try {
		lists=(List<Select11Dto>)this.getSqlMapper().queryForList("search.getSelect11List");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//
	
	
	public List<Select11Dto> getSelect12List(String deptCd) {
		List<Select11Dto> lists=new ArrayList<Select11Dto>();
	try {
		lists=(List<Select11Dto>)this.getSqlMapper().queryForList("search.getSelect12List", deptCd);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}
	
	
	
	public List<Select21Dto> getSelect21List() {
		List<Select21Dto> lists=new ArrayList<Select21Dto>();
	try {
		lists=(List<Select21Dto>)this.getSqlMapper().queryForList("search.getSelect21List");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//
	
	
	public List<Select22Dto> getSelect22List(String bldCd) {
		List<Select22Dto> lists=new ArrayList<Select22Dto>();
		try {
			lists=(List<Select22Dto>)this.getSqlMapper().queryForList("search.getSelect22List", bldCd);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return lists;
	}//
	

	public List<Search3Dto> getSearch3List(Search3ConDto cDto) {
		List<Search3Dto> lists=new ArrayList<Search3Dto>();
		String emp = cDto.getAemEmpId();
		String yer = cDto.getSttYear();
		String smt = cDto.getSttSmt();
		System.out.println(emp+yer+smt);
	try {
		lists=(List<Search3Dto>)this.getSqlMapper().queryForList("search.getSearch3List", cDto);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//	
	
	public List<ProSearch1Dto> getProSearch1List(String korNm) {
		List<ProSearch1Dto> lists=new ArrayList<ProSearch1Dto>();
	try {
		lists=(List<ProSearch1Dto>)this.getSqlMapper().queryForList("search.getProSearch1List", korNm);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//
	
	
	public List<ProSearch1Dto> getProSearch2List(String comtDept) {
		List<ProSearch1Dto> lists=new ArrayList<ProSearch1Dto>();
	try {
		lists=(List<ProSearch1Dto>)this.getSqlMapper().queryForList("search.getProSearch2List", comtDept);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//

	
	public List<ProSearch1Dto> getProSearch3List(ProSearch3ConDto cDto) {
		List<ProSearch1Dto> lists=new ArrayList<ProSearch1Dto>();
		String kor = cDto.getAemKorNm();
		String comt = cDto.getSdcComtDept();
		System.out.println(kor+comt);
	try {
		lists=(List<ProSearch1Dto>)this.getSqlMapper().queryForList("search.getProSearch3List", cDto);
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//	
	
	
	
	public List<ProSelect1Dto> getProSelect1List() {
		List<ProSelect1Dto> lists=new ArrayList<ProSelect1Dto>();
	try {
		lists=(List<ProSelect1Dto>)this.getSqlMapper().queryForList("search.getProSelect1List");
	} catch (SQLException e) {
		System.out.println(e);
	}
	return lists;
	}//

	public List<LectureSearchDto> getLectureSearch(String curi_num) {
		System.out.println("--------------------");
		System.out.println(" ="+curi_num);
		System.out.println("-------------------------------");
		List<LectureSearchDto> lists = new ArrayList<LectureSearchDto>();
		try {
			lists=(List<LectureSearchDto>)this.getSqlMapper().queryForList("search.getLectureSearch",curi_num);
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	

	public List<LectureSearchDto> getLectureSearch1(String curi_nm) {
		System.out.println("--------------------");
		System.out.println(" ="+curi_nm);
		System.out.println("-------------------------------");
		List<LectureSearchDto> lists = new ArrayList<LectureSearchDto>();
		try {
			lists=(List<LectureSearchDto>)this.getSqlMapper().queryForList("search.getLectureSearch1",curi_nm);
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LectureSearchDto> getLectureSearch2(String curi_num,String curi_nm) {
		System.out.println("-------------------");
		System.out.println(" ="+curi_num);
		System.out.println(" ="+curi_nm);
		System.out.println("-------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("curi_num", curi_num);
		map.put("curi_nm", curi_nm);
		List<LectureSearchDto> lists = new ArrayList<LectureSearchDto>();
		try {
			lists=(List<LectureSearchDto>)this.getSqlMapper().queryForList("search.getLectureSearch2",map);
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LectureSearchDto> getLectureSearch3() {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		List<LectureSearchDto> lists = new ArrayList<LectureSearchDto>();
		try {
			lists=(List<LectureSearchDto>)this.getSqlMapper().queryForList("search.getLectureSearch3");
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<KyosuSelectDto> getKyosuSelect() {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		List<KyosuSelectDto> lists = new ArrayList<KyosuSelectDto>();
		try {
			lists=(List<KyosuSelectDto>)this.getSqlMapper().queryForList("search.getKyosuSelect");
			System.out.print(lists.size());
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<KyosuSearchDto> getKyosuSearch(String kor_nm) {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		List<KyosuSearchDto> lists = new ArrayList<KyosuSearchDto>();
		try {
			lists=(List<KyosuSearchDto>)this.getSqlMapper().queryForList("search.getKyosuSearch",kor_nm);
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<KyosuSearchDto> getKyosuSearch1() {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		List<KyosuSearchDto> lists = new ArrayList<KyosuSearchDto>();
		try {
			lists=(List<KyosuSearchDto>)this.getSqlMapper().queryForList("search.getKyosuSearch1");
		} catch (Exception e) {

			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<KyosuSearchDto> getKyosuSearch2(String subject) {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		List<KyosuSearchDto> lists = new ArrayList<KyosuSearchDto>();
		try {
			lists=(List<KyosuSearchDto>)this.getSqlMapper().queryForList("search.getKyosuSearch2",subject);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<KyosuSearchDto> getKyosuSearch3(String kor_nm,String subject) {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kor_nm", kor_nm);
		map.put("subject", subject);
		List<KyosuSearchDto> lists = new ArrayList<KyosuSearchDto>();
		try {
			lists=(List<KyosuSearchDto>)this.getSqlMapper().queryForList("search.getKyosuSearch3",map);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LecturePlanDto> getLecturePlan(String curi_num1,String curi_nm1,String kor_nm1,String semester) {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("curi_num1", curi_num1);
		map.put("curi_nm1", curi_nm1);
		map.put("kor_nm1", kor_nm1);
		map.put("semester", semester);
		List<LecturePlanDto> lists = new ArrayList<LecturePlanDto>();
		try {
			lists=(List<LecturePlanDto>)this.getSqlMapper().queryForList("search.getLecturePlan",map);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LecturePlanDto> getLecturePlan1() {
		System.out.println("--------getLecturePlan1------------");
		System.out.println("-------------------------------");
		List<LecturePlanDto> lists = new ArrayList<LecturePlanDto>();
		try {
			lists=(List<LecturePlanDto>)this.getSqlMapper().queryForList("search.getLecturePlan1");
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	

	public List<LecturePlanDto> getLecturePlan2(String curi_num1,String curi_nm1,String semester) {
		System.out.println("--------------------");
		System.out.println("-------------------------------");
		curi_nm1 = curi_nm1.toUpperCase();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("curi_num1", curi_num1);
		map.put("curi_nm1", curi_nm1);
		map.put("semester", semester);
		List<LecturePlanDto> lists = new ArrayList<LecturePlanDto>();
		try {
			lists=(List<LecturePlanDto>)this.getSqlMapper().queryForList("search.getLecturePlan2",map);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LecturePlanDto> getLecturePlan3(String kor_nm1,String semester) {
		System.out.println("---------getLecturePlan3-----------");
		System.out.println("-------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kor_nm1", kor_nm1);
		map.put("semester", semester);
		List<LecturePlanDto> lists = new ArrayList<LecturePlanDto>();
		try {
			lists=(List<LecturePlanDto>)this.getSqlMapper().queryForList("search.getLecturePlan3",map);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	public List<LecturePlanDto> getLecturePlan4(String curi_nm1,String semester) {
		System.out.println("---------getLecturePlan3-----------");
		System.out.println("-------------------------------");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("curi_nm1", curi_nm1);
		map.put("semester", semester);
		List<LecturePlanDto> lists = new ArrayList<LecturePlanDto>();
		try {
			lists=(List<LecturePlanDto>)this.getSqlMapper().queryForList("search.getLecturePlan4",map);
		} catch (Exception e) {
			System.out.println(e);
		}		 
		return lists;
	}//
	
	
	
}
