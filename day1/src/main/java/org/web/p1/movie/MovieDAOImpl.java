package org.web.p1.movie;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAOImpl implements MovieDAO {

	private static Logger logger = Logger.getLogger(MovieDAOImpl.class);
	
	@Override
	public void create(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
		logger.info("create~~~~~~~~~~~~~~~~~~~~");
	}

	@Override
	public void update(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public MovieVO read(String mid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
