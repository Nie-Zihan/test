<%@page import="com.lucene.book.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.lucene.book.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
	<h2>所有信息如下</h2>
	&nbsp;
	<a href="addBook.html">添加图书信息</a>
	<hr>
	<%
		BookDao bookDao = new BookDao();
		List<Book> bookList = bookDao.selectAllBooks();
		for (int i = 0; i < bookList.size(); i++) {
			out.println(bookList.get(i).getId() + "," + bookList.get(i).getBookname() + ","
					+ bookList.get(i).getIsbn() + "," + bookList.get(i).getAuthor() + ","
					+ bookList.get(i).getPress() + "," + bookList.get(i).getPrice() + ","
					+ bookList.get(i).getPages() + "<a href='update.jsp?id=" + bookList.get(i).getId()
					+ "'>更新</a>&nbsp;<a href='delete.jsp?id=" + bookList.get(i).getId()
					+ "' onclick='return deleteRecord()'>删除</a><br>");
		}
	%>

</body>
</html>