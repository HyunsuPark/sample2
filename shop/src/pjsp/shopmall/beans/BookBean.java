package pjsp.shopmall.beans;
import pjsp.shopmall.util.*;
public class BookBean {
	private String title;
	private String publisher;
	private String author;
	private int price;
	private String isbn;
	private String category;
	private int remaining;
	private int quantity;
	private UtilBean utils;
	private String description; 
	
	public void setUtils(UtilBean utils) {
		this.utils = utils;
	}	
	public void setTitle(String title) {
		this.title = utils.asc2ksc(title);
	}
	public void setPublisher(String publisher) {
		this.publisher = utils.asc2ksc(publisher);
	}
	public void setAuthor(String author) {
		this.author = utils.asc2ksc(author);
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCategory(String category){
		this.category = utils.asc2ksc(category);
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTitle() {
		if(title == null) title = "not set";
		return title;
	}
	public String getPublisher() {
		if(publisher == null) publisher="not set";
		return publisher;
	}
	public String getAuthor(){
		if(author == null) author = "not set";
		return author;
	}
	public int getPrice() {
		return price;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getCategory() {
		return category;
	}
	public int getRemaining() {
		return remaining;
	}
	public int getQuantity() {
		return quantity;
	}
	public BookBean getBook() {
		return this;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<TABLE BORDER=\"0\" CELLPADDING=\"10\"><TR><TD>");
		sb.append("도서명: " + title + "</TD><TR><TD>");
		sb.append("저&nbsp;&nbsp;자: " + author + "</TD></TR><TR><TD>");
		sb.append("출판사: " + publisher + "</TD></TR><TR><TD>");
		sb.append("가&nbsp;&nbsp;격:  " + price + " 원</TD></TR>");
		if(getQuantity() != 0) {
			sb.append("<TR><TD>수&nbsp;&nbsp;량:  " + getQuantity() + "</TD></TR>");
		}
		sb.append("</TABLE><P>");
		return sb.toString();
	}
}

