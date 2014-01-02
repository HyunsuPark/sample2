package pjsp.shopmall.beans;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.servlet.jsp.PageContext;
public class ShopDBBean {
	private String table = null;
	private String query = null;
	private String orderListQuery = null;
	private String orderListTable = null;
	private String message = "";	
	private PageContext pageContext;
	private LoginInfoBean userInfo;
	private PoolManagerBean database;
	private Connection connection;
	private CartBean cart;
	
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		init();
	}
	private void init() {
		if( pageContext != null) {
			this.database =	
			(PoolManagerBean)pageContext.getAttribute("database", PageContext.APPLICATION_SCOPE);
			this.userInfo = 
			(LoginInfoBean) pageContext.getAttribute("userInfo", PageContext.SESSION_SCOPE);
			this.cart = 
			(CartBean) pageContext.getAttribute("cart", PageContext.SESSION_SCOPE);
		}
	}		
	public void setQuery(BookBean book) throws SQLException {
		if(table == null) 
			throw new SQLException("서적 테이블이 설정되지 않았습니다 -ShopDBBean");
		String isbn = book.getIsbn();
		int quantity = book.getQuantity();
		query = "Update " + table + " set remaining=remaining-" 
		+ quantity + " Where isbn=" + "'" + isbn + "'";
		System.out.println(query);
	}
	public void setOrderListQuery(BookBean book) 
	throws SQLException {
		if(orderListTable == null) {
			throw new SQLException ("주문배송 테이블이 설정되지 않았습니다 -ShopDBBean");
		}
		String id = userInfo.getId();
		String passwd = userInfo.getPasswd();
		String name = userInfo.getName();
		String address = userInfo.getAddress();
		String phone = userInfo.getPhone();
		
		String isbn = book.getIsbn();
		String title = book.getTitle();
		int quantity = book.getQuantity();
		int price = book.getPrice();
				
		orderListQuery = "insert into orderlist values(" 
		+ makeSQL(id) + ", " + makeSQL(passwd) + ", " 
		+ makeSQL(name) + ", " + makeSQL(address) + ", " 
		+ makeSQL(phone) + ", " + makeSQL(isbn) + ", " 
		+ makeSQL(title) + ", " + quantity + ", " + price + ")";
	} 
	public void setTable(String table) {
		this.table = table;
	}
	public void setOrderListTable(String orderListTable) {
		this.orderListTable = orderListTable;
	}
	public String getTable() {
		return this.table;
	}
	public String getOrderListTable() {
		return this.orderListTable;
	}
	public String getMessage() {
		return message;
	}
	private void updateDB(BookBean book) throws SQLException {
		if(connection == null) return;
		setQuery(book);
		Statement stmt = connection.createStatement ();
		int affectedRow = stmt.executeUpdate(query);
		if(affectedRow == 0) {
			throw new SQLException ("ISBN Invalid");
		}
	}
	private void updateOrderListDB(BookBean book) 
	throws SQLException {
		setOrderListQuery(book);
		Statement stmt = connection.createStatement();
		System.out.println(orderListQuery);//for testing use
		stmt.executeUpdate(orderListQuery);
	}
	public void setOrderComplete(boolean complete) {
		if(!complete) return;
		Enumeration books = cart.getBooks();
		try {
			connection = database.getConnection();
			while(books.hasMoreElements()) {
				BookBean book = (BookBean)books.nextElement();
				updateDB(book);
				updateOrderListDB(book);
				message  = userInfo.getName () + 
				" 님의 주문이 성공적으로 처리되었습니다";
			}
			connection.commit();
			System.out.println("database transaction committed");
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch(SQLException  ex) {}
			message = 
			userInfo.getName() + " 님의 주문이 성공적으로 처리되지 못했습니다";
			message += ": " + e.getMessage();
			System.out.println("database transaction rollbacked");
		}finally {
			database.releaseConnection(connection);
			connection = null;
		}
	}
	private String makeSQL(String str) {
		if(str == null) return null;
		return "'" + str + "'";
	}
}
