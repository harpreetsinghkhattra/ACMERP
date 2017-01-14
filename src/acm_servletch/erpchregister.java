package acm_servletch;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import acm_add.acmoperation;
import acm_add.attendencestuinfo;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpchregister
 */
@WebServlet("/erpchregisterr")
public class erpchregister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_name=request.getParameter("user_name");
		String password=request.getParameter("password");
		String confirm_password=request.getParameter("confirm_password");
		String name=request.getParameter("name");
		String uni_rollno=request.getParameter("university_rollno");
		String branch=request.getParameter("branch");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String register=request.getParameter("register");
		String check=request.getParameter("attendence");
		String btn_male=request.getParameter("sex");
		String btn_registerattendent=request.getParameter("register_attendent");
		String cancel=request.getParameter("cancel");
		String chuser=null;
		String stuuser=null;
		
		String result=""; 
		HttpSession session=request.getSession();
		session.setAttribute("attendence_column", user_name);  
		 
		acmoperation obj=new acmoperation();
		studentinfobean obj1=new studentinfobean();
		attendencestuinfo obj2=new attendencestuinfo();
		
		if(btn_registerattendent!=null)
		{
			if(user_name.equals(""))
			{
				session.setAttribute("message35", "enter the username"); 
				response.sendRedirect("chregister.jsp"); 
			}
			else if (password.equals(""))
			{
				session.setAttribute("message35", "enter the password"); 
				response.sendRedirect("chregister.jsp"); 			}
			else if(name.equals(""))
			{
				session.setAttribute("message35", "enter the student full name"); 
				response.sendRedirect("chregister.jsp"); 			}
			else if(branch.equals(""))
			{
				session.setAttribute("message35", "enter the branch name"); 
				response.sendRedirect("chregister.jsp"); 			}
			
			else if(address.equals(""))
			{
				session.setAttribute("message35", "enter the address of student"); 
				response.sendRedirect("chregister.jsp"); 			}

			else if(email.equals(""))
			{
				session.setAttribute("message35", "enter the valid email address"); 
				response.sendRedirect("chregister.jsp"); 			}
			
			else
			{
				obj1.setUsername(user_name); 
				//if(validations.compare(password, confirm_password)) 
				//{
				obj1.setPassword(password); 
				//}
				
				obj1.setStuname(name); 
				obj1.setBranch(branch); 
				if(btn_male.equalsIgnoreCase("Male")) 
				{
					gender="Male";
				}
				else 
				{
					gender="Female";
				}
				obj1.setGender(gender); 
				obj1.setUnirollno(uni_rollno);
				obj1.setAddress(address); 
				
				
					obj1.setEmail(email); 
					result=obj.addnewchstudent(obj1);
					if(result.equalsIgnoreCase("added"))
					{
						session.setAttribute("message35", ""); 
						response.sendRedirect("chregister.jsp"); 
					}
					else
					{
						session.setAttribute("message35", "registeration not done"); 
						response.sendRedirect("chregister.jsp"); 					}
			}
		}
		else if(cancel!=null)
		{
			response.sendRedirect("chdashboard.jsp");
		}
		

	}

}
