package notice.model.dao;

import java.util.ArrayList;

import notice.model.vo.Notice;
import java.sql.*;

import static common.JdbcTemplate.*;

public class NoticeDao {
	public NoticeDao(){}
	
	//게시글 전체조회 처리용 메소드
	public ArrayList<Notice> selectAll()
	{
		ArrayList<Notice> list = null;
		String query = "select noticeno, noticewriter, " +
				"noticetitle, to_char(noticedate, 'YYYY/MM/DD') as noticedate, " +
				"noticecontent from notice order by 1 desc";
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<Notice>();
			while(rs.next())
			{
				Notice notice = new Notice();
				notice.setNoticeNo(rs.getInt("noticeno"));
				notice.setNoticeWriter(rs.getString("noticewriter"));
				notice.setNoticeTitle(rs.getString("noticetitle"));
				notice.setNoticeDate(rs.getString("noticedate"));
				notice.setNoticeContent(rs.getString("noticecontent"));
	
				list.add(notice);
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
	
	//글번호를 가지고 한 행정보를 조회하는 메소드
	public Notice selectRow(int no)
	{
		Notice notice = null;
		String query = "select noticeno, noticewriter, " + 
				"noticetitle, to_char(noticedate, " + 
				"'YYYY/MM/DD HH:mi:ss') noticedate, "
				+ "noticecontent from notice where noticeno = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				notice = new Notice();
				notice.setNoticeNo(rs.getInt("noticeno"));
				notice.setNoticeWriter(rs.getString("noticewriter"));
				notice.setNoticeTitle(rs.getString("noticetitle"));
				notice.setNoticeDate(rs.getString("noticedate"));
				notice.setNoticeContent(rs.getString("noticecontent"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return notice;
	}
	
	//새 글 추가 처리용
	public int insertRow(Notice notice)
	{
		int result = 0;
		String query = "insert into notice values ((select max(noticeno) from notice) + 1, ?, sysdate, ?, ?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getNoticeWriter());
			pstmt.setString(2, notice.getNoticeTitle());
			pstmt.setString(3, notice.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
			if(result > 0)
				commit(conn);
			else
				rollback(conn);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return result;
	}
	
	//글 삭제용
	public int deleteRow(int no)
	{
		int result = 0;
		String query = "delete from notice where noticeno = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			
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
	
	//글 수정용
	public int updateRow(Notice notice)
	{
		int result = 0;
		String query = "update notice set " + 
				"noticetitle = ?, noticecontent = ?, " + 
				"noticedate = sysdate " 
				+ "where noticeno = ?";
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
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
