<%@page import="acm_add.studentinfobean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="acm_add.attendencestuinfo"%>
<%@page import="java.util.List"%>
<%@page import="acm_add.acmoperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Date wise</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">

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
cursor:pointer;border-radius:4px;margin:5px; border:none;width:100px;height:30px;background-color: #87CEEB;color:#FFFFFF;text-align: center;padding:5px;
}
#erp
{
font-family: "Trebuchet MS", Arial, Helvatica, Sans-sarif;
width: 75%;
border-collapse: collapse;
}
#erp td, #erp th
{
font-size: 1em;
border: 1px solid ;
padding: 3px 5px 2px 7px;
}
#erp th
{
font-size: 1em;
text-align: center;
padding-top: 5px;
padding-bottom: 4px;
background-color: #A9A9A9;
color:#800000;
}
#erp tr.e td
{
color:#800000;
background-color:#D3D3D3;
}
</style>
<script type="text/javascript" language="javascript">
 $(function()
  {
  $("#datepicker").datepicker(
  {
 
  dateFormat:"yy-mm-dd",
  maxDate:+0 
  });
  });
 $(function()
		  {
		  $("#datepicke").datepicker(
		  {
		 
		  dateFormat:"yy-mm-dd",
		  maxDate:+0 
		  });
		  });
 </script>
</head>
<body>

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
<form role="form" action="" method="post">
<div style="text-align:left;color:#00008B;font-size:24px; position:absolute; left:140px;">
<p>Date Wise Attendance:</p>
</div>
<div style="padding-left: 280px;padding-top: 100px;"> 
<table>
<tr><td>
User name:</td><td>
<input type="text" value="<%=session.getAttribute("username") %>" id="user" disabled="disabled" style="width:200px;text-align:center; background-color:#E6E6FA"></td><td>
Roll no:</td><td>
<input type="text" value="<%=session.getAttribute("uni_roll")%>" id="uni" disabled="disabled" style="width:200px; text-align:center;background-color: #E6E6FA"></td></tr><tr><td>
Name:</td><td>
<input type="text" value="<%=session.getAttribute("stuname")%>" id="name" disabled="disabled" style="width:200px; text-align:center;background-color: #E6E6FA"></td><td>
Branch:</td><td>
<input type="text" value="<%=session.getAttribute("branch")%>" id="branch" disabled="disabled" style="width:200px;text-align:center; background-color: #E6E6FA"></td></tr>
</table>
<br><br>
<table>
<tbody>
<tr valign="middle"><td><strong>Choose The Date (YYYY/MM/DD):</strong></td><td>
<input type="text" id="datepicker" name="intial" ></td><td>To</td><td><input type="text" id="datepicke" name="final" ></td>
<td><button type="submit" name="btn_go" class="bo">Go</button></td>
</tr>
</tbody>
</table>
<%
//List lt=null;
//lt=new ArrayList<>();
//String col_naaame=null;
//lt=acmoperation.studentattendncevieww(request.getParameter("intial"), request.getParameter("final"),col_naaame); 
//System.out.print("lt of studentdateset list"+lt.size()); 

%>
<%
String btn_date=request.getParameter("btn_go");
List<studentinfobean> lttt=null;

acmoperation obj=new acmoperation();
lttt=new ArrayList<>();

lttt=obj.studentattendncevieww(request.getParameter("intial"), request.getParameter("final"),session.getAttribute("username").toString(),lttt);
	//response.sendRedirect("studentdatesetwise.jsp"); 
	 System.out.println("the value of kkkkkk is"+lttt.size());    

%>
<div id="pad">
<table id="erp"> 
<tr class="e">
<th>Roll no:</th>
<th>Attendance:</th>
<th>Date:</th>
</tr>
<%
System.out.println("the value of kkkkkk is"+lttt.size());    
for(int i=0;i<lttt.size();i++)
{
  System.out.println("the value of kkkkkk is"+((studentinfobean)lttt.get(i)).getAttendance());    
%>
<tr class="e">
<td>
<%=session.getAttribute("uni_roll")%></td>
<td>
<%=((studentinfobean)lttt.get(i)).getAttendance()%>
</td> 
<td>
<%=((studentinfobean)lttt.get(i)).getDate() %>
</td>
</tr>
<%
}

%>
</table>
</div>
</div>
<div id="padd"></div>
</form>
</div>
</div>
</body>
</html>
