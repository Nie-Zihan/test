package com.lucene.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucene.book.dbutil.ConnectionManager;
import com.lucene.book.dbutil.SQLManager;
import com.lucene.book.model.Book;

public class BookDao {
	// 定义一个完成图书添加的方法
	public boolean insertBook(final Book book) {
		String isbn = book.getIsbn();
		String bookname = book.getBookname();
		String author = book.getAuthor();
		String press = book.getPress();
		double price = book.getPrice();
		int pages = book.getPages();
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		SQLManager sqlManager = new SQLManager();
		String strSQL = "insert into book(isbn,bookname,author,press,price,pages) values(?,?,?,?,?,?)";
		Object[] params = new Object[] { isbn, bookname, author, press, price, pages };
		int result = sqlManager.execUpdate(connection, strSQL, params);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 查询指定id的图书信息
	public Book selectBookById(final int id) {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		String strSQL = "select * from book where id=?";
		Object[] params = new Object[] {id};
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		try {
			if(rs.next())
			{
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setIsbn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));
				book.setPages(rs.getInt("pages"));
				return book;
			}else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 定义一个完成查询所有图书信息的方法
	public List<Book> selectAllBooks() {
		// 定义一个保存图书的集合变量
		List<Book> bookList = new ArrayList<Book>();
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		String strSQL = "select * from book";
		Object[] params = new Object[] {};
		SQLManager sqlManager = new SQLManager();
		ResultSet rs = sqlManager.execQuery(connection, strSQL, params);
		try {
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setIsbn(rs.getString("isbn"));
				book.setBookname(rs.getString("bookname"));
				book.setAuthor(rs.getString("author"));
				book.setPress(rs.getString("press"));
				book.setPrice(rs.getDouble("price"));
				book.setPages(rs.getInt("pages"));

				bookList.add(book);
			}
			return bookList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// 定义一个更新指定id的图书信息
	public boolean updateBookById(final Book book, final int id) {
		// 获取图书各个新数据
		String isbn = book.getIsbn();
		String bookname = book.getBookname();
		String author = book.getAuthor();
		String press = book.getPress();
		double price = book.getPrice();
		int pages = book.getPages();
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		SQLManager sqlManager = new SQLManager();
		String strSQL = "update book set isbn=?,bookname=?,author=?,press=?,price=?,pages=? where id=?";
		Object[] params = new Object[] { isbn, bookname, author, press, price, pages, id };
		int result = sqlManager.execUpdate(connection, strSQL, params);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 删除指定id的图书信息
	public boolean deleteBookById(final int id) {
		ConnectionManager connectionManager = new ConnectionManager();
		Connection connection = connectionManager.getConnection();
		SQLManager sqlManager = new SQLManager();
		String strSQL = "delete from book where id=?";
		Object[] params = new Object[] { id };
		int result = sqlManager.execUpdate(connection, strSQL, params);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}
