<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<style>
input {
	font-family: Cambria(Headings);
	font-size: 15px;
	color:black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body bgcolor="#85929E">
 <form method="post" action="Registration">
 <fieldset title="REGISTRATION FORM">
<legend><B>REGISTRATION FORM</B></legend>
<table>
<tr>
<td>ID:</td>
<td><input type="text" name="id" placeholder = "123"></td>
</tr>
<tr>
<td>NAME:</td>
<td><input type="text" name="name" placeholder = "Sweta##"></td>
</tr>
<tr>
<td>Email:</td>
<td><input type="text" name="email" pattern="([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" placeholder = "Abc@mail.com"/></td>
</tr>
<tr>
<td>MOBILE:</td>
<td><input type="number" name="mobile"></td>
</tr>
<tr>
<td>PASSWORD:</td>
<td><input type="password" name="password" pattern="((?=.*\d)(?=.*[a-z])(?=.(A-Z)(?=.*[@#$]).{8,})" placeholder = "Abc.0123" title="password should contain atleast 8 characters"/></td>
</tr>
       
     <tr><td>   <input type="submit" value="register" /></td></tr>
     </table>
        </form>
</body>
</html>