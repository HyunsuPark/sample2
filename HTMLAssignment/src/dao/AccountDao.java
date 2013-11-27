package dao;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.AccountEntity;

public class AccountDao {
	
		//로그인 처리용 메소드
		public AccountEntity loginCheck(String uid, String upwd)
		{
			AccountEntity loginUser = null;
			String query = "select * from tb_user " + 
					"where user_id = ? and password = ?";
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, uid);
				pstmt.setString(2, upwd);
				
				rs = pstmt.executeQuery();
				
				if(rs.next())
				{
					loginUser = new AccountEntity();
					
					loginUser.setUser_id(rs.getString("user_id"));
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
