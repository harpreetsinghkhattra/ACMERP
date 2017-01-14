<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<style>
a.pwd:LINK{color:#FF7F50; text-decoration: none}
a.pwd:VISITED {
	color:#FF8C00;
	text-decoration:none;
}
a.pwd:HOVER {
	color:#9ACD32;
	text-decoration:none;
}
</style>
<center>
<fieldset style="width:600px;">
<legend><img src="1.jpg" alt="sviet"></legend>
<p style="color:#FF4500;font-size: 24px;">${message55}</p>    
             <c:remove var="message55" scope="session"/>
<form action="erpchlog" method="post">
<table>
<tr><td>Username:</td><td>
<input type="text" name="chuser_name"></td></tr>
<tr><td>Password:</td><td>
<input type="password" name="password"></td></tr>
<tr><td>
<input type="submit" name="submit" value="login"><br><br></td></tr>
<tr><td>
<label  for="username" id="username" ></label></td></tr>
<tr><td></td><td>
<a class="pwd" href="forgetchpassword.jsp">Are You Forget Your Password</a></td></tr>
</table>
</form>
</fieldset>
</center>
</body>
</html>