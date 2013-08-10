package org.thinker.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

public class EmpServiceTest  extends DataSourceTest{
	
	@Inject
	EmpService service;

	@Test
	public void testList()throws Exception{
		
		List<EmpVO> list = service.getAllEmpList();
		
		System.out.println(list);
	}
	
	
	@Test
	public void testInsert() throws Exception{
		
		EmpVO vo = new EmpVO();
		vo.setEmpno(1234L);
		vo.setEname("SampleUser");	
		
		service.regist(vo);
	}
}

