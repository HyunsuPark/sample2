package org.thinker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@Inject
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

//	@Cacheable("default")
	public List<EmpVO> getAll() throws Exception {
		Thread.sleep(2000);
		jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("DB Select!!!!!!!!!!!!");
		final List<EmpVO> result = new ArrayList<EmpVO>();
		
		jdbcTemplate.query("select empno, ename from emp", new RowMapper<EmpVO>(){
			
			public EmpVO mapRow(ResultSet rs, int arg1) throws SQLException {
				
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getLong(1));
				vo.setEname(rs.getString(2));
				
				result.add(vo);
				
				
				return null;
			}
			
		});
		
		
		return result;
	}

	public EmpVO getEmp(Long empno) throws Exception {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		

		return null;
	}

	public void updateEmpViewCount(final Long empno) throws Exception {
		// TODO Auto-generated method stub
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		int result = jdbcTemplate.update("update emp set viewcnt = viewcnt+1 where empno = ?", empno);
//		int result = jdbcTemplate.update("update emp set viewcnt = 'aaa' where empno = ?", empno);
		
		if(result < 1){
			throw new Exception("fail update view count");
		}
	}

	public void create(EmpVO newVO) throws Exception {

		jdbcTemplate = new JdbcTemplate(dataSource);
		
		int result = jdbcTemplate.update("insert into emp (empno, ename) values (?,?)", new Object[]{newVO.getEmpno(), newVO.getEname()});
		
		if(result < 1){
			throw new Exception("fail update view count");
		}
		
	}

}
