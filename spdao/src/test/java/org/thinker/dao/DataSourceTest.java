package org.thinker.dao;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class DataSourceTest {

	@Inject
	DataSource dataSource;
	
//	aspectjweaver 버전 업글 필요
	@Test
	public void test1()throws Exception{
		
		System.out.println(dataSource);
		
		Connection con = dataSource.getConnection();
		
		
		System.out.println(con);
	}
}
