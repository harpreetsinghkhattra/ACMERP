<%@page import="acm_add.acmoperation"%>
<%@page import="acm_add.chairmaninfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
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
#pad
{
padding-left:175px;
padding-top:10px;
}
</style> 
</head>
<body>
<div id="to">
<div id="top">
<div id="topp" ><a href="chdashboard.jsp"><img src="1.jpg" alt="img" style="border-top-left-radius:6px;"></a>
<div id="topdropdown" class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=session.getAttribute("chname")%> <span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="chdashboard.jsp">Home</a></li>
<li><a href="cheditprofile.jsp">Edit</a></li>
<li><a href="changepasswordch.jsp">Change Password</a></li>
<li><a href="chlogin.jsp">Logout</a></li>
</ul>
</div>
</div> 
</div>
<div style="background-color: #FF0000;height:5px;"></div>
<div style="background:url('16.jpg'); border-bottom-right-radius:6px; border-bottom-left-radius:6px;" > 
<div id="padd">
<p style="color:#0000FF; font-size:24px;" >View the profile:</p>


</div>
<%
String username=request.getParameter("user_name");
String password=request.getParameter("password");
String name=request.getParameter("name");
String uni_rollno=request.getParameter("uni_rollno");
String branch=request.getParameter("branch");
String gender=request.getParameter("gender");
String address=request.getParameter("address");
String email=request.getParameter("email");

chairmaninfobean obj=new chairmaninfobean();

%>
<%
username=session.getAttribute("chuser_name").toString();
obj=acmoperation.getchetail(username);
password=obj.getPassword();
name=obj.getChairmanname();
uni_rollno=obj.getUniversity_rollno();
branch=obj.getBranch();
gender=obj.getGender();
address=obj.getAddress();
email=obj.getEmail();

%>
<div style="padding-left:180px;">
<div style="background-color:#F5F5F5; width: 600px; height:500px">
<div style="background-color:#00008B; width: 600px; height:35px"><p style="font-size:24px; color:#F5F5F5; text-align:center; text-transform:capitalize;">Welcome: &nbsp &nbsp<%=session.getAttribute("chname")%></p></div>
<div style="padding-top: 70px;"></div>
<form action="erpchp" method="post">
<div id="pad">
<input type="text" name="user_name" value="<%=username %>"  disabled="disabled" style="text-align: center; width:210px; height:30px;">
</div>
<div id="pad">
<input type="text" name="name" value="<%=name %>" disabled="disabled" style="text-align: center; width:210px; height:30px;">
</div>
<div id="pad">
<input type="text" name="uni_rollno" value="<%=uni_rollno %>"  disabled="disabled" style="text-align: center; width:210px; height:30px;">
</div>
<div id="pad">
<input type="text" name="branch" value="<%=branch %>"  disabled="disabled" style="text-align: center; width:210px; height:30px;">
</div>
<div id="pad">
<input type="text" name="gender" value="<%=gender %>" disabled="disabled" style="text-align: center; width:210px; height:30px;">
</div>
<div id="pad">
<input type="text" name="address" value="<%=address %>"  disabled="disabled" style="text-align: center; width:210px; height:30px;" >
</div>
<div id="pad">
<input type="text" name="email" value="<%=email %>"  disabled="disabled" style="text-align: center; width:210px; height:30px;" >
</div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>