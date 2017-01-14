<%@page import="acm_add.studentinfobean"%>
<%@page import="acm_add.acmoperation"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stuprofile</title>

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
border-radius:6px;
margin-top: 10px;
}
#pad
{
padding-top: 15px;
}
#padd
{
padding-top: 2px;
}
</style>
</head>
<body>
<%
String user_name=request.getParameter("user_name");
String uni_rollno=request.getParameter("university_rollno");
String branch=request.getParameter("branch");
String gender=request.getParameter("gender");
String address=request.getParameter("address");
String name=request.getParameter("name");
ResultSet rs=null;
studentinfobean obj1=new studentinfobean();
String user=null;

acmoperation obj=new acmoperation();%>
<%

user_name=session.getAttribute("username").toString();
user=user_name;
obj1=obj.getstudentdetail(user);
user_name=obj1.getUsername();
uni_rollno=obj1.getUnirollno();
branch=obj1.getBranch();
gender=obj1.getGender();
address=obj1.getAddress();
name=obj1.getStuname();
session.setAttribute("name",name) ;

%>
<div id="to">
<div id="top">
<div ><img src="1.jpg" alt="img" style="border-top-left-radius:6px;">
<div id="topdropdown">
<div class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=name%> <span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="dashboard.jsp">Home</a></li>
<li><a href="studentedit.jsp">Edit</a></li>
<li><a href="studentchangepwd.jsp">Change Password</a></li>
<li><a href="studentlogin.jsp">Logout</a></li>
</ul>
</div>
</div>
</div>
</div>
<div style="background-color: #FF0000;height:5px;"></div>
<div style="background:url('16.jpg');margin: auto;" >
<div>
<p style="color:#0000CD; font-size:24px;"> Student Profile:</p>  
</div>
  <div style="padding-top:30px;"></div>
<div style="padding-left:270px;">
<div id="round" style="background-color:#008080;padding-left:100px; width: 500px; height:420px">
 <form action="erpstudentprofile" method="post"> 
 <div style="padding-top:40px;"></div>
<div id="pad">
 <input type="text" name="user_name"  value="<%=user_name%>" style="width:300px; height:30px; background-color: #FAF0E6; text-align: center;" disabled="disabled" />
 </div>
 <div id="pad">
 <input type="text" name="name" value="<%=name%>" style="width:300px; height:30px; text-align: center; background-color: #FAF0E6;" disabled="disabled"/>
 </div>
 <div id="pad">
 <input type="text" name="university_rollno" value="<%=uni_rollno%>" style="width:300px; height:30px ;  background-color: #FAF0E6; text-align: center;" disabled="disabled"/>
 </div>
 <div id="pad">
 <input type="text" name="branch" value="<%=branch%>" style="width:300px; height:30px ;  background-color: #FAF0E6; text-align: center;" disabled="disabled"/>
 </div>
 <div id="pad">
 <input type="text" name="gender" value="<%=gender%>" style="width:300px; height:30px ;  background-color: #FAF0E6; text-align: center;" disabled="disabled"/>
 </div>
 <div id="pad">
 <input type="text" name="address" value="<%=address%>" style="width:300px; height:30px;  background-color: #FAF0E6; text-align: center;" disabled="disabled"/>
 </div>
 <div id="pad">
 <input type="text" name="gender" value="<%=obj1.getEmail()%>" style="width:300px; height:30px ;  background-color: #FAF0E6; text-align: center;" disabled="disabled"/>
 </div> 
 </form>
  </div>
 </div>
   <div style="padding-top:100px;"></div>
</div>
</div>
</body>
</html>