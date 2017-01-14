<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
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

<div style="padding-left:300px;">

<div style="padding-top:30px;">
<table>
<tr><td>
User name:</td><td>
<input type="text" value="<%=session.getAttribute("chuser_name") %>" id="user" disabled="disabled" style="width:200px;text-align:center;background-color:#E6E6FA"></td><td>
Roll no:</td><td>
<input type="text" value="<%=session.getAttribute("uni_rollno")%>" id="uni" disabled="disabled" style="width:200px; text-align:center;background-color: #E6E6FA"></td></tr><tr><td>
Name:</td><td>
<input type="text" value="<%=session.getAttribute("chname")%>" id="name" disabled="disabled" style="width:200px; text-align:center;background-color: #E6E6FA"></td><td>
Branch:</td><td>
<input type="text" value="<%=session.getAttribute("batch")%>" id="branch" disabled="disabled" style="width:200px;text-align:center; background-color: #E6E6FA"></td></tr>
</table>
</div>
<p style="color:#FF4500"><font size="6px">${message5}</font></p>    
             <c:remove var="message5" scope="session"/>
<div style="background-color:#F5F5F5; width: 550px; height:300px">
<div style="height:38px;color:#FFFAFA; background-color:#191970; text-align:center; font-size:25px;"><p style="text-align: center;"> <img alt="" src="28.png">&nbsp &nbsp Change Password</font></div>
<form action="Changechpassw" method="post">
<table>
<tr>
<td>Username :</td><td>
<input type="text" name="user_name" value="<%=session.getAttribute("chuser_name") %>" disabled="disabled" style="width:300px; height:30px; text-align:center;" >
</td></tr><tr><td>New Password :</td><td>
<input type="text" name="re_password" value="" style="width:300px; height:30px">
</td></tr><tr><td>Confirm Password :</td><td>
<input type="text" name="confirm_password"value="" style="width:300px; height:30px">
</td></tr><tr><td>
<button type="submit" class="bo" name="confirm">Confirm</button>
</td><td>&nbsp &nbsp<button type="submit" class="bo" name="cansel">cancel</button>
</td></tr>
</table>
<p>${messag3}</p>    
             <c:remove var="messag3" scope="session"/>
             <p style="color:#FF4500">${message1}</p>    
             <c:remove var="message1" scope="session"/>
             <p style="color:#FF4500">${message2}</p>    
             <c:remove var="message2" scope="session"/>
</form>
</div>
</div>
</div>
</div>
</body>
</html>