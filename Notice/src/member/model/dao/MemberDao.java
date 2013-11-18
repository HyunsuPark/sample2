package member.model.dao;

import member.model.dto.Member;
import static common.JdbcTemplate.*;
import java.sql.*;

public class MemberDao {

	public MemberDao(){}
	
	//로그인 처리용 메소드
	public Member loginCheck(String uid, String upwd)
	{
		Member m = null;
		String query = "select userid, userpwd, username from member where userid = ? and userpwd = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uid);
			pstmt.setString(2, upwd);
			
			rs = pstmt.executeQuery();			
			
			if(rs.next())
			{
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3));
			}
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return m;
	}
	
	//회원가입 처리용 메소드
	public int insertMember(Member m)
	{
		int result = 0;
		String query = "insert into member values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getPasswordQuestion());
			pstmt.setString(7, m.getPasswordAnswer());
			pstmt.setString(8, m.getMarriage());
			pstmt.setString(9, m.getHobby());
			pstmt.setString(10, m.getEtc());
			
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
	
	//id 를 이용한 회원정보 검색용 메소드
	public Member selectMember(String uid)
	{
		Member m = null;
		String query = "select * from member where userid = '" + uid + "'";
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				m = new Member();
				
				m.setMemberId(rs.getString(1));
				m.setPassword(rs.getString(2));
				m.setName(rs.getString(3));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setMarriage(rs.getString("marriage"));
				m.setPasswordQuestion(rs.getString("pwdQuestion"));
				m.setPasswordAnswer(rs.getString("pwdAnswer"));
				m.setHobby(rs.getString("hobby"));
				m.setEtc(rs.getString("etc"));				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			close(rs);
			close(stmt);
			close(conn);
		}
		
		return m;
	}
}
