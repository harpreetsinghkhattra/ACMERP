<%@page import="acm_add.acmoperation"%>
<%@page import="acm_add.noticeinfobean"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.DataInput"%>
<%@page import="javax.mail.internet.ContentType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Notice Upload</title>
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
<div style="background:url('16.jpg'); border-bottom-right-radius:6px; border-bottom-left-radius:6px;height:600px;" > 
<div>
<p style="color:#0000FF; font-size:24px">Upload The Notice:</p>
</div>
<div id="pad">
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
<p style="color:#FF4500"><font size="6px">${message7}</font></p>    
             <c:remove var="message7" scope="session"/><br><br>
<form action="erpchup" method="post" enctype="multipart/form-data" > 
<table id="erp">
<tr ><th>Heading:</th>
<th>Choose The File:</th>
</tr><tr ><td>
<input type="text" name="heading" >
</td>
<td><input class="bo" type="file" name= "chooser_notice" accept=" application/pdf"  > 
</td></tr>
</table>
<div style="padding-top: 60px;"> 
<button type="submit" name="btn_heading" class="bo" >Upload Notice</button></div>
</form>
</div>
</div>
</div>
</body>
</html>









