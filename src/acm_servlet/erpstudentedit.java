package acm_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpstudentedit
 */
@WebServlet("/erpstudente")
public class erpstudentedit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=response.getWriter();
		String user_name=request.getParameter("user_name");
		String name=request.getParameter("name");
		String branch=request.getParameter("branch");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String[] sex= request.getParameterValues("sex");
		//String gender2=request.getParameter("gender2"); 
		String update=request.getParameter("update");
		HttpSession session=request.getSession();
		user_name=session.getAttribute("username").toString();
		String uni_rollno=session.getAttribute("uni_roll").toString();
		System.out.println("the user_name is= "+user_name); 
		
		acmoperation obj=new acmoperation();
		studentinfobean obj1=new studentinfobean();
		
		if(update!=null)
		{
			if(user_name!=null)
			{
				if(name!=null)
				{
					if(sex!=null)
					{
						
						if(sex[0].equalsIgnoreCase("Male"))
				{
					gender="Male";
				}
				else 
				{
					gender="Female";
				}
					}
				obj.updatestudentdetail(user_name, uni_rollno, branch, gender, address, name) ;
				writer.println("<label>edit is successful</label>");
				session.setAttribute("message44", "");
				response.sendRedirect("studentedit.jsp"); 
				}
				}
				else
				 {
					 response.sendRedirect("studentedit.jsp"); 
				 }
			
		}
		else
		 {
			session.setAttribute("message44", "the operation is not done");
			 response.sendRedirect("cheditprofile.jsp"); 
		 }
		
	}

}
