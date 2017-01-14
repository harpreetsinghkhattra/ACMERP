<%@page import="acm_add.acmoperation"%>
<%@page import="acm_de.basemodel"%>
<%@page import="acm_de.validations"%>
<%@page import="acm_add.studentinfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body
{
background-color:#20B2AA;margin:0px;
}
#to
{
width:1100px;margin: auto;
}
#top
{
background-color:#F8F8FF; margin:auto;border-top-right-radius:6px;border-top-left-radius:6px;
}
#topdropdown
{
float:right;padding-top: 20px; 
}
#round
{
border-radius:10%;
}
#pad
{
padding-top:15px;
}
#padd
{
padding-top:25px;
}
.bo
{
cursor:pointer;border-radius:4px;margin:5px; border:none;width:200px;height:30px;background-color: #87CEEB;color:#FFFFFF;text-align: center;padding:5px;
}
</style>
</head>
<body>
<%
String user_name=null;
String user=null;
studentinfobean obj=new studentinfobean();
acmoperation obj1=new acmoperation();
user_name=session.getAttribute("username").toString();
user=user_name;
obj=obj1.getstudentdetail(user);
session.setAttribute("passs", obj.getPassword());
%>
<div id="to">
<div id="top">
<div ><img src="1.jpg" alt="img" style="border-top-left-radius:6px;">
<div id="topdropdown" class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=session.getAttribute("name").toString() %> <span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="dashboard.jsp">Home</a></li>
<li><a href="studentchangepwd.jsp">Change Password</a></li>
<li><a href="studentlogin.jsp">Logout</a></li>
</ul>
</div>
</div>
</div>
<div  style="background-color: #FF0000; height:5px;"></div>
<div style="background:url('16.jpg');margin: auto;">
<p style="color:#0000CD; font-size:24px;">Change Password:</p>
<div style="padding-left:175px;">
<form action="erpstudentch" method="post">
<div id="padd" style="width:500px; height: 200px;">
<div id="padd"> 
<table  cellpadding="10px">
<tr><td><span>User name:</span></td><td>
<span><input type="text" name="username" value="<%=session.getAttribute("username") %>" disabled="disabled"  style=" background-color:#F5DEB3; width:300px; border-radius:4px; text-align: center; height:30px;"></span></td><td>
<span>Roll no:</span></td><td>
<span><input type="text" name="username" value="<%=session.getAttribute("uni_roll")%>" disabled="disabled"  style=" background-color:#F5DEB3; width:300px;border-radius:4px; text-align: center; height:30px;"></span></td></tr>
<tr><td><span>Name:</span></td>
<td><span><input type="text" name="username" value="<%=session.getAttribute("stuname")%>" disabled="disabled"  style="width:300px;border-radius:4px; text-align: center; background-color:#F5DEB3; height:30px;"></span></td><td>
<span>Branch:</span></td><td><span><input type="text" name="username" value="<%=session.getAttribute("branch")%>" disabled="disabled"  style="width:300px; background-color:#F5DEB3;border-radius:4px; text-align: center; height:30px;"></span></td></tr>
</table></div>
</div>
<div> <p style="color:#FF4500">${message21}</p>    
             <c:remove var="message21" scope="session"/></div>
<div  style="background-color: #008080; width:800px; height: 350px;">
<div style="height:38px;color:#FFFAFA; background-color:#4169E1; text-align:center; font-size:25px;"><p style="text-align: center;"> <img alt="" src="28.png">&nbsp &nbsp Change Student Password</font></div>
<div id="padd" style="padding-left:140px;"> 
<table cellpadding="10px">
<tr><td>Username:</td>
<td> <input type="text" name="user_name" value="<%=session.getAttribute("username") %>" disabled="disabled" style="width:300px; height:30px; text-align:center;" >
</td></tr>
<tr><td>Your Password:</td>
<td><input type="text"  value="<%=session.getAttribute("passs") %>" disabled="disabled"  style="width:300px; height:30px">
</td></tr><tr><td>New Password:</td>
<td><input type="text" name="re_password" value="" style="width:300px; height:30px">
</td></tr><tr><td>Confirm Password:</td>
<td><input type="text" name="confirm_password"value="" style="width:300px; height:30px">
</td></tr><tr><td><button type="submit" class="bo" name="confirm">Submit</button>
</td><td><button type="submit" class="bo" name="cansel">Cancel</button></td>
</tr>
</table></div>
</div>
<div id="padd"></div>
</form>
</div>
</div>
</div>
</body>
</html>