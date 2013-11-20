package user.model.dao;

import user.model.vo.User;
import static common.JdbcTemplate.*;

import java.sql.*;

import common.LoggableStatement;

public class UserDao {
	public UserDao(){}
	
	//로그인 처리용 메소드
	public User loginCheck(String uid, String upwd)
	{
		User loginUser = null;
		String query = "select * from tb_user " + 
				"where user_id = ? and password = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			pstmt = conn.prepareStatement(query);
			
			pstmt = new LoggableStatement(conn, query);
			
			pstmt.setString(1, uid);
			pstmt.setString(2, upwd);
			
			System.out.println(("Query :: "+((LoggableStatement)pstmt).getQueryString()));
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				loginUser = new User();
				
				loginUser.setUserId(rs.getString("user_id"));
				loginUser.setPassword(rs.getString("password"));
				loginUser.setName(rs.getString("name"));
				loginUser.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return loginUser;
	}
}
