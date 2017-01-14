package acm_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.StyleSheet;
import javax.xml.bind.ValidationEvent;

import acm_add.acmoperation;
import acm_add.studentinfobean;
import acm_de.basemodel;
import acm_de.validations;

/**
 * Servlet implementation class erpstudentchangepwd
 */
@WebServlet("/erpstudentch")
public class erpstudentchangepwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("user_name");
		
		String password=request.getParameter("re_password");
		String confirmpass=request.getParameter("confirm_password");
		String cancel=request.getParameter("cansel");
		String confirmation=request.getParameter("confirm");
		String result=null;
		String user=null;
		HttpSession session=request.getSession();
			
		basemodel obj=new basemodel();
		
		user_name=session.getAttribute("username").toString();
		System.out.println("the username is ="+user_name); 
		System.out.println("the pass is ="+password); 

		if(confirmation!=null)
		{
			if(!validations.compare(password, confirmpass))
			{
				//System.out.println("the password is did'nt match");
				request.getSession().setAttribute("message21", "the password is not matched"); 
				response.sendRedirect("studentchangepwd.jsp"); 
			}
			else if(password.equalsIgnoreCase(""))
			{
				 request.getSession().setAttribute("message21", "the password is empty" ); 
		        	response.sendRedirect("studentchangepwd.jsp"); 
			}
			else if(confirmpass.equalsIgnoreCase(""))
			{
				 request.getSession().setAttribute("message21", "the confirm password is empty" );
				 response.sendRedirect("studentchangepwd.jsp"); 
			}
			else if(user_name!=null)
			{
				 if(password!=null)
					 {
					 obj.setpassword(user_name , password);

				//System.out.println("password is successfully changed");
					 request.getSession().setAttribute("message21", "" ); 
				response.sendRedirect("dashboard.jsp"); 
					 }
				 else
				 {
					// System.out.println("the password not change in erpchpwd");
					 request.getSession().setAttribute("message21", "the password is not changed" );
					 response.sendRedirect("studentchangepwd.jsp"); 
				 }
			}
			
		}
		else if(cancel!=null)
		{
			response.sendRedirect("dashboard.jsp"); 
		}
				 }

		}
	
	


