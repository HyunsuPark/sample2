package travel.model.dao;

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

import travel.model.vo.Travel;

public class TravelDao {
	public TravelDao() {
	}

	// 리스트조회
	public ArrayList<Travel> listAll() {
		Travel travel = null;
		String query = "select * from TB_TRAVEL order by 1 desc";
		Connection conn = getConnection();
		Statement pstmt = null;
		ResultSet rs = null;

		ArrayList<Travel> list = new ArrayList<Travel>();

		try {
			pstmt = conn.createStatement();

			// pstmt.setString(1, uid);

			rs = pstmt.executeQuery(query);

			while (rs.next()) {
				travel = new Travel();

				travel.setTravel_code(rs.getString("TRAVEL_CODE"));
				travel.setLocation(rs.getString("LOCATION"));
				travel.setTravel_title(rs.getString("TRAVEL_TITLE"));
				travel.setDeparture_date(rs.getString("DEPARTURE_DATE"));
				travel.setReturn_date(rs.getString("RETURN_DATE"));
				travel.setPrice(rs.getString("PRICE"));
				travel.setAirline(rs.getString("AIRLINE"));

				list.add(travel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return list;
	}

	// 리스트조회
	public ArrayList<Travel> listSearch(String loc) {
		Travel travel = null;
		String query = "select * from TB_TRAVEL where LOCATION = ? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Travel> list = new ArrayList<Travel>();

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, loc);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				travel = new Travel();

				travel.setTravel_code(rs.getString("TRAVEL_CODE"));
				travel.setLocation(rs.getString("LOCATION"));
				travel.setTravel_title(rs.getString("TRAVEL_TITLE"));
				travel.setDeparture_date(rs.getString("DEPARTURE_DATE"));
				travel.setReturn_date(rs.getString("RETURN_DATE"));
				travel.setPrice(rs.getString("PRICE"));
				travel.setAirline(rs.getString("AIRLINE"));

				list.add(travel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return list;
	}

	// 리스트추가
		public int listInsert(Travel t) {
			String query = "insert into TB_TRAVEL values (? , ? , ? , ? , ? , ? , ?)";
			Connection conn = getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(query);

				pstmt.setString(1, t.getTravel_code());
				pstmt.setString(2, t.getLocation());
				pstmt.setString(3, t.getTravel_title());
				pstmt.setString(4, t.getDeparture_date());
				pstmt.setString(5, t.getReturn_date());
				pstmt.setString(6, t.getPrice());
				pstmt.setString(7, t.getAirline());

				result = pstmt.executeUpdate(); 
				
				if (result > 0) {
					commit(conn);
				} else {
					rollback(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
				close(conn);
			}

			return result;
		}
		
	// 리스트수정
	public int listUpdate(Travel t) {
		String query = "update TB_TRAVEL set LOCATION = ? , TRAVEL_TITLE = ? , DEPARTURE_DATE = ? , RETURN_DATE = ? , PRICE = ? , AIRLINE = ? where TRAVEL_CODE = ? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, t.getLocation());
			pstmt.setString(2, t.getTravel_title());
			pstmt.setString(3, t.getDeparture_date());
			pstmt.setString(4, t.getReturn_date());
			pstmt.setString(5, t.getPrice());
			pstmt.setString(6, t.getAirline());
			pstmt.setString(7, t.getTravel_code());

			result = pstmt.executeUpdate();
			
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		return result;

	}

	// 리스트삭제
	public int listDelete(String code) {
		String query = "delete from TB_TRAVEL where TRAVEL_CODE = ? ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, code);

			result = pstmt.executeUpdate();
			
			if (result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return result;
	}
}
