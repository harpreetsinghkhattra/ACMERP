<%@page import="acm_add.acmoperation"%>
<%@page import="acm_add.studentinfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stuedit</title>
<meta charset="utf-8">
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
#topp
{
display: inline;
}
#topdropdown
{
float:right;padding-top: 20px; 
}
#round
{
border-radius:2px;
}
#pad
{
padding-top:15px;
}
#padd
{
padding-top:25px;
}
#lin
{
background-color: #FF0000; height:5px;
}
.bo
{
cursor:pointer;border-radius:4px;margin:5px; border:none;width:200px;height:30px;background-color: #87CEEB;color:#FFFFFF;text-align: center;padding:5px;
}
</style>
</head>
<body>
<%
String user_name=request.getParameter("user_name");
String name=request.getParameter("name");
String uni_rollno=request.getParameter("university_rollno");
String branch=request.getParameter("branch");
String address=request.getParameter("address");
String gender=request.getParameter("gender");
String user=null;

studentinfobean obj=new studentinfobean();
acmoperation obj1=new acmoperation();
%>
<%
user_name=session.getAttribute("username").toString();
user=user_name;
obj=obj1.getstudentdetail(user);
name=obj.getStuname();
uni_rollno=obj.getUnirollno();
branch=obj.getBranch();
address=obj.getAddress();
gender=obj.getGender(); 
String update=request.getParameter("update");

%>

<div id="to">
<div id="top">
<div id="topp" ><img src="1.jpg" alt="img" style="border-top-left-radius:6px;"> 
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
<div id="lin"></div>
<div style="background:url('16.jpg');margin: auto;">
<div style="padding-top:20px"> 
<p><font size="4px" color="#0000CD"><strong>Welcome In Student Update Info:</strong></font>
</div>
<p style="color:#FF4500"><font size="6px">${message44}</font></p>    
             <c:remove var="message44" scope="session"/>
<div style="padding-left: 260px;">
<form action="erpstudente" method="post">
<br> 
<div id="round" style="width:600px; height:500px; background-color:#008080;">
<div style="height:35px;color:#FFFAFA; background-color:#4169E1; text-align:center; font-size:25px;"><p style="text-align: center;">Update Info</p></div><div id="padd"></div>
<div style="padding-left: 180px;"> 
<div id="pad">
<input type="text" name="user_name" value="<%=session.getAttribute("username").toString() %>" disabled="disabled" style="text-align:center; width:50%; height:30px;">
</div>
<div id="pad">
<input type="text" name="name" value="<%=name%>"style="text-align:center; width:50%; height:30px">
</div>
<div id="pad">
<input type="text" name="university_rollno" value="<%=uni_rollno %>" disabled="disabled" style="text-align:center; width:50%; height:30px;">
</div>
<div id="pad">
<input type="text" name="branch" value="<%=branch %>" style="text-align:center; width:50%; height:30px">
</div>
<div id="pad">
<input type="text" name="address" value="<%=address %>" style="text-align:center; width:50%; height:30px">
</div>
<div id="pad">
<input type="text" name="gender" value="<%=gender %>" style="text-align:center; width:50%; height:30px" disabled="disabled">
</div>
<div id="pad">
<input type="radio" name="sex" value="Male" style=" height: 30px">Male
<input type="radio" name="sex" value="Female" style=" height: 30px">Female
</div>
<div id="pad">
<button type="submit" name="update" class="bo">Update</button>
</div>
</div>
<div id="padd"></div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>
