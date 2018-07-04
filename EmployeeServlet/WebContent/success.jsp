<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#5D6D7E">
<form action="LogoutServlet" method="post">
<h1>WELCOME</h1>
<%String id=(String)request.getSession().getAttribute("passID");
out.print("your id is :"+id);%>
<input type="submit" value="Logout"/>
</body>
</html>