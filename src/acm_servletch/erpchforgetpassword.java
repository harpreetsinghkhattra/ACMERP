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
 * Servlet implementation class erpchforgetpassword
 */
@WebServlet("/erpchforgetpassw")
public class erpchforgetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String btn_send=request.getParameter("send");
		HttpSession session=request.getSession();
		String username=session.getAttribute("chuser_name").toString();
		
		acmoperation obj=new acmoperation();
		
		if(btn_send!=null)
		{
			if(email!=null)
			{
				obj.getchpassword(email);
				response.sendRedirect("forgetchpassword.jsp"); 
			}
			else
			{
				response.sendRedirect("forgetchpassword.jsp"); 
			}
		}
	}

}
