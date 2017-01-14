<%@page import="com.mysql.jdbc.Constants"%>
<%@page import="acm_add.erpconnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="acm_add.noticeinfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Notice</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style type="text/css">
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
Connection conn=null;
    	PreparedStatement pt=null;
    	String heading=null;
    	String result=null;
    	ResultSet rs=null;
        List<noticeinfobean> ls=null;
    	
    	noticeinfobean obj=null;
    	
    	try {
    		ls=new ArrayList<>();
			conn=erpconnection.conect();
			pt=conn.prepareStatement("select * from noticeupdate");
			//obj.setHeading(heading); 
			rs=pt.executeQuery(); 
			while(rs.next())
			{
				obj=new noticeinfobean();
				obj.setHeading(rs.getString("heading"));
				ls.add(obj); 
			}
			System.out.println("the lis is"+ls.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in getnotice"+e);
		}
    	finally {
			try {
				 conn.close();
				 pt.close();
				 rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
    %>
    <%
//List elist=(ArrayList)session.getAttribute("lslist");
    
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
<%
noticeinfobean obj1=new noticeinfobean();
%>
<div style="background:url('16.jpg');margin: auto;">
<div id="padd">
<p style="color:#0000CD;font-size:24px;">View Notice:</p></div>
<div style="padding-left: 200px;">
<form action="erpstudentvi" method="post">
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
<div style="padding-left: 30px;" id="padd">
<table id="erp">
<tr ><th>Heading</th><th>Notice</th></tr>
<%
//Object object[][]=new Object[ls.size()][2];
for(int i=0; i<ls.size(); i++) 
{ 
	System.out.println("the lis is"+ls.get(i));

	//obj=(noticeinfobean)ls.get(i);
//object[i][0]=obj.getHeading();
//object[i][1]=obj.getHeading();
%>
<tr class="e" ><td><input type="checkbox" value="<%=((noticeinfobean)ls.get(i)).getHeading() %>" name="heading" ></td><td> <%=((noticeinfobean)ls.get(i)).getHeading() %></td></tr>
<% } %>
</table>
</div>
<div style="padding-left: 200px;" id="padd">
<button type="submit" name="btn_name" class="bo">Go</button> 
</div>
</form>
</div>
<div style="padding-top:280px;">
</div>
</div>
</div>
</body>
</html>