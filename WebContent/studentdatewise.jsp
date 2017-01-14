<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date Wise Attendance</title>
  <meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body> 
 
<div class="container_fluid" style="background-color:#F8F8FF;width:1250px; height: 80px">
<div class="col-sm-9"><img src="1.jpg" alt="img"></div>
<table style="width:2%">
<tbody align="right"> 
<tr><td>
<td><div class="dropdown" >
<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><%=session.getAttribute("stuname")%>&nbsp &nbsp<span class="glyphicon glyphicon-list"></span></button>
<ul class="dropdown-menu">
<li><a href="dashboard.jsp">Home</a></li>
<li><a href="studentchangepwd.jsp">Change Password</a></li>
<li><a href="studentlogin.jsp">Logout</a></li>
</ul>
</div></td>
</tr>
</tbody>
</table>
</div>
<div  class="container-fluid" style="background-color: #FF0000; height:10px;"></div>
<div class="container-fluid" style="background-image: url('16.jpg'); width:1250px;">
<br><br>

<form role="form" action="erpstudentdatewis" method="post">
<div style="text-align:left;color:#00008B;font-size:25px; position:absolute; left:140px;">
<p>Date Wise Attendance:</p>
</div><br><br><br>
<center>
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
</center>
<br><br>
<div class="row">
<div class="progress">
<div class="progress-bar progress-bar-striped active" align="center" role="progressbar" aria-valuenow="<%=session.getAttribute("sum").toString()%>" 
aria-valuemin="0" aria-valuemax="100" style="width:<%=session.getAttribute("sum").toString()%>%">
<%= session.getAttribute("sum").toString()%>%
</div>
</div>
<br><br>
</div>

<table class="table tbale-striped">
<thead>
<tr>
<th>Student Name</th>
<th>Roll No.</th>
<th>Present/Absent</th>
<th>Date(YYYY/MM/DD)</th>
</tr>
</thead>
<tbody>
<tr>
<td></td>
<td></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
<div class="form-group">
</div>

</form>
</div>
<div class="container-fluid" style="background-image: url('16.jpg'); height:200px">
<br>
</div>
</body>
</html>