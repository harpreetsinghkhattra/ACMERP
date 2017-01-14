package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.chairmaninfobean;
import acm_add.studentinfobean;
import acm_de.basemodel;
import acm_de.validations;

/**
 * Servlet implementation class Changechpassword
 */
@WebServlet("/Changechpassw")
public class Changechpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("user_name");
		String password=request.getParameter("re_password");
		String confirm=request.getParameter("confirm_password");
		String btn_confirm=request.getParameter("confirm");
		String btn_cancel=request.getParameter("cansel");
		String result="";
		HttpSession session=request.getSession();
		username=session.getAttribute("chuser_name").toString();

		
chairmaninfobean obj=new chairmaninfobean();
acmoperation obj1=new acmoperation();
basemodel obj2=new basemodel();

if(password.equalsIgnoreCase("") && confirm.equalsIgnoreCase(""))
{
	request.getSession().setAttribute("message5", "The password is empty"); 
}
else if(confirm.equalsIgnoreCase(""))
{
	request.getSession().setAttribute("message5", "The confirm password is empty"); 
}

//System.out.println("the password "+username+password); 
if(btn_confirm!=null)
{   
	if(!validations.compare(password , confirm))
{
	//System.out.println("the password is not matched"); 
	request.getSession().setAttribute("message5", "The password is not matched"); 
	response.sendRedirect("changepasswordch.jsp"); 

}
	else if(password.equalsIgnoreCase("") && confirm.equalsIgnoreCase(""))
	{
		request.getSession().setAttribute("message5", "The password and confirm password is empty"); 
		response.sendRedirect("changepasswordch.jsp"); 

	}
	else if(confirm.equalsIgnoreCase(""))
	{
		request.getSession().setAttribute("message5", "The confirm password is empty"); 
		response.sendRedirect("changepasswordch.jsp"); 

	}

    else if(username!=null)
    {
if(password!=null)
{
	obj2.setchpassword(session.getAttribute("chuser_name").toString(), password);  
	//System.out.println("the password is  matched"); 
	request.getSession().setAttribute("message5", ""); 
	response.sendRedirect("changepasswordch.jsp"); 
		
	}
	else
	{
		//System.out.println("the password is not "); 
		request.getSession().setAttribute("message5", "The password is not changed"); 
		response.sendRedirect("changepasswordch.jsp"); 

	}
}
}
else if(btn_cancel!=null)
{
	response.sendRedirect("chdashboard.jsp"); 
}
	}

}
