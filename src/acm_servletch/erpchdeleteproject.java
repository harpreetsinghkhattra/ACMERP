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
 * Servlet implementation class erpchdeleteproject
 */
@WebServlet("/erpchdeleteproje")
public class erpchdeleteproject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] check=request.getParameterValues("btn_stuc");
		String btn_sub=request.getParameter("btn_sub");
		HttpSession session=request.getSession();
		
		projectinfo obj=new projectinfo();
		acmoperation obj1=new acmoperation();
		
		if(btn_sub!=null)
		{
			if(check!=null)
			{
				obj1.deleteproject(check); 
				response.sendRedirect("chdeleteproject.jsp"); 
				session.setAttribute("message29", ""); 
				}
			else 
			{
			session.setAttribute("message29", "the no. of checkboxes selected zero"); 
			response.sendRedirect("chdeleteproject.jsp"); 
			}
		}
	}

}
