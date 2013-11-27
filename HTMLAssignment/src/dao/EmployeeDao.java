package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.EmployeeEntity;
import static common.JdbcTemplate.*;

public class EmployeeDao {
	public ArrayList<EmployeeEntity> selectAll()
	{
		ArrayList<EmployeeEntity> list = null;
		String query = "select *" +	" from TB_EMP";
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<EmployeeEntity>();
			while(rs.next())
			{
				EmployeeEntity emp = new EmployeeEntity();
				emp.setNo(rs.getString("no"));
				emp.setName(rs.getString("name"));
				emp.setJik(rs.getString("jik"));
				emp.setTel(rs.getString("tel"));
				emp.setHobby(rs.getString("hobby"));
				emp.setEtc(rs.getString("ect"));
				
				list.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return list;
	}
	
	public EmployeeEntity searchRow(String no)
	{
		EmployeeEntity emp = new EmployeeEntity();
		String query = "select * " +
				" from TB_EMP where no=?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				emp.setNo(rs.getString("no"));
				emp.setName(rs.getString("name"));
				emp.setJik(rs.getString("jik"));
				emp.setTel(rs.getString("tel"));
				emp.setHobby(rs.getString("hobby"));
				emp.setEtc(rs.getString("ect"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return emp;
	}
	
	public int insertEmployee(EmployeeEntity emp)
	{
		int result = 0;
		String query = "insert into TB_EMP values (?, ?, ?, ?, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, emp.getNo());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getJik());
			pstmt.setString(4, emp.getTel());
			pstmt.setString(5, emp.getHobby());
			pstmt.setString(6, emp.getEtc());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
}
