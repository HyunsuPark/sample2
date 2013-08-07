package org.web.p1;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web.p1.movie.MovieDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/**/*-context.xml"})
public class DaoTest {
	
	private static Logger logger = Logger.getLogger(DaoTest.class);
	@Inject
	private MovieDAO dao;
 
	@Test
	public void test1(){
		logger.info(dao);
	}
}
