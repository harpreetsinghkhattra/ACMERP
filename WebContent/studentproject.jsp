<%@page import="acm_add.acmoperation"%>
<%@page import="java.sql.Date"%>
<%@page import="acm_add.erpconnection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="acm_add.projectinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Project</title>
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
cursor:pointer;border-radius:4px;margin:5px; border:none;width:300px;height:30px;background-color: #008080;color:#FFFFFF;text-align: center;padding:5px;
}
</style>

</head>
<body>
<%
String username=request.getParameter("username");
String projectname=request.getParameter("projectname");
String description=request.getParameter("description"); 
String date=request.getParameter("date");
String btn_select=request.getParameter("btn_select"); 

acmoperation obj1=new acmoperation();
%>
<%
projectinfo obj2=new projectinfo();
if(btn_select!=null)
{
	session.setAttribute("projectname", projectname); 
	response.sendRedirect("studentviewproject.jsp");
}
%>
<%
Connection conn=null;
ResultSet rs=null;
PreparedStatement pt=null;
String chuser=null;
List<projectinfo> lt=null;
//String result="";
    	
try {
	
	lt=new ArrayList<>();
	conn=erpconnection.conect();
	pt=conn.prepareStatement("select * from studentproject");
	rs=pt.executeQuery();
	while(rs.next())
	{
		projectinfo  obj=new projectinfo();
		
		//obj.setUsername(rs.getString("user_name"));
		//obj.setUsername1(rs.getString("username1"));
		//obj.setUsername2(rs.getString("username2"));
		//obj.setUsername3(rs.getString("username3"));
		//obj.setDescription(rs.getString("description"));
		//obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
		obj.setProjectname(rs.getString("project_name"));
		lt.add(obj);
			   	
	}
	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
}
finally {
	try {
		conn.close();
		rs.close();
		pt.close();
	} catch (Exception e2) {
		// TODO: handle exception
	}
}
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
<div id="padd">
<p style="color:#0000CD;font-size: 24px;"> Student Project :</p>
</div>
<div style="padding-left:200px;">
<form action="erpprojectv" method="post">
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
<div id="padd"></div>
<div style="padding-left:180px;">
<div id="padd">
<table>
<tr><td><p >Project :</p></td><td> 
<select name="projectname" style="width:300px; text-align: center; height:30px;">
<%
for(int i=0;i<lt.size();i++)
{
%>
<option value="<%=((projectinfo)lt.get(i)).getProjectname()%>"><%=((projectinfo)lt.get(i)).getProjectname()%></option>
<%
}
%>
</select>
</td>
</tr>
</table>
</div>
</div>
<div style="padding-left:200px;">
<button type="submit" class="bo" name="btn_select">Go</button></div>
</form>
</div>
</div>
</div>
</body>
</html>

