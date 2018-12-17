<%@page import="com.lucene.book.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		BookDao bookDao = new BookDao();
		boolean flag = bookDao.deleteBookById(id);

		if (flag) {
			out.println("<script>window.location.href='showAllBooks.jsp'</script>");
		} else {
			out.println("<script>alert('删除失败');window.location.href='showAllBooks.jsp'</script>");

		}
	%>
</body>
</html>