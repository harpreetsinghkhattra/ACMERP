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
       
              
        <fieldset style="width:500px;"> <legend> <img src="1.jpg" alt="happy"> </legend>
            <form action="erpstudentlog"  method="post">

            <table>
                
                 <tr>
                     <td>
                         Username:</td><td><input type="text" name="username" ></td>
                 </tr>
                 <tr>
                     <td>
                         Password:</td><td><input type="password" name="pass" ></td>
                 <p style="color:#FF4500">${message}</p>    
             <c:remove var="message" scope="session"/>
                 </tr>
                 <tr><td><input type="submit" name="erpsub" value="login"></td></tr>
                 <tr><td></td>
                 
                 <td>                &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp  <a class="pwd" href="studentforgetpwd.jsp">Are you forget your password</a>
                 </td>
                 </tr>
                 </table>
                 </form>
                </fieldset>
                                    
    </center>        

</body>
</html>