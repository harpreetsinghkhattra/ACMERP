<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chdashboard</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
#b
{
background-color: #00008B;margin:0px;

}
.button
{
border-radius:6px;
background-color: #FFA500;
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
background-color: #FFA500;
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
background-color: #FFA500;
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
}
body
{
font-family:"lato", sans-serif;
}
.sidenav
{
height: 100%;
width:0;
position:fixed;
z-index:1;
top:0;
left:0;
background-color: #000000;
overflow-x: hidden;
transition:0.5s;
padding-top: 60px;
}

.sidenav a
{
padding: 8px 8px 8px 32px;
text-decoration: none;
font-size: 25px;
color:#FFF8DC;
display: block;
transition:0.3s;
}

.sidenav a:HOVER {
	color:#DCDCDC;
}

.closebtn 
{
position: absolute;
top:0;
right:25px;
font-size: 36px;
margin-left: 50px;
}
@media screen and (max-height: 450px)
{
.sidenav{padding-top: 15px;}
.sidenav a{font-size: 18px;}
}
#top
{
width:900px;margin: auto;
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
#topn
{
padding-top: 100px;
}
#tt
{
margin-left:47.5px;
}
</style>

</head>
<body id="b">
<div id="top">
<div  style="background:url(25.jpg);height:100px;">
<div><img src="33.png" alt="ACM">
<div> 
<ul>
<li><a  href="chlogin.jsp" style="padding-left:20px;padding-right:20px;">Log Out</a><li>
<li><a  href="changepasswordch.jsp" style="padding-left:20px;padding-right:20px;">Change Password</a><li>
<li><a  href="chregisterstudent.jsp" style="padding-left:20px;padding-right:20px;">Register Student</a><li>
<li><a  href="chdashboard.jsp" style="padding-left:20px;padding-right:20px;">Home</a><li>
</ul>
</div>
</div>
</div>
<div  style="background-color:#F5F5F5;width:900px;padding-top:2px;">
<p style="text-align:left;">welcome: <%=session.getAttribute("chuser_name")%></p>
<form action="erpchdashb" method="post">
<div id="tt">
<table cellpadding="2px" >
<tr><td>	
<button type="submit" class="button" name="btn_profile" >Profile</button>
</td>
<td>
<button type="submit" class="button" name="btn_markattendence">Mark Attendance</button>
</td>
<td>
<button class="button" name="btn_Registerproject" type="submit" >Register Project</button>
</td>
</tr><tr><td rowspan="2"> 
<button class="but" name="brn_notice" type="submit">Udload Notice</button>
</td>
<td colspan="2"> 
<button class="butt" type="button"  name="btn_delete" onclick="opennav()">Delete</button>
</td>
</tr><div id="sidenavv" class="sidenav">
<a href="javascript:void(0)" class="closebtn" onclick="closenav()">x</a>
<div style="padding-top:50%;">
<a href="chdeletenotice.jsp">Delete Notice</a>
<a href="chdeletestudent.jsp">Delete Student</a>
<a href="chdeleteproject.jsp">Delete Project</a>
</div>
</div>
</table>
</div>
<script type="text/javascript">
function opennav()
{
	document.getElementById("sidenavv").style.width="250px"; 
	}
	function closenav()
	{
		document.getElementById("sidenavv").style.width="0"; 
	}
</script>
</form>
</div>
</div>
</body>
</html>