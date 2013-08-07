package org.web.p1.movie;

public interface MovieDAO {
	public void create(MovieVO vo) throws Exception;
	public void update(MovieVO vo) throws Exception;
	public void delete(MovieVO vo) throws Exception;
	public MovieVO read(String mid) throws Exception;
}
