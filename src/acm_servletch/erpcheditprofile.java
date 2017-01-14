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

/**
 * Servlet implementation class erpcheditprofile
 */
@WebServlet("/erpcheditpr")
public class erpcheditprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("user_name");
		String name=request.getParameter("name");
		String uni_rollno=request.getParameter("uni_rollno");
		String branch=request.getParameter("branch");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String btn_update=request.getParameter("btn_update");
		String[] btn_male=request.getParameterValues("sex");
		String lab=request.getParameter("lab");
		String result="";
		HttpSession session=request.getSession();
		
		
		chairmaninfobean obj=new chairmaninfobean();
		
		
		if(btn_update!=null)
		{
		 if(session.getAttribute("chuser_name")!=null)
		 {
			 if(name!=null)
			 {
				 if(btn_male!=null)
				 {
			 if(btn_male[0].equalsIgnoreCase("Male"))
			 {
				 gender="Male";
			 }
			 else 
			 {
				 gender="Female";
			 }
				 }
		 acmoperation.updatchdetail(session.getAttribute("chuser_name").toString(),session.getAttribute("uni_rollno").toString(),branch,gender, name, address); 
		 String message4="";
			session.setAttribute("message4", message4);
		 response.sendRedirect("cheditprofile.jsp"); 
		lab="the word is commit";
				 
		 }
		 }
		 else
		 {
			 response.sendRedirect("cheditprofile.jsp"); 
		 }
		 }
		 
		else
		{
			String message4="The editing is not done";
			session.setAttribute("message4", message4);
			 response.sendRedirect("cheditprofile.jsp"); 

			//System.out.println("the edititing is not done");
		}
	}

}
