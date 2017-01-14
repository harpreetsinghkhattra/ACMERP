package acm_servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acm_add.erpconnection;

/**
 * Servlet implementation class erpdashboard
 */
@WebServlet("/erpdash")
public class erpdashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		erpconnection obj=new erpconnection();
		String btu_pro=request.getParameter("btu_profile");
		String btu_att=request.getParameter("btu_attendence");
		String btu_proj=request.getParameter("btu_project");
		String btu_notice=request.getParameter("btu_notice");
		
	
		
		String lbl_username=request.getParameter("user_name");
		
		
		
		
				
	if(btu_pro!=null)
	{
		
		response.sendRedirect("studentprofile.jsp");
	}
	
	else if(btu_att!=null)
	{
		response.sendRedirect("studentattendence.jsp");
	}
	else if(btu_proj!=null)
	{
		response.sendRedirect("studentproject.jsp");
	}
	else if(btu_notice!=null) 
	{
		response.sendRedirect("studentviewnotice.jsp"); 
	}
	else
	{
		System.out.println("the request of response is denied.........................");
	}
	}
	

}
