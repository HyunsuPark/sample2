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
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return board;
	}
	
	public int countRef(int idx)
	{
		String query = "SELECT count(*) as cnt from board where refer = ? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				count = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return count;
	}
	
	//새 글 추가 처리용
	public int insertRow(Board board)
	{
		int result = 0;
		String query = "INSERT INTO board(IDX," +
				" WRITER, PWD, SUBJECT, " + 
				" CONTENT, WRITEDATE, READNUM, FILENAME, FILESIZE, " + 
				" REFER , LEV, SUNBUN) "+ "values(seq_board_idx.nextval,?,?,?,?,SYSDATE,0,?,?,seq_board_idx.currval,0,0)";
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
	
	public int updateRef(int idx)
	{
		int result = 0;
		String query = "update board set refer = ? where idx = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, idx);
			
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
	
	public int updateSunbun(int idx)
	{
		int result = 0;
		String query = "update board set sunbun = (select max(sunbun)+1 from board where idx = seq_board_idx.currval) where idx = seq_board_idx.currval ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, idx);
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
	
	public int updateReadNum(int idx)
	{
		int result = 0;
		String query = "update board set READNUM = (select READNUM from board where idx = ?)+1 where idx = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, idx);
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
	
	public int[] getEtc(int idx){
		int[] etc = new int[3];
		
		String sql = "SELECT REFER ,LEV, SUNBUN " +
				 "FROM board WHERE idx = ?";
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				etc[0] = rs.getInt(1);
				etc[1] = rs.getInt(2);
				etc[2] = rs.getInt(3);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return etc;
	}
	
	public int insertReply(Board board,int idx,int lev)
	{ 
		int result = 0;
		int[] etc = new int[3];
		
		etc = getEtc(idx); 
				
		String query = "INSERT INTO board(IDX," +
				" WRITER, PWD, SUBJECT, " + 
				" CONTENT, WRITEDATE, READNUM, FILENAME, FILESIZE, " + 
				" REFER , LEV, SUNBUN) "+ "values(seq_board_idx.nextval,?,?,?,?,SYSDATE,0,'',0,?,?,?)";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getPwd());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, etc[0]);
			pstmt.setInt(6, etc[1]+1);
			pstmt.setInt(7, etc[2]+1);
			
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
	public int updateRow(Board board)
	{
		int result = 0;
		String query = "update board set " + 
				"subject = ?, content = ?, writedate = sysdate " + 
				 "where idx = ?";
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getIdx());
			
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
