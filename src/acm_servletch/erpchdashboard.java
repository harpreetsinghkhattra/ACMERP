package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acm_add.acmoperation;
import acm_add.chairmaninfobean;

/**
 * Servlet implementation class erpchdashboard
 */
@WebServlet("/erpchdashb")
public class erpchdashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public erpchdashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String profile=request.getParameter("btn_profile");
		String mark_attendence=request.getParameter("btn_markattendence");
		String register_project=request.getParameter("btn_Registerproject");
		String btn_update=request.getParameter("brn_notice");
		String result="";
		
	   chairmaninfobean obj=new chairmaninfobean();
	   acmoperation obj1=new acmoperation();
	   
	   if(mark_attendence!=null)
	   {
		   result=obj1.checkattendance();
		   if(result.equalsIgnoreCase("send"))
		   {
		   response.sendRedirect("chstudentattendanceagain.jsp"); 
		   }
		   else
		   {
			   response.sendRedirect("stuattendencemark.jsp");  
		   }
	   }
	   else if(btn_update!=null)
	   {
		   response.sendRedirect("chnoticeupload.jsp"); 
	   }
	   else if(profile!=null)
	   {
		   response.sendRedirect("chprofile.jsp");  
	   }
	   else if(register_project!=null)
	   {
		   response.sendRedirect("chregisterproject.jsp"); 
	   }
	}

}
