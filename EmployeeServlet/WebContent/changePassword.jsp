<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="FF9933">
<form action="ChangePassword" method="post">
<fieldset title="Change Password">
<legend><B>Change password</B></legend>
<table>
<tr>
<td>ID:</td>
<td><input type="text" name="id"/></td>
</tr>
<tr>
<td>Current Password:</td>
<td><input type="password" name="currPass"/></td>
</tr>
<tr>
<td>New Password:</td>
<td><input type="password" name="newPass"/></td>
</tr>
<tr>
<td>Retype New Password:</td>
<td><input type="password" name="reNewPass"/></td>
</tr>
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td><input type="reset" value="Reset"/></td>
<td><input type="submit" value="Change Password"/></td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>