package pjsp.shopmall.beans;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Hashtable;
public class CartBean {
	private BookBean lastItem ;
	private Hashtable items = new Hashtable();
	private String prevParam = "";
	public CartBean() {
	}
	
	public void addItem(BookBean book) {
		if(book.getQuantity() > 0) {
			if(items.containsKey(book.getIsbn())) {
				BookBean item = (BookBean)items.get(book.getIsbn());
				int quantity = item.getQuantity() + book.getQuantity();
				item.setQuantity(quantity);
			} else {
				lastItem = book;
				items.put(book.getIsbn(), book);
			}
		}
	}
	public void removeItem(BookBean book){
		items.remove(book.getIsbn());
	}
	public CartBean getCart() {
		return this;
	}	
	public Hashtable getItems() {
		return items;
	}
	public String toString() {
		int num_books = 0;
		int num = 0;
		long total_price = 0;
		Enumeration enum2 = items.elements();
		StringBuffer sb = new StringBuffer(2 * 1024);
		if(items.isEmpty()) return "선택하신 물품이 없습니다.!"; 
		while(enum2.hasMoreElements()) {
			BookBean book = (BookBean) enum2.nextElement();
			num = book.getQuantity();
			total_price += book.getPrice() * num;
			num_books += num;
			sb.append(book.toString());
		}
		sb.append("총: " + num_books + "&nbsp;&nbsp; 합계: " + total_price +" 원 <P> ");
		return sb.toString();
	}
	public  String getPrevParam() {
		if(items.isEmpty()) {
			return prevParam;
		} else {
			String title = lastItem.getTitle();
			String category = lastItem.getCategory();
			if(title != null && category != null) {
				prevParam = "title=" + URLEncoder.encode(title) 
				+ "&category=" + URLEncoder.encode(category);
				return prevParam;
			} else {
				return "title=+&category=+";
			}
		}
	}
	public Enumeration getBooks() {
		Enumeration books = items.elements();
		return books;
	}
	public void setPrevParam(String prevParam) {
		this.prevParam = prevParam;
	}
	public void setEmpty(boolean empty) {
		if(empty) {
			items.clear();
		}
	}
}