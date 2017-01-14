package acm_servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.*; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpstudentlogin
 */
 //@WebServlet("/erpstudentlog")
public class erpstudentlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		acmoperation obj3 = new acmoperation();
		studentinfobean obj1=new studentinfobean();
		HttpSession session=request.getSession();
        String user=request.getParameter("username");
        session.setAttribute("username", user);
        
        String pwd=request.getParameter("pass");
        String result="";
        String stuname=null;
       
        obj1= obj3.getstudentdetail(user);
        	 session.setAttribute("stuname", obj1.getStuname());
        	 session.setAttribute("uni_roll", obj1.getUnirollno());
        	 session.setAttribute("branch", obj1.getBranch()); 
        	 session.setAttribute("passw", obj1.getPassword()); 
             
        result=obj3.stulogin(user, pwd);
        if(result.equalsIgnoreCase("ok"))
            {
        	String message = "";
        	request.getSession().setAttribute("message", message); 
                  response.sendRedirect("dashboard.jsp");
                  
                  
            }
        else
        {
        	String message="either username and password is incorrect";
        	
        	request.getSession().setAttribute("message", message); 
        	response.sendRedirect("studentlogin.jsp"); 
               
        }


	}

}
