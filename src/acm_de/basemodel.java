package acm_de;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import acm_add.erpconnection;
import acm_add.studentinfobean;

public class basemodel {
	public Connection getconnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/erp","root","");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the exception is occured in connection..................."+e.getMessage());
		}
		return null;

	}
	public  String updatestudentpassword(String user, String oldpass, String newpass)
	{
		String result=null;
		studentinfobean obj=new studentinfobean();
	try {
		Connection con=getconnection();
		PreparedStatement ptst=con.prepareStatement("select * from studentinfo where user_name=?");
		ptst.setString(1, user);
		ResultSet rs=ptst.executeQuery();
		while(rs.next())
		{
			String pass=rs.getString("password");
			
			if(!validations.compare(newpass, oldpass))
			{
				result="notmatch";
			}
			else
			{
			PreparedStatement pt=con.prepareStatement("update studentinfo set password=? where username=?");
			pt.setString(1, newpass);
			pt.setString(2, user);
			int i=pt.executeUpdate();
			if(i>0)
			{
				result ="update";
			}
			else
			{
				result="notupdate";
			}pt.close();
			}
		}	
			//else{	result="nouser";			}
		ptst.close();
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("the exception is found on the side of updation connection to update......."+e);
	}
	return result;
	}
public void setpassword(String user_name, String password)
{
	Connection con=erpconnection.conect();
	PreparedStatement st=null;
	try {
	  st=con.prepareStatement("update studentinfo  set password='"+password+"' where user_name='"+user_name+"'");
	  int i=st.executeUpdate();
	  if(i>0)
	  {
		 // System.out.println("no error base"); 
	  }
	  else
	  {
		 // System.out.println("error in base");
	  }
	  st.close();
	  con.close();
	} catch (Exception e) {
		// TODO: handle exception
		//System.out.println("the exception is find update...."+e.getMessage());
	}
}

public void setchpassword(String user_name, String password)
{
	Connection connn=erpconnection.conect();
	PreparedStatement s=null;
	//System.out.println("the password "+password); 
	try {
	  s=connn.prepareStatement("update chairmaninfo  set password='"+password+"' where user_name='"+user_name+"'");
	  int i=s.executeUpdate();
	  if(i>0)
	  {
		 // System.out.println("no error base"); 
	  }
	  else
	  {
		 // System.out.println("error in base");
	  }
	  s.close();
	  connn.close();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("the exception is find update...."+e.getMessage());
	}
}
}
