package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.projectinfo;

/**
 * Servlet implementation class erpprojectview
 */
@WebServlet("/erpprojectv")
public class erpprojectview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String projectname=request.getParameter("projectname");
		String description=request.getParameter("description"); 
		String date=request.getParameter("date");
		String btn_select=request.getParameter("btn_select"); 
		HttpSession session=request.getSession();
		session.setAttribute("projectname", projectname); 


		acmoperation obj1=new acmoperation();
		projectinfo obj2=new projectinfo();

		if(btn_select!=null)
		{
			response.sendRedirect("studentviewproject.jsp");
			
		}
	}

}
