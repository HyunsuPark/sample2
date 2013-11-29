package common;

import java.sql.*;

public class JdbcTemplate {
	private JdbcTemplate(){}
	
	public static Connection getConnection()
	{
		Connection con = null;
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "student";
		String pwd = "tiger";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con)
	{
		if(isConnected(con))
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement st)
	{
		if(st != null)
		{
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void commit(Connection con)
	{
		if(isConnected(con))
		{
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void rollback(Connection con)
	{
		if(isConnected(con))
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean isConnected(Connection con)
	{
		boolean bool = false;
		
		try {
			if(!con.isClosed())
				bool = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return bool;
	}
}
