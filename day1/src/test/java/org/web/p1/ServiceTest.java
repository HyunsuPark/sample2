package org.web.p1;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.web.p1.movie.MovieService;

//@ContextConfiguration(
//		  classes={org.web.config.PojoConfig.class}, 
//		  loader = AnnotationConfigContextLoader.class)
public class ServiceTest extends DaoTest {
	
	@Inject
	private MovieService service;
	
	@Bean
	public Object abc(){
		return new Object();
	}
	
	@Test
	public void test2() throws Exception{
		service.addNewMovie(null);
	}
}
