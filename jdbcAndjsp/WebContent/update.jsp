<%@page import="com.lucene.book.model.Book"%>
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
		BookDao bookDao=new BookDao();
		Book book=bookDao.selectBookById(id);

		//out.println("<form action='doUpdate.jsp?id='" + id + " method='post'>");
		//out.println("isbn:<input type='text' name='isbn' value='"+rs.getString("isbn")+"'><br>");
		if(book!=null)
		{
			%>
			<form action="doUpdate.jsp?id=<%=id%>" method="post">
		isbn:<input type="text" name="isbn" value="<%=book.getIsbn()%>"><br>
		bookname:<input type="text" name="bookname" value="<%=book.getBookname()%>"><br> 
		author:<input type="text" name="author" value="<%=book.getAuthor()%>"><br>
		press:<input type="text" name="press"
			value="<%=book.getPress()%>"><br> price:<input
			type="text" name="price" value="<%=book.getPrice()%>"><br>
		pages:<input type="text" name="pages" value="<%=book.getPages()%>"><br>
		<input type="submit" value="更新">
	</form>
			<% 
		}else{
			out.println("<script>alert('更新异常');window.location.herf='showAllbooks.jsp'</script>");
		}
	%>
	
</body>
</html>