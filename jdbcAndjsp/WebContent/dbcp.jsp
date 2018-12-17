<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Context ctx=new InitialContext();
	DataSource ds=(DataSource)ctx.lookup("java:/comp/env/jdbc/myData");
	Connection conn=ds.getConnection();
	if(conn!=null)
	{
		out.println("成功的从连接池中获取了一个连接对象");
	}else{
		out.println("失败");
	}
%>
</body>
</html>