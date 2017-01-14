package acm_servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import acm_add.acmoperation;
import acm_add.erpconnection;
import acm_add.noticeinfobean;

/**
 * Servlet implementation class erpstudentviewnotice
 */
@WebServlet("/erpstudentvi")
public class erpstudentviewnotice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int buffer_size=4096;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String heading=request.getParameter("heading");
		String btn_name=request.getParameter("btn_name");
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement pt=null;
		String result="";
		String headi=null;
		
		noticeinfobean obj=new noticeinfobean();
		acmoperation obj1=new acmoperation();
		
		
		if(btn_name!=null)
		{
		if(heading!=null)
		{
			obj.setHeading(heading); 
			//obj1.getstudentnotice(obj);
			//obj1.opennotice(obj);
			try {
				conn=erpconnection.conect();
				headi=obj.getHeading();
				System.out.println("the headi"+headi); 
				pt=conn.prepareStatement("select * from noticeupdate where heading =?");
				pt.setString(1, headi);
	            rs=pt.executeQuery();
				if(rs.next())
	            {
	            	Blob blob=rs.getBlob("path");
	            	InputStream  inputstream=blob.getBinaryStream();
	            	int filelength=inputstream.available();
	            	System.out.println("fellength"+filelength);
	            	ServletContext context=getServletContext();
	            	String mimetype=context.getMimeType(obj.getHeading());
	            	if(mimetype==null)
	            	{
	            		mimetype="application/octent-stream";
	            	}
	            	response.setContentType(mimetype); 
	            	response.setContentLength(filelength); 
	            	String headerkey="content-disposition";
	            	String headervalue=String.format("attachment; filename=\"%s\"",obj.getHeading());
	            	response.setHeader(headerkey, headervalue); 
	            	OutputStream outstream=response.getOutputStream();
	            	
	            	byte[] buffer=new byte[buffer_size];
	            	int bytesread=-1;
	            	
	            	while((bytesread=inputstream.read(buffer))!=-1)
	            	{
	            		outstream.write(buffer, 0, bytesread); 
	            		inputstream.close();
	            		outstream.close();
	            	}
	            	
	            }
				else
				{
					response.getWriter().print("the file is not download"+obj.getHeading());
				}
			} catch (Exception e) {
				// TODO: handle exception
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
			
		}
		else
		{
			response.sendRedirect("studentviewnotice.jsp"); 
		}
		}
	}

}
