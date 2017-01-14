<%@page import="acm_add.studentmath"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="javax.sound.midi.MetaEventListener"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="acm_add.erpconnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="acm_add.attendencestuinfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student attendance</title>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
}
#pad
{
padding-top:15px;
}
#padd
{
padding-top:25px;
}
#erpp
{
width: 75%;
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

</head>

<body>
<%
String result="";
studentmath obj1=new studentmath();

;
%>
<%
Connection conn=null;
PreparedStatement pt=null;
ResultSet rs=null;
List<attendencestuinfo> lt=null;

try
{
lt=new ArrayList<>();
conn=erpconnection.conect();
pt=conn.prepareStatement("select  "+session.getAttribute("username")+",date  from studentattendenceinfo WHERE "+session.getAttribute("username")+" IS NOT NULL AND TRIM("+session.getAttribute("username")+") <> ''");
rs=pt.executeQuery();
while(rs.next())
{
	attendencestuinfo obj=new attendencestuinfo();

	String col_name=session.getAttribute("username").toString();
	ResultSetMetaData data=rs.getMetaData();
	for(int i=1;i<=data.getColumnCount();i++)
	{
		if(data.getColumnName(i).equals(col_name)) 
		{
			
    obj.setAttendence(rs.getString(i)); 
	
		}
	}
    obj.setDate(rs.getString("date"));
    lt.add(obj);
}
}
catch(Exception e)
{
System.out.println("the exception is"+e.getMessage());
}

finally
{
	try
	{
		pt.close();
		rs.close();
		conn.close();
	}
	catch(Exception e1)
	{
		
	}
}
%>
<div id="to">
<div id="top">
<div style="display: inline;"><img src="1.jpg" alt="img" style="border-top-left-radius:6px;"> 
<div style="display: inline;" id="topdropdown" class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">harpreet singh&nbsp &nbsp<span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="dashboard.jsp">Home</a></li>
<li><a href="studentchangepwd.jsp">Change Password</a></li>
<li><a href="studentlogin.jsp">Logout</a></li>
</ul>
</div>
</div>
</div>
<div style="background-color: #FF0000; height:5px;"></div>
<div style="background:url('16.jpg');margin: auto;">
<div id="padd" style="text-align:left;color:#00008B;font-size:24px;">
<p>Student Attendance:</p> 
</div>
<div id="padd">
<div style="padding-left: 175px;">
<form action="erpstuatt" method="post">
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
</form>
<%
float sum=0;
float n=0;
float b=0;
float q=0;
String column_attendace=null;
for(int i=0;i<lt.size();i++)
{
column_attendace=((attendencestuinfo)lt.get(i)).getAttendence();
if(column_attendace.equalsIgnoreCase("P"))
{
	b++;
}
}
n=lt.size();
q=n-b;
for(int i=0;i<lt.size();i++)
{
	System.out.println("the attendence is"+((attendencestuinfo)lt.get(i)).getAttendence());
%>
<% } %>




<%

System.out.println("the column length is="+b); 
System.out.println("the list length is="+n); 

sum=b/n*100;
%>


<div style="padding-top: 100px;" id="padd">
<p style="font-size: 24px;">Percentage Of Student Attendance:</font>
<a href="studentdatesetwise.jsp" data-toggle="tooltip" data-placement="right" title="Date wise Attendance"><span class="glyphicon glyphicon-calendar"></span></a></div>
<%
session.setAttribute("sum", sum);
%>
<% 
float t=30,u=60,y=85;
float z=sum; 
if(z<=t)
{
%>
<table id="erpp">
<tr><td>
<div class="progress">
<div class="progress-bar progress-bar-danger " align="center" role="progressbar" aria-valuenow="<%=session.getAttribute("sum").toString()%>" 
aria-valuemin="0" aria-valuemax="100" style="width:<%=session.getAttribute("sum").toString()%>%">
<%= session.getAttribute("sum").toString()%>%
</div>
</div></td></tr></table>
<%
}
else if(z<=u)
{
%>
<table id="erpp">
<tr><td>
<div class="progress">
<div class="progress-bar progress-bar-warning " align="center" role="progressbar" aria-valuenow="<%=session.getAttribute("sum").toString()%>" 
aria-valuemin="0" aria-valuemax="100" style="width:<%=session.getAttribute("sum").toString()%>%">
<%= session.getAttribute("sum").toString()%>%
</div>
</div></td></tr></table>
<%
}
else if(z<=y)
{
%>
<table id="erpp">
<tr><td>
<div class="progress">
<div class="progress-bar progress-bar-success " align="center" role="progressbar" aria-valuenow="<%=session.getAttribute("sum").toString()%>" 
aria-valuemin="0" aria-valuemax="100" style="width:<%=session.getAttribute("sum").toString()%>%">
<%= session.getAttribute("sum").toString()%>%
</div>
</div></td></tr></table>
<%
}
%>



<div >
<table id="erp">
<tr> 
<th>Student name</th>
<th>Roll no</th>
<th>Present</th>
<th>Absent</th>
<th>Total</th>
</tr>

<tr class="e">
<td><%=session.getAttribute("stuname") %></td>
<td><%=session.getAttribute("uni_roll") %></td>

<td><%=b%></td>
<td><%=q %></td>
<td><%=n%></td> 
</tr>
</table>
</div>
<div style="padding-top:200px;"></div>
</div>
</div>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>

