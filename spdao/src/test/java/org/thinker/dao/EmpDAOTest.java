package org.thinker.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;

public class EmpDAOTest extends DataSourceTest{
	
	@Inject
	EmpDAO empDAO;

	@Test
	public void testList()throws Exception{
		List<EmpVO> list = empDAO.getAll();
		list = empDAO.getAll();
		
		System.out.println(list);
	}
}
