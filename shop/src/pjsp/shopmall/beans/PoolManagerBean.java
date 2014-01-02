package pjsp.shopmall.beans;
import java.sql.*;
import java.io.IOException;
import pjsp.shopmall.database.ConnPool;

public class PoolManagerBean {
	private String dbUser,dbPasswd,dbURL, driverName;
	private int initConnections, maxConnections;
	private static ConnPool pool = null;
	private boolean initFromProperties = true;
	private boolean initialized = false;
	
	private Connection connection = null;
	public PoolManagerBean() {
		pool = new ConnPool();
	}
	public void setPath(String path) {
		pool.setPath(path);
	}
	public void setUp() throws SQLException, IOException, ClassNotFoundException {
		pool.setInitFromProperties(initFromProperties);
		pool.setUp();
		initialized = true;
	}
	public void setInitFromProperties(boolean fromFile) {
		this.initFromProperties = fromFile;
	}
	public void setDriverName(String driver) {
		driverName = driver;
	}
	public void setInitConnections(int init_connections) {
		initConnections = init_connections;
	}
	public void setMaxConnections(int max_connections) {
		maxConnections = max_connections;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public void setDbPasswd(String dbPasswd) {
		this.dbPasswd = dbPasswd;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public int getInitConnections() {
		return initConnections;
	}
	public int getMaxConnections() {
		return maxConnections;
	}
	public String getDbUser() {
		return dbUser;
	}
	public String getDbPasswd() {
		return dbPasswd;
	}
	public String getDbURL() {
		return dbURL;
	}
	public Connection getConnection() throws SQLException {
		if(!initialized) throw new SQLException("Connection Pool �� �ʱ�ȭ���� �ʾҽ��ϴ�");
		return pool.getConnection();
	}
	public void releaseConnection(Connection connection) {
		pool.releaseConnection(connection);
		connection = null;
	}
	protected void finalize() {
		if( pool != null) {
			pool.closeAll();
		}
		pool = null;
	}
}
