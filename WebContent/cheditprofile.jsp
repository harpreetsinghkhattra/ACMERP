<%@page import="acm_add.acmoperation"%>
<%@page import="acm_add.chairmaninfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body
{
background-color:#20B2AA;margin: 0px;
}

#to
{
width:990px;margin: auto;
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
float: right;padding-top:15px;
}
.bo
{
cursor:pointer;border-radius:4px;margin:5px; border:none;width:300px;height:30px;background-color: #00008B;color:#FFFFFF;text-align: center;padding:5px;
}
</style>
</head>
<body>
<%
String username=request.getParameter("user_name");
String name=request.getParameter("name");
String uni_rollno=request.getParameter("uni_rollno");
String branch=request.getParameter("branch");
String gender=request.getParameter("gender");
String address=request.getParameter("address");

chairmaninfobean obj=new chairmaninfobean();

%>
<%
username=session.getAttribute("chuser_name").toString();
obj=acmoperation.getchetail(username);
name=obj.getChairmanname();
uni_rollno=obj.getUniversity_rollno();
branch=obj.getBranch();
gender=obj.getGender();
address=obj.getAddress();

%>
<div id="to">
<div id="top">
<div id="topp" ><a href="chdashboard.jsp"><img src="1.jpg" alt="img" style="border-top-left-radius:6px;"></a>
<div id="topdropdown" class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=session.getAttribute("chname")%> <span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="chdashboard.jsp">Home</a></li>
<li><a href="changepasswordch.jsp">Change Password</a></li>
<li><a href="chlogin.jsp">Logout</a></li>
</ul>
</div>
</div> 
</div>
<div style="background-color: #FF0000;height:5px;"></div>
<div style="background:url('16.jpg')" > 
<div style="padding-top:2px;">
<p style="color:#0000FF; font-size:24px">Update The Chairman Info:</p>
</div>
<div style="padding-left:275px">
<p style="color:#FF4500"><font size="6px">${message4}</font></p>    
             <c:remove var="message4" scope="session"/><br><br>
<form action="erpcheditpr" method="post">
<div>
<table cellpadding="10px"> 
<tr><td>Username :</td><td>
<input type="text" name="user_name" value="<%=username %>"  disabled="disabled"  style="text-align: center; width:210px; height:30px;">
</td></tr><tr><td>Name :</td><td><input type="text" name="name" value="<%=name %>"  style="text-align: center; width:210px; height:30px;">
</td></tr><tr><td>Roll no :</td><td><input type="text" name="uni_rollno" value="<%=uni_rollno %>" disabled="disabled"   style="text-align: center; width:210px; height:30px;">
</td></tr><tr><td>Branch :</td><td><input type="text" name="branch" value="<%=branch %>"   style="text-align: center; width:210px; height:30px;">
</td></tr><tr><td>Gender :</td><td><input type="text" name="gender" value="<%=gender %>" disabled="disabled" style="text-align: center; width:210px; height:30px;">
</td><tr><td><input type="radio" name="sex" value="Male">Male
</td><td><input type="radio" name="sex" value="Female">Female
</td></tr><tr><td>Address :</td><td><input type="text" name="address" value="<%=address %>"  style="text-align: center; width:210px; height:30px;"  >
</td></tr>
</table>
<div style="padding-top:2px;"><button type="submit" name="btn_update" class="bo">Update</button></div>
</div>
</form>
</div>
</div>
</div>
</body>
</html>