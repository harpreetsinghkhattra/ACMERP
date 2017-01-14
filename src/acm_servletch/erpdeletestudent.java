package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;

/**
 * Servlet implementation class erpdeletestudent
 */
@WebServlet("/erpdeletestuden")
public class erpdeletestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] btn_chech=request.getParameterValues("btn_stuc");
		String btn_delete=request.getParameter("btn_delete");
		HttpSession session=request.getSession();
		
		acmoperation obj=new acmoperation();
		if(btn_delete!=null)
		{
			if(btn_chech!=null)
			{
				obj.deltestudent(btn_chech); 
				obj.deltestudenttwo(btn_chech); 
				obj.deltestudentone(btn_chech); 
				session.setAttribute("message31", ""); 
				response.sendRedirect("chdeletestudent.jsp"); 
			}
			else 
			{
			session.setAttribute("message31", "the no. of checkboxes selected zero"); 
			response.sendRedirect("chdeletestudent.jsp"); 
			}
		}
	}

}
