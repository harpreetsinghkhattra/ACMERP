<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register student</title>
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
cursor:pointer;border-radius:4px;margin:5px; border:none;width:150px;height:30px;background-color: #00008B;color:#FFFFFF;text-align: center;padding:5px;
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
<li><a href="chregister.jsp">CH Register</a></li>
<li><a href="changepasswordch.jsp">Change Password</a></li>
<li><a href="chlogin.jsp">Logout</a></li>
</ul>
</div>
</div> 
</div>
<div style="background-color: #FF0000;height:5px;"></div>
<div style="background:url('16.jpg')" > 
<div style="padding-top:2px;">
<p style="color:#0000FF; font-size:24px">Registeration Of Student:</p>
</div>
<div style="padding-left: 220px;">
<p style="color:#FF4500"><font size="6px">${message30}</font></p>    
             <c:remove var="message30" scope="session"/>
<form action="erpchregisters" method="post" >
<div style="background-color:#F5F5F5; width: 600px; height:600px">
<div style="background-color:#00008B; width: 600px; height:45px"><img src="29.png" alt="welcome"></div>
			
<table cellspacing="20px"> 
<tr><td>Username:</td><td>
<input type="text" name="user_name"></td></tr>
<tr><td>Password:</td><td>
<input type="password" name="password" ></td></tr>
<tr><td>Confirm Password:</td><td>
<input type="password" name="confirm_password" disabled="disabled"></td></tr>
<tr><td>Full Name:</td><td>
<input type="text" name="name"></td></tr>
<tr><td>University Rollno:</td><td>
<input type="text" name="university_rollno"></td></tr>
<tr><td>Branch:</td><td>
<input type="text" name="branch" ></td></tr>
<tr><td>Gender:</td><td>
<input type="text" name="gender" disabled="disabled"> </td><td><input type="radio" name="sex" value="Male" >Male</td><td>
<input type="radio" name="sex" value="Female" >Female</td> </tr>
<tr><td>Address:</td><td>
<input type="text" name="address"></td></tr>
<tr><td>Email:</td><td>
<input type="text" name="email" title="Sample@gmail.com" placeholder="sample@gmail.com"></td></tr> 
<tr><td>Attendence:</td><td>
<input type="checkbox" name='draw[]' id="onclick" onClick="CheckIfChecked()">Is this student attendent</td><td> 
<div id="t" style="display:none;"><button type="submit" name="register_attendent" class="bo">Register</button></div></td></tr>
<tr><td>
<button type="submit" name="cancel" class="bo" >cancel</button></td>
</tr>
</table>
</div>
</form>
</div>
</div>
</div>
</body>
</html>