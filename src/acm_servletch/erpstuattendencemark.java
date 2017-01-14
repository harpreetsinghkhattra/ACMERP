package acm_servletch;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
import acm_add.erpconnection;
import acm_add.projectinfo;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpstuattendencemark
 */
@WebServlet("/erpstuatte")
public class erpstuattendencemark extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String mark=request.getParameter("attendence");
		String btn_mark=request.getParameter("btn_attendence");
		String[] btn_stucheck=request.getParameterValues("btn_stucheck");
		String attendence_column=null;
		String chuser_name=null;
		String result="";
		HttpSession session=request.getSession();
		chuser_name=session.getAttribute("chuser_name").toString();
		//System.out.println("the erp file is chusr="+chuser_name); 
		
		acmoperation obj=new acmoperation();
		attendencestuinfo obj1=new attendencestuinfo();
		studentinfobean obj2=new studentinfobean();
		
		if(btn_mark!=null)
		{
			

			
				
				//obj.studentattendencecolin(); 
								
				//attendence_column=obj2.getUsername();
				//System.out.println("the stuusername is="+attendence_column); 
				//obj1.setAttendence(btn_stucheck);   
				obj1.setUser_name(chuser_name);                  
				obj1.setColumn_name(attendence_column); 
				
				if(btn_stucheck!=null) 
				{
					obj.buildstuattendencinin(obj1, btn_stucheck);
				result=obj.buildstuattendencin(obj1,btn_stucheck); 
				if(result.equalsIgnoreCase("added"))
				{
					String message3="";
					session.setAttribute("message3", message3);
					//System.out.println("the attendence of student is commit");
					response.sendRedirect("stuattendencemark.jsp"); 
				} 
				else
				{
					String message3="The operation is not commit";
					session.setAttribute("message3", message3);
					//System.out.println("the operation is not commit"); 
				}
				}
				else 
				{
					Connection conn=null;
			    	PreparedStatement pt=null;
			    	ResultSet rs=null;
			    	String userch=null;
			    	String userstu=null;
			    	String mark=null;
			    	//String result="";
			    	List<studentinfobean> lis=null;
			    	 List<attendencestuinfo> li=null;
			    	
			    	try
			    	{
			    		LocalDate dt=LocalDate.now();
			    		conn=erpconnection.conect();
			    	 lis=new ArrayList<>();
			    	 li=new ArrayList<>();
					 userch=chuser_name;
					 //userstu=obj.getColumn_name();
					// System.out.println("the coloumn name is="+userstu); 
					 //mark=obj.getAttendence();
					 pt=conn.prepareStatement("select * from studentattendencecolinfo ");
					 rs=pt.executeQuery();
					 while(rs.next())
					 {
					    studentinfobean stu=new studentinfobean();
					    
					    stu.setAttendence(rs.getString("Attendence"));
					    stu.setUsername(rs.getString("user_name"));
						lis.add(stu);  
					 }
					 String column_name=null;
					 for(int i=0;i<lis.size(); i++) 
					 {
						// mark=((studentinfobean)lis.get(i)).getAttendence(); 
						 column_name=((studentinfobean)lis.get(i)).getUsername();
						// System.out.println("the column is="+column_name);
							  
		     pt=conn.prepareStatement("update studentattendencecolinfo  set Attendence='A' where user_name='"+column_name+"'");    
		     int row=pt.executeUpdate();

					 }

		    }
					catch(Exception e) 
		    	{
		    		System.out.println("the error in build"+e); 
		    	}
		    	finally {
					try {
						 conn.close();
						 pt.close();
						 rs.close(); 
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			    	
				

			
					response.sendRedirect("stuattendencemark.jsp"); 
	
		}
	}
	}

}
