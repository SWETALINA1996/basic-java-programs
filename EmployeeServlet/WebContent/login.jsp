<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<style>
input {
	font-family: Cambria(Headings);
	font-size: 20px;
	color:green;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#85929E">
<form action="Login" method="post">
<fieldset title="LOGIN">
<legend><B>LOGIN</B></legend>
<table>
<tr>
<td>USERID:</td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>PASSWORD:</td>
<td><input type="password" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="login"></td>
<td><input type="reset" value="reset"></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>
