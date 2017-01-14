package acm_servletch;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import acm_add.acmoperation;
import acm_add.erpconnection;
import acm_add.noticeinfobean;
import acm_add.studentinfobean;

/**
 * Servlet implementation class erpchuploadnotic
 */
@WebServlet("/erpchup")
@MultipartConfig(maxFileSize = 16177215) 
public class erpchuploadnotic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String heading=request.getParameter("heading");
		String btn_heading=request.getParameter("btn_heading");
		//String btn_notice=request.getParameter("chooser_notice");
		String result="";
		InputStream inputstream=null;
		HttpSession session=request.getSession();
		
		noticeinfobean obj=new noticeinfobean();
		
		LocalDate date=LocalDate.now();
		String date1=String.valueOf(date);
		LocalTime time=LocalTime.now();
		String time1=String.valueOf(time);
		Part filepart=request.getPart("chooser_notice"); 


		if(btn_heading!=null)
		{
			if(heading.equalsIgnoreCase(""))
			{
				session.setAttribute("message7", "The file heading is empty"); 
				response.sendRedirect("chnoticeupload.jsp"); 
			}
			else if(filepart.equals(""))
			{
				session.setAttribute("message7", "The file chooser is empty"); 
				response.sendRedirect("chnoticeupload.jsp"); 
			}
		
			else
			{
		if(filepart!=null)
		{
			//System.out.println(filepart.getName());
			//System.out.println(filepart.getSize());
			
			//System.out.println(filepart.getContentType());
			inputstream =filepart.getInputStream();
			//System.out.print("the input stream  value is="+inputstream); 
		
		}
		result=acmoperation.uploadnoticeeee(inputstream,heading,date1,time1);		//System.out.println("the heading of notice is="+heading);
		if(result.equals("added"))
{
	session.setAttribute("message7", ""); 
	response.sendRedirect("chnoticeupload.jsp"); 
}
else
{
	session.setAttribute("message7", "either duplicate of heading value use another or file should be less than 16177215 byte"); 
	response.sendRedirect("chnoticeupload.jsp"); 
}
		//obj.setHeading(heading); 
		//result=acmoperation.noticeupdate(inputstream,heading);
    	
		} 	
		}
			}
}
