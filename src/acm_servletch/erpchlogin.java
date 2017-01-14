package acm_servletch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.chairmaninfobean;
import acm_add.erpconnection;
import acm_add.projectinfo;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpchlogin
 */
@WebServlet("/erpchlog")
public class erpchlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("chuser_name");
		String password=request.getParameter("password"); 
		String submit=request.getParameter("submit"); 
		String chname=null;
		String rollno=null;
		String sturollno=null;
		String result="";
		Date finaldate=null;
		LocalDate date=LocalDate.now(); 
		List<projectinfo> lt= null;
		HttpSession session=request.getSession();
		
		acmoperation obj=new acmoperation();
		chairmaninfobean obj1=new chairmaninfobean();
		studentinfobean obj2=new studentinfobean();
		//projectinfo obj3=new projectinfo();
		
		obj1=obj.getchetail(user_name);
				
		result=obj.chlogin(user_name, password);
		
		

       obj.studentproject();
		
		
		projectinfo  obj3=null;
		Connection con=null;
    	ResultSet rss=null;
    	PreparedStatement ptt=null;
    	String chuser=null;
    	//String result="";
    	    	
    	try {
    		
    		lt=new ArrayList<>();
    		con=erpconnection.conect();
    		
    		ptt=con.prepareStatement("select * from studentproject");
    		rss=ptt.executeQuery();
    		while(rss.next())
    		{
    			obj3=new projectinfo();
				
    			obj3.setFinaldate(Date.valueOf(rss.getString("date"))); 
    			obj3.setProjectname(rss.getString("project_name"));
    			obj3.setInitialdate(rss.getDate("initial_date"));
    			lt.add(obj3);
    			System.out.println("the date is under"+lt.size());
    		}
    		
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in ="+e.getMessage());  
    	}
    	finally {
    		try {
    			con.close();
    			rss.close();
    			ptt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
		
		
		
		
		
		
		
		
		
		session.setAttribute("chuser_name", user_name); 
		session.setAttribute("chname", obj1.getChairmanname());
		session.setAttribute("uni_rollno", obj1.getUniversity_rollno()); 
		session.setAttribute("batch", obj1.getBranch()); 
				
		if(submit!=null)
		{
			if(result.equalsIgnoreCase("ok"))
			{

	        	request.getSession().setAttribute("message55", ""); 
	        	response.sendRedirect("chdashboard.jsp"); 			
			}
		else
		{
String message="either username and password is incorrect";
        	
        	request.getSession().setAttribute("message55", message); 
        	response.sendRedirect("chlogin.jsp"); 
        	}
			for(int i=0;i<lt.size();i++)
			{
			if(((projectinfo)lt.get(i)).getFinaldate().equals(((projectinfo)lt.get(i)).getInitialdate()))       
	  		{
				obj3.setUsername(session.getAttribute("chuser_name").toString());
				System.out.println("the name of project is"+((projectinfo)lt.get(i)).getProjectname());
				obj3.setProjectname(((projectinfo)lt.get(i)).getProjectname());
				obj.informtochproject(obj3);
				System.out.println("either  incorrect"+((projectinfo)lt.get(i)).getFinaldate()); 
			
	  		}
					 
			}		
		
		}
	}

}
