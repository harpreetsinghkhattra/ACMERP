package acm_servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.EditorKit;

import org.omg.CORBA.Request;

import acm_add.acmoperation;
import acm_add.studentinfobean;



/**
 * Servlet implementation class erpstudentprofile
 */
@WebServlet("/erpstudentprofile")
public class erpstudentprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
				String name=request.getParameter("name");
				session.setAttribute("name", name);
				
	}

}
