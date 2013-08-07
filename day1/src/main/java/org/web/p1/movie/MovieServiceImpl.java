package org.web.p1.movie;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Inject
	private MovieDAO dao;
	
	@Override
	public void addNewMovie(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.create(vo);
	}

}
