package acm_servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.attendencestuinfo;

/**
 * Servlet implementation class erpstudentdatesetwise
 */
@WebServlet("/erpstudentdatesetw")
public class erpstudentdatesetwise extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String intial=request.getParameter("intial");
		String finaldate=request.getParameter("final"); 
		String btn_date=request.getParameter("btn_go");
		
		HttpSession session=request.getSession();
		
        attendencestuinfo obj=new attendencestuinfo();
        acmoperation obj1=new acmoperation();
		System.out.println("the vlue is="+intial+finaldate); 
		//List<attendencestuinfo> lt=null;
		//List lt2=null;

		//lt=new ArrayList<>();
		//lt2=new ArrayList<>();
	}

}
