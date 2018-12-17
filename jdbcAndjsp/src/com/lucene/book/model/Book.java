package com.lucene.book.model;

public class Book {
	private int id;
	private String isbn;
	private String bookname;
	private String author;
	private String press;
	private double price;
	private int pages;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Book(int id, String isbn, String bookname, String author, String press, double price, int pages) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.price = price;
		this.pages = pages;
	}
	public Book(String isbn, String bookname, String author, String press, double price, int pages) {
		super();
		this.isbn = isbn;
		this.bookname = bookname;
		this.author = author;
		this.press = press;
		this.price = price;
		this.pages = pages;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookname=" + bookname + ", author=" + author + ", press="
				+ press + ", price=" + price + ", pages=" + pages + "]";
	}
	
	
}
