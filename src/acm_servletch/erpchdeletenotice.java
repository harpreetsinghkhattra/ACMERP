package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acm_add.acmoperation;

/**
 * Servlet implementation class erpchdeletenotice
 */
@WebServlet("/erpchdeletenoti")
public class erpchdeletenotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] heading=request.getParameterValues("btn_choose");
		String btn_submit=request.getParameter("btn_submit");
		
		acmoperation obj=new acmoperation();
		
		if(btn_submit!=null)
		{
			if(heading!=null)
			{
				obj.deletenotice(heading); 
				response.sendRedirect("chdeletenotice.jsp"); 	
			}
			else
			{
				response.sendRedirect("chdeletenotice.jsp"); 	
			}
		}
	}

}
