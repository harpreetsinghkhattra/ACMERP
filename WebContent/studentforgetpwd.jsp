<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget Password</title>
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
#topp
{
display: inline;
}
.bo
{
cursor:pointer;border-radius:4px;margin:5px; border:none;width:200px;height:30px;background-color: #87CEEB;color:#FFFFFF;text-align: center;padding:5px;
}
</style>
</head>
<body>
<div id="to">
<div id="top">
<div ><img src="1.jpg" alt="img" style="border-top-left-radius:6px;">
</div>
</div>
<div  style="background-color: #FF0000; height:5px;"></div>
<div  style="background:url('16.jpg');margin: auto;">
<p style="color:#0000CD; font-size: 24px;"> Student Password Recovery:</p>
<div style="padding-top:150px; padding-left:360px;">
<div style="background-color: #F0FFFF;width:400px; height:400px;padding-left: 50px; padding-top: 200px;">
<p style="color:#FF4500"><font size="6px">${message56}</font></p>    
             <c:remove var="message56" scope="session"/>
<form action="erpstudentfo" method="post">
(put the email id in textfield(sample@gmail.com)) 
<input type="text" name="email" placeholder="Example@gmail.com" style="width:300px; height:30px;">
<button type="submit" name="send" class="bo">Send</button>
</form>
</div>
</div>
</div>
</div>
</body>
</html>