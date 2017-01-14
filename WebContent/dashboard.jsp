<%@page import="acm_servlet.erpstudentlogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
 <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
body
{
position: absolute; background-color: #00008B; width:100%; height:100%;color:#000000;
}
.button
{
border-radius:6px;
background-color: #556B2F;
border: none;
color:#FFFAF0;
text-align: center;
font-size:28px;
padding: 20px;
width: 250px;
height:130px;
transition:all 0.5s;
cursor: pointer;
margin: 5px;
}

.button span
{
cursor: pointer;
display: inline-block;
position: relative;
transition:0.5s;

}

.button span:AFTER
{
content: ">>";
position: absolute;
opacity:0;
top:0;
right:-81px;
transition:0.5s;

}
.button:HOVER span
{
padding-right: 35px;
}
.button:HOVER span:AFTER
{
opacity:1;
right:0;

}



.butt
{
border-radius:6px;
background-color: #556B2F;
border: none;
color:#FFFAF0;
text-align: center;
font-size:28px;
padding: 20px;
width: 510px;
height:130px;
transition:all 0.5s;
cursor: pointer;
margin: 5px;
}

.butt span
{
cursor: pointer;
display: inline-block;
position: relative;
transition:0.5s;

}

.butt span:AFTER
{
content: ">>";
position: absolute;
opacity:0;
top:0;
right:-86px;
transition:0.5s;

}
.butt:HOVER span
{
padding-right: 35px;
}
.butt:HOVER span:AFTER
{
opacity:1;
right:0;

}





.but
{
border-radius:6px;
background-color: #556B2F;
border: none;
color:#FFFAF0;
text-align: center;
font-size:28px;
padding: 20px;
width: 250px;
height:265px;
transition:all 0.5s;
cursor: pointer;
margin: 5px;
}

.but span
{
cursor: pointer;
display: inline-block;
position: relative;
transition:0.5s;

}

.but span:AFTER
{
content: ">>";
position: absolute;
opacity:0;
top:0;
right:-84px;
transition:0.5s;

}
.but:HOVER span
{
padding-right: 35px;
}
.but:HOVER span:AFTER
{
opacity:1;
right:0;

}
li
{
float: right;
}
ul
{
list-style-type: none;
padding:0px;
margin: 0px;
overflow: hidden;
}
a:link, a:visited
{
display: block;text-align: center;font-weight:bold; color:#FFFAFA;background-color: #000000;text-decoration: none;text-transform: uppercase;padding: 4px;
}
a:hover,a:active
{
background-color:#008080;
}
</style>
</head>
<body>
<div>
<div style="background:url(25.jpg);width:790px; height:100px;margin: auto;">
<div><img src="33.png" alt="ACM">
<div> 
<ul>
<li><a  href="studentlogin.jsp" style="padding-left:20px;padding-right:20px;">Log Out</a><li>
<li><a  href="studentchangepwd.jsp" style="padding-left:20px;padding-right:20px;">Change Password</a><li>
<li><a  href="dashboard.jsp" style="padding-left:20px;padding-right:20px;">Home</a><li>
</ul>
</div>
</div>
</div>
<div  style=" background-color:#F8F8FF;width:790px; height:500px; margin:auto;">
<p style="text-align:left;">welcome :<%=session.getAttribute("username")%>	</p>
<form method="post" action="erpdash">
<div style="padding-top:80px;margin: 3px;">
<table  cellpadding="4px">
<tr><td>
<button type="submit" class="button" name="btu_profile"><span>Pofile</span></button></td>
<td>
<button type="submit" class="button" name="btu_project"><span>Project</span></button></td>
<td rowspan="2">
<button type="submit" class="but" name="btu_notice"><span>Notice</span></button></td>
</tr><tr><td colspan="2">
<button type="submit" class="butt" name="btu_attendence"><span>Attendance</span></button></td>
</tr>
</table></div>
</form>
</div>
<div>
</body>
</html>