package board.model.dao;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import board.model.vo.Board;

public class BoardDao {
	public BoardDao(){}
	
	//게시글 전체조회 처리용 메소드
	public ArrayList<Board> selectAll()
	{
		ArrayList<Board> list = null;
		String query = "SELECT * from board order by REFER DESC, LEV ASC";
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			while(rs.next())
			{
				Board board = new Board();
				board.setIdx(rs.getInt("idx"));
				board.setWriter(rs.getString("writer"));
				board.setPwd(rs.getString("pwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setWritedate(rs.getString("writedate"));
				board.setReadnum(rs.getInt("readnum"));
				board.setFilename(rs.getString("filename"));
				board.setFilesize(rs.getInt("filesize"));
				board.setRefer(rs.getInt("refer"));
				board.setLev(rs.getInt("lev"));
				board.setSunbun(rs.getInt("sunbun"));

				list.add(board);
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
	public Board selectRow(int idx)
	{
		Board board = null;
		String query = "SELECT * from board where idx = ? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				board = new Board();
				board.setIdx(rs.getInt("idx"));
				board.setWriter(rs.getString("writer"));
				board.setPwd(rs.getString("pwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setWritedate(rs.getString("writedate"));
				board.setReadnum(rs.getInt("readnum"));
				board.setFilename(rs.getString("filename"));
				board.setFilesize(rs.getInt("filesize"));
				board.setRefer(rs.getInt("refer"));
				board.setLev(rs.getInt("lev"));
				board.setSunbun(rs.getInt("sunbun"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return board;
	}
	
	//새 글 추가 처리용
	public int insertRow(Board board)
	{
		int result = 0;
		String query = "INSERT INTO board(IDX," +
				" WRITER, PWD, SUBJECT, " + 
				" CONTENT, WRITEDATE, READNUM, FILENAME, FILESIZE, " + 
				" REFER , LEV, SUNBUN) "+ "values(NVL((SELECT MAX(IDX) FROM BOARD),0)+1,?,?,?,?,SYSDATE,0,?,?,0,0,0)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getPwd());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getFilename());
			pstmt.setLong(6, board.getFilesize());
			
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
	
	//글 삭제용
	public int deleteRow(int idx)
	{
		int result = 0;
		String query = "delete from board where idx = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			
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
//	public int updateRow(Notice notice)
//	{
//		int result = 0;
//		String query = "update notice set " + 
//				"noticetitle = ?, noticecontent = ?, " + 
//				"noticedate = sysdate " 
//				+ "where noticeno = ?";
//		PreparedStatement pstmt = null;
//		Connection conn = getConnection();
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, notice.getNoticeTitle());
//			pstmt.setString(2, notice.getNoticeContent());
//			pstmt.setInt(3, notice.getNoticeNo());
//			
//			result = pstmt.executeUpdate();
//			
//			if(result > 0)
//				commit(conn);
//			else
//				rollback(conn);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally{
//			close(pstmt);
//			close(conn);
//		}
//		
//		return result;
//	}
}
