<%@page import="acm_add.attendencestuinfo"%>
<%@page import="acm_add.erpconnection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="acm_add.studentinfobean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script type="text/javascript" language="javascript">
 $(function()
  {
  $("#datepicker").datepicker(
  {
 
  dateFormat:"yy-mm-dd",
  minDate:-0
  });
  });
 </script>
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
padding-left:225px;
padding-top:10px;
}
</style> 
</head>
<body>
<script type="text/javascript">
function checkALL(){
    var chk_arr =  document.getElementsByName("draw[]");        
    for(k=0;k< chk_arr.length;k++)
    {
        chk_arr[k].checked = true;
    } 
CheckIfChecked();
}

function unCheckALL(){
    var chk_arr =  document.getElementsByName("draw[]");             
    for(k=0;k< chk_arr.length;k++)
    {
        chk_arr[k].checked = false;
    } 
    CheckIfChecked();
}

function checkAny(){
    var chk_arr =  document.getElementsByName("draw[]");             
    for(k=0;k< chk_arr.length;k++)
    {
        if(chk_arr[k].checked==true){
        return true;
        }
    } 
    return false;
}

function isCheckAll(){
    var chk_arr =  document.getElementsByName("draw[]");             
    for(k=0;k< chk_arr.length;k++)
    {
        if(chk_arr[k].checked==false){
        return false;
        }
    } 
    return true;
}

function showFirstButton(){
    document.getElementById('t').style.display = "block"; 
}
function hideFirstButton(){
    document.getElementById('t').style.display = "none"; 
}


function CheckIfChecked(){
checkAny() ? showFirstButton():hideFirstButton();
isCheckAll() ? showFirstButton():hideFirstButton();
}
</script>
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
<div style="background:url('16.jpg'); border-bottom-right-radius:6px; border-bottom-left-radius:6px;" > 
<div>
<p style="color:#0000FF; font-size:24px;">Register Project:</p>
</div>
<form role="form" action="" method="post">

<div id="pad">
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
</form>
<%
Connection conn=null;
ResultSet rs=null;
PreparedStatement pt=null;
String chuser=null;
//String result="";
List<studentinfobean> lt=null;
    	
try {
	
	lt=new ArrayList<>();
	conn=erpconnection.conect();
	pt=conn.prepareStatement("select * from studentattendencecolinfo");
	rs=pt.executeQuery();
	while(rs.next())
	{
		studentinfobean obj=new studentinfobean();
		obj.setUnirollno(rs.getString("stucolumn_name"));  
		obj.setUsername(rs.getString("user_name")); 
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
<input type="checkbox" name='draw[]' id="onclick" onClick="CheckIfChecked()">show the list of username  
<div id="t" style="display:none;">
<%
for(int i=0;i<lt.size();i++)
{
	
%>
<input type="text" disabled="disabled"  style="width:200px; height:30px; text-align: center;" value="<%=((studentinfobean)lt.get(i)).getUsername() %>"> <br>

<%
}
%>
</div>
<div id="pad">
<p style="color:#FF4500"><font size="6px">${message6}</font></p>    
             <c:remove var="message6" scope="session"/>
<div style="background-color:#F5F5F5; width: 600px; height:440px">
<div style="background-color:#00008B; width: 600px; height:37px"><img src="31.png" alt="welcome"><p style="font-size:24px;text-align:center; color:#F5F5F5;">Project</p></div>
<div style="padding-top:30px;"></div>
<form action="erpchregiste" method="post">
<table cellspacing="5px" ><tr><td>User Name:</td><td>
<select name="username" style="text-align: center; width:200px; height:30px;" >
<%
for(int i=0;i<lt.size();i++)
{
%>
<option ><%=((studentinfobean)lt.get(i)).getUsername() %></option>
<%
}
%></select>
<select name="username1" style="text-align: center; width:200px; height:30px;" >
<%
for(int i=0;i<lt.size();i++)
{
%>
<option ><%=((studentinfobean)lt.get(i)).getUsername() %></option>
<%
}
%>></select><select name="username2" style="text-align: center; width:200px; height:30px;" >
<%
for(int i=0;i<lt.size();i++)
{
%>
<option ><%=((studentinfobean)lt.get(i)).getUsername() %></option>
<%
}
%></select><select name="username3" style="text-align: center; width:200px; height:30px;" >
<%
for(int i=0;i<lt.size();i++)
{
%>
<option ><%=((studentinfobean)lt.get(i)).getUsername() %></option>
<%
}
%>
</select>
</td></tr>
<tr><td>Description</td><td>
<textarea rows="" cols="" name="description" placeholder="description with in 1000 words store only" style="width: 200px; height:100px;"></textarea></td></tr>
<tr><td>Name Of Project:</td><td>
<input type="text" name="projectname" style="text-align: center; width:200px; height:30px;"> 
<tr><td>Dead Line Of Complition(YYYY-MM-DD)</td><td>
<input type="text" name="finaldate" id="datepicker" style="width:200px; height:30px; text-align:center; "></td></tr>
</table>
<div style="padding-left: 140px;">
<button type="submit" name="btn_submit" class="bo">Submit</button>
</div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>