package acm_servletch;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ParseConversionEvent;

import acm_add.acmoperation;
import acm_add.chairmaninfobean;
import acm_add.projectinfo;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpchregisterproject
 */
@WebServlet("/erpchregiste")
public class erpchregisterproject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String username=request.getParameter("username");
	String username1=request.getParameter("username1");
	String username2=request.getParameter("username2");
	String username3=request.getParameter("username3");
	String pojectname=request.getParameter("projectname"); 
	String description=request.getParameter("description"); 
	String btn_submit=request.getParameter("btn_submit"); 
	String finaldate=request.getParameter("finaldate");
	LocalDate date=LocalDate.now();
	String result=null;
	HttpSession session=request.getSession();
	
	projectinfo obj1=new projectinfo();
	acmoperation obj=new acmoperation(); 
	chairmaninfobean obj2=new chairmaninfobean();
	
	
	if(btn_submit!=null)
	{
		if(pojectname.equalsIgnoreCase(""))
		{
			session.setAttribute("message6", "The project name is empty"); 
			response.sendRedirect("chregisterproject.jsp"); 

		}
		else if(finaldate.equalsIgnoreCase(""))
		{
			session.setAttribute("message6", "The Dead line of project(in Date) is empty"); 
			response.sendRedirect("chregisterproject.jsp"); 
		}
		else if(description.equalsIgnoreCase(""))
		{
			session.setAttribute("message6", "The Description is empty"); 
			response.sendRedirect("chregisterproject.jsp"); 
		}
		else
			{
			obj1.setUsername(username); 
			
	obj1.setUsername1(username1); 
	obj1.setUsername2(username2); 
	obj1.setUsername3(username3); 
	obj1.setDescription(description);
	obj1.setFinaldate(Date.valueOf(finaldate));
	obj1.setProjectname(pojectname); 
	
	result=obj.studentprojectregister(obj1);
	if(result.equals("added"))
	{
	session.setAttribute("message6", "");
	response.sendRedirect("chregisterproject.jsp"); 
	//System.out.println("the operation is done"); 
	}
	else
	{
		session.setAttribute("msessage6", "The project is not saved");
		response.sendRedirect("chregisterproject.jsp");
	}
	}
	}
	}

}
