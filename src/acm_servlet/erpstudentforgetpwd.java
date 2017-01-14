package acm_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acm_add.acmoperation;

/**
 * Servlet implementation class erpstudentforgetpwd
 */
@WebServlet("/erpstudentfo") 
public class erpstudentforgetpwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String email=request.getParameter("email");
	acmoperation obj=new acmoperation();
	
	String result="";
	if(email.equals(""))
	{
		request.getSession().setAttribute("message56", "enter valid email"); 
		response.sendRedirect("studentforgetpwd.jsp"); 	}
	else
	{
		String emailvalid="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]+[\\w]$";
		
		Boolean b=email.matches(emailvalid);
		if(b)
		{
			result=obj.getstudentpassword(email);
			if(!result.equalsIgnoreCase("sent"))
			{
				request.getSession().setAttribute("message56", "the email is not sent"); 
				response.sendRedirect("studentforgetpwd.jsp"); 
		}
			else
			{
				request.getSession().setAttribute("message56", ""); 
				response.sendRedirect("studentforgetpwd.jsp"); 
			}
		}
		else
		{
			request.getSession().setAttribute("message56", "enter valid email"); 
			response.sendRedirect("studentforgetpwd.jsp"); 
		}
	}
		
		
	}

}
