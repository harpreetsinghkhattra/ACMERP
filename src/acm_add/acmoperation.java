package acm_add;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.activation.*;



public class acmoperation {
	public static String stulogin(String user, String pas)
    {
        Connection conn=null;
        String result="";
         PreparedStatement ptst=null;
         ResultSet rs=null;
        studentinfobean obj=new studentinfobean();
        erpconnection obj1=new erpconnection();
                conn=obj1.conect();
                try {
                            ptst=conn.prepareStatement("select * from  studentinfo where user_name =?");
                            ptst.setString(1, user);
                             rs=ptst.executeQuery();
                      
                            while(rs.next())
                            {
                                if(pas.equals(rs.getString("password")))
                                {
                                    result="ok";
                                }
                                else
                                {
                                    result="wrong";
                                }
                            }
        } catch (Exception e) {
                    System.out.println("the exception is occured or error  is found in studentlogin port"+e);
        } 
        finally{
                    try {
                        conn.close();
                        ptst.close();
                        rs.close();
                    } catch (Exception e1) {
System.out.println("the exception is occured or error found in finallization in loginport of student"+e1);                    }
                }
                return result;
    }
	
	
	
    public static String addnewstudent(studentinfobean stu)
    {
        PreparedStatement ptst=null;
        Connection conn=null;
        String result="";
        ResultSet rs=null;
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from   studentinfo where user_name=?");
            ptst.setString(1, stu.getUsername());
           // System.out.println("username ="+stu.getUsername()); 

            rs=ptst.executeQuery();
            if(rs.next())
            {
                //System.out.println("username already exists try again............"); 
                
            }
            else
            {
                ptst=conn.prepareStatement("insert into  studentinfo (user_name, password, university_rollno, branch, gender, address, name, email) values(?,?,?,?,?,?,?,?)");
                ptst.setString(1, stu.getUsername());
                ptst.setString(2, stu.getPassword());
                ptst.setString(3, stu.getUnirollno());
                ptst.setString(4, stu.getBranch());
                ptst.setString(5, stu.getGender());
                ptst.setString(6, stu.getAddress());
                ptst.setString(7, stu.getStuname());
                ptst.setString(8, stu.getEmail()); 
                
                int i=ptst.executeUpdate();
                if(i>0)
                {
                    result="added";
                }
            }
        } catch (Exception e) {
            System.out.println("error on addnew ="+e); 
            
        }
        finally{
            try {
                rs.close();
                ptst.close();
                conn.close();
                
            } catch (Exception e1) {
               // System.out.println("error in addnew student ="+e1); 
            }
        }
        return result;
    }
    public static String addnewchstudent(studentinfobean stu)
    {
        PreparedStatement ptst=null;
        Connection conn=null;
        String result="";
        ResultSet rs=null;
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from chairmaninfo where user_name=?");
            ptst.setString(1, stu.getUsername());
           // System.out.println("username ="+stu.getUsername()); 

            rs=ptst.executeQuery();
            if(rs.next())
            {
                //System.out.println("username already exists try again............"); 
                
            }
            else
            {
                ptst=conn.prepareStatement("insert into chairmaninfo (user_name, password, universityrollno, branch, gender, address, name, email) values(?,?,?,?,?,?,?,?)");
                ptst.setString(1, stu.getUsername());
                ptst.setString(2, stu.getPassword());
                ptst.setString(3, stu.getUnirollno());
                ptst.setString(4, stu.getBranch());
                ptst.setString(5, stu.getGender());
                ptst.setString(6, stu.getAddress());
                ptst.setString(7, stu.getStuname());
                ptst.setString(8, stu.getEmail()); 
                
                int i=ptst.executeUpdate();
                if(i>0)
                {
                    result="added";
                }
            }
        } catch (Exception e) {
            System.out.println("error on addnew ="+e); 
            
        }
        finally{
            try {
                rs.close();
                ptst.close();
                conn.close();
                
            } catch (Exception e1) {
               // System.out.println("error in addnew student ="+e1); 
            }
        }
        return result;
    }
    public static String buildstuattendense(studentinfobean stu) 
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String user=null;
    	String userch=null;
    	String userstu=null;
        String result="";
        try {
			 conn=erpconnection.conect();
			 attendencestuinfo obj=new attendencestuinfo();
			 user=stu.getUsername();
			 //System.out.println("username is="+user); 
			 pt=conn.prepareStatement("alter table studentattendenceinfo add "+user+" varchar(50)");
			 			 
			 int i=pt.executeUpdate();
			
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in buildstuattendence="+e);
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
        return result;
    }
    public static String checkattendance() 
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String user=null;
    	String userch=null;
    	String userstu=null;
    	String d=null;
        String result="";
        List<attendencestuinfo> lt=null;
        List lt1=null;
        LocalDate date=LocalDate.now();
        try {
        	lt=new ArrayList<>();
        	lt1=new ArrayList<>();
			 conn=erpconnection.conect();
			 pt=conn.prepareStatement("select * from studentattendenceinfo date");
			 rs=pt.executeQuery();
			 while(rs.next())
			 {
				 attendencestuinfo obj=new attendencestuinfo();	 
				 obj.setAttend(Date.valueOf(rs.getString("date")));
				 lt.add(obj); 
			 }
			 if(date!=null)
			 {
				  d=date.toString();
					System.out.println("the d is"+d); 
			 }
			    for(int i=0;i<lt.size();i++)
			    {
				String l=((attendencestuinfo)lt.get(i)).getAttend().toString();
				System.out.println("the l is"+l); 
				if(l.equalsIgnoreCase(d))
				{
					result="send";
					break;
				}
			
			}
			 return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in buildstuattendence="+e);
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
        return result;
    }
    public static String buildstuattendencin(attendencestuinfo obj, String[] btn_atten)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String userch=null;
    	String userstu=null;
    	String mark=null;
    	String result="";
    	List<studentinfobean> lis=null;
    	// List<attendencestuinfo> li=null;
    	
    	try
    	{
    		LocalDate dt=LocalDate.now();
    		conn=erpconnection.conect();
    	 lis=new ArrayList<>();
    	// li=new ArrayList<>();
		 userch=obj.getUser_name();
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
			 mark=((studentinfobean)lis.get(i)).getAttendence(); 
			 column_name=((studentinfobean)lis.get(i)).getUsername();
			// System.out.println("the column is="+column_name);
			
		     pt=conn.prepareStatement("insert ignore into studentattendenceinfo (user_name ,"+column_name+", date) values('"+userch+"','"+mark+"','"+dt+"')");    
		     int row=pt.executeUpdate();
		     if(row>0)
			 {
				 result="added";
			 }
			 else
			 {
				 result="notadded";
			 } 

			// System.out.println("the userchair is="+userch); 
			 //System.out.println("the mark name is="+mark);
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
    	return result;
    	
    }
    public static String buildstuattendencinin(attendencestuinfo obj, String[] btn_atten)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String userch=null;
    	String userstu=null;
    	String mark=null;
    	String result="";
    	List<studentinfobean> lis=null;
    	 List<attendencestuinfo> li=null;
    	
    	try
    	{
    		LocalDate dt=LocalDate.now();
    		conn=erpconnection.conect();
    	 lis=new ArrayList<>();
    	 li=new ArrayList<>();
		 userch=obj.getUser_name();
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
		 
		 for(int j=0;j<btn_atten.length;j++)
		 {
		    	attendencestuinfo obj2=new attendencestuinfo();
			 obj2.setAttendence(btn_atten[j].toString()); 
			 li.add(obj2);  
		 }
		 
		 for(int i=0;i<lis.size(); i++) 
		 {
			// mark=((studentinfobean)lis.get(i)).getAttendence(); 
			 column_name=((studentinfobean)lis.get(i)).getUsername();
			// System.out.println("the column is="+column_name);
			 if(btn_atten.length!=0)
			 {
			// System.out.println("the size of list is="+li.size());
			 for(int j=0;j<btn_atten.length;j++)
			 {
				 String d=((attendencestuinfo)li.get(j)).getAttendence();
				// System.out.println("the Attendance is="+btn_atten[j]);
				if(column_name.equalsIgnoreCase(d)) 
				{
					//mark="P";
		     pt=conn.prepareStatement("update studentattendencecolinfo  set Attendence='P' where user_name='"+column_name+"'");    
		     int row=pt.executeUpdate();
		     if(row>0)
			 {
				 result="added";
			 }
			 else
			 {
				 result="notadded";
			 } 
		     break;
			// System.out.println("the userchair is="+userch); 
			 //System.out.println("the mark name is="+mark);
				}

				else if(!column_name.equalsIgnoreCase(d))
				{
					//mark="A";
		     pt=conn.prepareStatement("update studentattendencecolinfo  set Attendence='A' where user_name='"+column_name+"'");    
		     int row=pt.executeUpdate();
			 if(row>0)
			 {
				 result="added";
			 }
			 else
			 {
				 result="notadded";
			 }
			// System.out.println("the userchair is="+userch); 
			// System.out.println("the mark name is="+mark);

				}
				
				
						 }
		 }
		//String[] column_name1={column_name}; 
  		
			 
		 
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
    	return result;
    	
    }
    public static List<studentinfobean> getlistproject(    	List<studentinfobean> lt) 
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	    	
    	try {
    		
    		lt=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentattendencecolinfo");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			studentinfobean obj=new studentinfobean();
    			obj.setUnirollno(rs.getString("stucolumn_name"));  
    			obj.setUsername(rs.getString("user_name")); 
    			obj.setAttendence(rs.getString("Attendence")); 
    			lt.add(obj); 
    			
    		
    		}
    		return lt;
    			
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
		return lt;
    }
    
    public static List<attendencestuinfo> studentattendnceviewww(String intial, String finall,String col_name)
    {
    	List<attendencestuinfo> lt=new ArrayList<>();
    	    	
		acmoperation obj=new acmoperation();
    	
		//lt=obj.studentattendncevieww(intial, finall, col_name); 
        return lt;
    }
    public static List<studentinfobean> studentattendncevieww(String intial,String finall,String col_name,List<studentinfobean> lt1)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	List<attendencestuinfo> lt=null;
        List<attendencestuinfo> ltt=null;
    	try
    	{
    		lt1=new ArrayList<>();
    	lt=new ArrayList<>();
    	ltt=new ArrayList<>();
    	if(intial!=null)
    	{
    		if(finall!=null)
    		{
    			attendencestuinfo obj2=new attendencestuinfo();
    			obj2.setAttendence(intial);
    			obj2.setColumn_name(finall); 
    			ltt.add(obj2);
    		}
    	}
    	conn=erpconnection.conect();
    	pt=conn.prepareStatement("select  "+col_name+",date  from studentattendenceinfo WHERE "+col_name+" IS NOT NULL AND TRIM("+col_name+") <> ''");
    	rs=pt.executeQuery();
    	while(rs.next())
    	{
    		attendencestuinfo obj=new attendencestuinfo();
    		//String col_name=session.getAttribute("username").toString();
           	ResultSetMetaData data=rs.getMetaData();
    		for(int i=1;i<=data.getColumnCount();i++)
    		{
    			if(data.getColumnName(i).equals(col_name)) 
    			{
    				
    	    obj.setAttendence(rs.getString(i)); 
    		
    			}
    		}
    	    obj.setDate(rs.getString("date"));
    	    lt.add(obj);
    		}
    	for(int j=0;j<ltt.size();j++)
 	   {
     	   String y=((attendencestuinfo)ltt.get(j)).getAttendence();
     	   String k=((attendencestuinfo)ltt.get(j)).getColumn_name();
       	    System.out.println("the value of y is"+y);    

     	       	    System.out.println("the value of k is"+k);    
    	for(int i=0;i<lt.size();i++)
    	{
    		   studentinfobean obj=new studentinfobean();
    	   String l=((attendencestuinfo)lt.get(i)).getDate();
       	   if(l.equalsIgnoreCase(y))
    	   {
       		   obj.setAttendance(((attendencestuinfo)lt.get(i)).getAttendence()); 
       		   obj.setDate(((attendencestuinfo)lt.get(i)).getDate()); 
       		   lt1.add(obj);
       	   System.out.println("the value of is"+((attendencestuinfo)lt.get(i)).getAttendence());    
    	   
    	   }
       	   else if(l.equalsIgnoreCase(k))
       	 {
       		obj.setAttendance(((attendencestuinfo)lt.get(i)).getAttendence());
    		   obj.setDate(((attendencestuinfo)lt.get(i)).getDate()); 
    		   lt1.add(obj);
          	    System.out.println("the value of is"+((attendencestuinfo)lt.get(i)).getColumn_name());    
       	   }
    	   }
    	}
    	return lt1;
    	} 
    	catch(Exception e)
    	{
    	System.out.println("the exception is"+e.getMessage());
    	}

    	finally
    	{
    		try
    		{
    			pt.close();
    			rs.close();
    			conn.close();
    		}
    		catch(Exception e1)
    		{
    			
    		}
    	}
return lt1;
    }
    public static String studentattendececol(studentinfobean obj) 
    {
    	Connection conn=null;
    	ResultSet rs=null;
        PreparedStatement pt=null;
        String chuser=null;
        String stuuser=null;
        String result="";
        
        try {
			conn=erpconnection.conect();
			chuser=obj.getUsername();
			stuuser=obj.getUnirollno();
			pt=conn.prepareStatement("select * from studentattendencecolinfo where user_name='"+obj.getUsername()+"'");
			rs=pt.executeQuery();
			String a="";
			if(rs.next())
			{
				
			}
			else
			{
			pt=conn.prepareStatement("insert into studentattendencecolinfo (user_name,stucolumn_name,Attendence) values('"+chuser+"','"+stuuser+"','"+a+"')"); 
			int i=pt.executeUpdate();
			{
	          if(i>0) 
	          {
	        	  result="added";
	          }
	          else
	          {
	        	  result="notadded"; 
	          }
			}
	
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error on studentattendencec"+e); 
			
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
        return result;
    }
    public static String studentprojectregister(projectinfo obj)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String result="";
    	List<studentinfobean> lt3=null;
        	
    	try {
		conn=erpconnection.conect();
		lt3=new ArrayList<>();
		pt=conn.prepareStatement("insert into studentproject (user_name,username1,username2,username3,project_name,description,date,initial_date) values('"+obj.username+"','"+obj.getUsername1()+"','"+obj.getUsername2()+"','"+obj.getUsername3()+"','"+obj.getProjectname()+"','"+obj.description+"','"+obj.finaldate+"','"+LocalDate.now()+"')");
		int i=pt.executeUpdate();
		if(i>0)
		{
			result="added";
		}
		else
		{
			result="not added";
		}
		
		pt=conn.prepareStatement("select date  from studentproject");
		rs=pt.executeQuery();
		
		return result;
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in projectiiiiiiiiinnnnnnnnn"+e); 
		}
    	
    	finally
    	{
    		try {
				rs.close();
				pt.close();
				conn.close(); 
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return result;
    }
    public static void deleteproject(String[] check)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	List<projectinfo> ltt=null;
    	List<studentinfobean> lt1=null;
    	    	
    	try {
    		
    		ltt=new ArrayList<>();
    		lt1=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentproject");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			projectinfo obj=new projectinfo();
    			obj.setProjectname(rs.getString("project_name"));  
    			obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
    			//obj.setAttendence(rs.getString("Attendence")); 
    			ltt.add(obj); 
    		}
    		for(int j=0;j<check.length;j++)
			{
    			studentinfobean obj2=new studentinfobean();
    			obj2.setUnirollno(check[j].toString()); 
    			lt1.add(obj2); 
			}
    		for(int i=0;i<=ltt.size();i++)
    		{
    			String finaldae=((projectinfo)ltt.get(i)).getProjectname();
				System.out.println("the value of final  is"+finaldae);  
    			for(int j=0;j<check.length;j++)
    			{
    				String fianldate1=((studentinfobean)lt1.get(j)).getUnirollno();
    				System.out.println("the value of final date is"+fianldate1);  

    				if(finaldae.equalsIgnoreCase(fianldate1)) 
    				{
    					pt=conn.prepareStatement("delete from studentproject where project_name='"+fianldate1+"'");
    		    		int row=pt.executeUpdate();
    		    		break;
    				}
    			}
    		}
    			
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }
    public static void deltestudent(String[] check)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	List<studentinfobean> ltt=null;
    	List<studentinfobean> lt1=null;
    	    	
    	try {
    		
    		ltt=new ArrayList<>();
    		lt1=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentinfo");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			studentinfobean obj=new studentinfobean();
    			obj.setUsername(rs.getString("user_name"));  
    			//obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
    			//obj.setAttendence(rs.getString("Attendence")); 
    			ltt.add(obj); 
    		}
    		for(int j=0;j<check.length;j++)
			{
    			studentinfobean obj2=new studentinfobean();
    			obj2.setUnirollno(check[j].toString()); 
    			lt1.add(obj2); 
			}
    		for(int i=0;i<=ltt.size();i++)
    		{
    			String finaldae=((studentinfobean)ltt.get(i)).getUsername();
				System.out.println("the value of final  is"+finaldae);  
    			for(int j=0;j<check.length;j++)
    			{
    				String fianldate1=((studentinfobean)lt1.get(j)).getUnirollno();
    				System.out.println("the value of final date is"+fianldate1);  

    				if(finaldae.equalsIgnoreCase(fianldate1)) 
    				{
    					pt=conn.prepareStatement("delete from studentinfo  where user_name='"+fianldate1+"'");
    		    		int row=pt.executeUpdate();
    		    		break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }
    public static void deltestudentone(String[] check)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	List<studentinfobean> ltt=null;
    	List<studentinfobean> lt1=null;
    	    	
    	try {
    		
    		ltt=new ArrayList<>();
    		lt1=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentattendencecolinfo");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			studentinfobean obj=new studentinfobean();
    			obj.setUsername(rs.getString("user_name"));  
    			//obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
    			//obj.setAttendence(rs.getString("Attendence")); 
    			ltt.add(obj); 
    		}
    		for(int j=0;j<check.length;j++)
			{
    			studentinfobean obj2=new studentinfobean();
    			obj2.setUnirollno(check[j].toString()); 
    			lt1.add(obj2); 
			}
    		for(int i=0;i<=ltt.size();i++)
    		{
    			String finaldae=((studentinfobean)ltt.get(i)).getUsername();
				System.out.println("the value of final  is"+finaldae);  
    			for(int j=0;j<check.length;j++)
    			{
    				String fianldate1=((studentinfobean)lt1.get(j)).getUnirollno();
    				System.out.println("the value of final date is"+fianldate1);  

    				if(finaldae.equalsIgnoreCase(fianldate1)) 
    				{
    					pt=conn.prepareStatement("delete from studentattendencecolinfo  where user_name='"+fianldate1+"'");
    		    		int row=pt.executeUpdate();
    		    		break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnnone="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }
    public static void deltestudenttwo(String[] check)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	List<studentinfobean> ltt=null;
    	List<studentinfobean> lt1=null;
    	    	
    	try {
    		
    		ltt=new ArrayList<>();
    		lt1=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentattendenceinfo");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			studentinfobean obj=new studentinfobean();
    			obj.setUsername(rs.getString("user_name"));  
    			//obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
    			//obj.setAttendence(rs.getString("Attendence")); 
    			ltt.add(obj); 
    		}
    		for(int j=0;j<check.length;j++)
			{
    			studentinfobean obj2=new studentinfobean();
    			obj2.setUnirollno(check[j].toString()); 
    			lt1.add(obj2); 
			}
    		for(int i=0;i<=ltt.size();i++)
    		{
    			String finaldae=((studentinfobean)ltt.get(i)).getUsername();
				System.out.println("the value of final  is"+finaldae);  
    			for(int j=0;j<check.length;j++)
    			{
    				String fianldate1=((studentinfobean)lt1.get(j)).getUnirollno();
    				System.out.println("the value of final date is"+fianldate1);  

    				if(finaldae.equalsIgnoreCase(fianldate1)) 
    				{
    					pt=conn.prepareStatement("alter table studentattendenceinfo drop '"+fianldate1+"'");
    		    		int row=pt.executeUpdate();
    		    		break;
    				}
    			}
    		}
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnntwo="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }

    public static void deletenotice(String[] check)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	List<noticeinfobean> ltt=null;
    	List<studentinfobean> lt1=null;
    	    	
    	try {
    		
    		ltt=new ArrayList<>();
    		lt1=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from noticeupdate");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
    			noticeinfobean obj=new noticeinfobean();
    			obj.setHeading(rs.getString("heading"));  
    			//obj.setFinaldate(Date.valueOf(rs.getString("date"))); 
    			//obj.setAttendence(rs.getString("Attendence")); 
    			ltt.add(obj); 
    		}
    		for(int j=0;j<check.length;j++)
			{
    			studentinfobean obj2=new studentinfobean();
    			obj2.setUnirollno(check[j].toString()); 
    			lt1.add(obj2); 
			}
    		for(int i=0;i<=ltt.size();i++)
    		{
    			String finaldae=((noticeinfobean)ltt.get(i)).getHeading(); 
				System.out.println("the value of final  is"+finaldae);  
    			for(int j=0;j<check.length;j++)
    			{
    				String fianldate1=((studentinfobean)lt1.get(j)).getUnirollno();
    				System.out.println("the value of final date is"+fianldate1);  

    				if(finaldae.equalsIgnoreCase(fianldate1)) 
    				{
    					pt=conn.prepareStatement("delete from noticeupdate  where heading='"+fianldate1+"'");
    		    		int row=pt.executeUpdate();
    		    		break;
    				}
    			}
    		}
    			
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }
    public static String uploadnoticeeee(InputStream inputstream,String heading,String date1,String time1)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String result="";
    	
    	//String path=null;
    	try {
			conn=erpconnection.conect();
			 //System.out.print(inputstream);
			//System.out.println("the heading of notice is="+heading);
			pt=conn.prepareStatement("insert into noticeupdate (heading, path, date, time ) values(?,?,?,?)");  
		   pt.setString(1, heading);
		   if(inputstream!=null)
		   {
			   pt.setBlob(2, inputstream); 

		   }
		   pt.setString(3, date1);
		   pt.setString(4, time1); 
	       int i=pt.executeUpdate();
	       
			if(i>0)
			{
				result="added";
			}
			else
			{
				result="notadded"; 
			}
		} catch (Exception e) {
			// TODO: handle exception
			
			//System.out.println("notice is noticeupdate not done"+e.getMessage()); 
		}
    	finally {
			try {
				conn.close();
				//pt.close();
				//rs.close(); 				
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
return result;	
    }
    public static void studentproject()
    {
    	projectinfo  obj3=null;
		Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	    	
    	try {
    		
    		//lt=new ArrayList<>();
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("update studentproject set initial_date='"+LocalDate.now()+"'");
    		int row=pt.executeUpdate();
    		
    		
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    }
    
    public static projectinfo studentprojecta(projectinfo obj)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String chuser=null;
    	//String result="";
    	    	
    	try {
    		
    		conn=erpconnection.conect();
    		pt=conn.prepareStatement("select * from studentproject where project_name='"+obj.getProjectname()+"'");
    		rs=pt.executeQuery();
    		while(rs.next())
    		{
	
    			obj.setUsername(rs.getString("user_name"));
    			obj.setUsername1(rs.getString("username1"));
    			obj.setUsername2(rs.getString("username2"));
    			obj.setUsername3(rs.getString("username3"));
    			obj.setDescription(rs.getString("project_name"));
    			obj.setProjectname(rs.getString("project_name"));
    			obj.setFinaldate(Date.valueOf(rs.getString("date")));
    			obj.setDescription(rs.getString("description"));
    			
    			return obj;
    		}
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		System.out.println("the erron in studentattendencecolinnnnnnnn="+e.getMessage());  
    	}
    	finally {
    		try {
    			conn.close();
    			rs.close();
    			pt.close();
    		} catch (Exception e2) {
    			// TODO: handle exception
    		}
    	}
    	return obj;
    }
    public static void informtochproject(projectinfo obj)
    {
    	Connection conn=null;
    	ResultSet rs=null;
    	PreparedStatement pt=null;
    	String result="";
    	try {
			conn=erpconnection.conect();
			obj.getProjectname();
			pt=conn.prepareStatement("select * from chairmaninfo where user_name='"+obj.getUsername()+"'");
			rs=pt.executeQuery();
			while(rs.next())
			{
				obj.setUsername1(rs.getString("email"));
				emailtoinform(obj); 

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in chproject"+e); 
		}

    	finally
    	{
    		try {
				rs.close();
				pt.close();
				conn.close(); 
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    }
    public static void emailtoinform(projectinfo obj)
    {
    	Properties props =new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port","465");
        
        
        Session session= Session.getInstance(props,new javax.mail.Authenticator()
        {
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("harpreet872909066@gmail.com", "Ha872909066");
                        }
                    }
                );
        try{
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress("harpreet872909066@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(obj.getUsername1()));
	    	System.out.println("the email address is="+obj.getUsername1()); 

            message.setSubject("Inform Regarding Project");
            message.setText("your given time of student to accomplish a project has abolished, Check out the project '"+obj.getProjectname()+"'");
            
            
            Transport.send(message);
            System.out.println( "Check your mail for Password!!!"); 
            
        }catch(Exception e){
      System.out.println("error in java.mail found="+e); 
        }

    }
    public static String updatestudent(studentinfobean stu)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("update studentinfo set  student_name=?, university_rollno=? ,branch=? ,address=? ,gender=? where user_name=?;");
            ptst.setString(1, stu.getStuname());
            ptst.setString(2, stu.getUnirollno());
            ptst.setString(3, stu.getBranch());
            ptst.setString(4, stu.getAddress());
            ptst.setString(5, stu.getGender());
            ptst.setString(6, stu.getUsername());
            int i=ptst.executeUpdate();
            if(i>0)
            {
                result="added";
               
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally
        {
            try {
                rs.close();
                ptst.close();
                conn.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
        return result;
    }
    public static void getstudentnotice()
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	String heading=null;
    	String result=null;
    	ResultSet rs=null;
    	List ls=null;
    	
    	noticeinfobean obj=new noticeinfobean();
    	
    	try {
    		ls=new ArrayList();
			conn=erpconnection.conect();
			pt=conn.prepareStatement("select * from noticeupdate");
			obj.setHeading(heading); 
			rs=pt.executeQuery(); 
			while(rs.next())
			{
				obj.setHeading(rs.getString("heading"));
				ls.add(obj); 
			}
			System.out.println("the lis is"+ls.size());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in getnotice"+e);
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
    public static ResultSet opennotice(noticeinfobean obj)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String result=null;
    	String headi=null;
    	
    	try {
			conn=erpconnection.conect();
			headi=obj.getHeading();
			System.out.println("the headi"+headi); 
			pt=conn.prepareStatement("select * from noticeupdate where heading =?");
			pt.setString(1, headi);
            rs=pt.executeQuery();
            return rs;
            
    	} catch (Exception e) {
			// TODO: handle exception
    		System.out.println("the error in opennotice"+e);
		}
    	finally {
			try {
				rs.close();
				pt.close();
				conn.close(); 
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
    	return rs;
    }
    public void  updatestudentdetail(String user_name, String university_rollno, String branch, String gender, String address, String name)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	try {
			 conn=erpconnection.conect();
			 pt=conn.prepareStatement("update studentinfo set university_rollno='"+university_rollno+"', branch='"+branch+"', gender='"+gender+"', address='"+address+"', name='"+name+"' where user_name='"+user_name+"'");
			 int i=pt.executeUpdate();
			 if(i>0)
			 {
				 System.out.println("edit is found"); 
			 }
			 else
			 {
				 System.out.println("edit is not found"); 
			 }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error is found"+e.getMessage()); 
		}
    }
    public static String addchuser(chairmaninfobean ch)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from chairmaninfo where user_name=?");
            ptst.setString(1, ch.getUsername());
            rs=ptst.executeQuery();
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null, "chairman or vicechairman username is already exist please try again......");
                
            }
            else
            {
                ptst=conn.prepareStatement("insert into chairmaninfo (user_name, password, chairman_name,  university_rollno, branch, address, gender) values(?,?,?,?,?,?,?)");
                
                ptst.setString(1, ch.getUsername());
                ptst.setString(2, ch.getPassword());
                ptst.setString(3, ch.getChairmanname());
                ptst.setString(4, ch.getUniversity_rollno());
                ptst.setString(5, ch.getBranch());
                ptst.setString(6, ch.getAddress());
                ptst.setString(7, ch.getGender());
                int i=ptst.executeUpdate();
                if(i>0)
                {
                    result="added";
                }
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try {
                rs.close();
                ptst.close();
                conn.close();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
                               
            }
        }
        return result;
    }
    public static String getchpassword(String reemil) 
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	String user=null;
    	String pwd=null;
    	ResultSet rs=null;
    	String result="";
    	try {
    		conn=erpconnection.conect();
		 pt=conn.prepareStatement("select * from chairmaninfo where email=?");
		 pt.setString(1, reemil); 
		 rs=pt.executeQuery();
		 while(rs.next())
		 {
			 user=rs.getString("user_name");
			 pwd=rs.getString("password");
			 sendMail(user, pwd, reemil);
			 result="sent";
		 }
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in fetching"+e.getMessage()); 
		}
    	finally
    	{
    		try {
				rs.close();
				conn.close();
	    		pt.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	return result;
    }
    public static void sendMail(String un, String pwd,String remail){
        Properties props =new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port","465");
        
        
        Session session= Session.getInstance(props,new javax.mail.Authenticator()
        {
                        protected PasswordAuthentication getPasswordAuthentication(){
                            return new PasswordAuthentication("harpreet872909066@gmail.com", "Ha872909066");
                        }
                    }
                );
        try{
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress("harpreet872909066@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(remail));
	    	System.out.println("the email address is="+remail); 

            message.setSubject("Recovery Password");
            message.setText("Username: "+un+"\nPassword: "+pwd);
            
            
            Transport.send(message);
            System.out.println( "Check your mail for Password!!!"); 
            
        }catch(Exception e){
      System.out.println("error in java.mail found="+e); 
        }
    }
    public static String  getstudentpassword(String email)
    {

    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String user=null;
    	String pwd=null;
    	String result="";
    	try {
			conn=erpconnection.conect();
			pt=conn.prepareStatement("select * from studentinfo where email=?");

			pt.setString( 1, email); 
			rs=pt.executeQuery();
			while(rs.next())
			{
				user=rs.getString("user_name");
				pwd=rs.getString("password");
		    	System.out.println("the email address is="+user); 
		    	System.out.println("the email address is="+pwd); 

				sendMail(user, pwd, email); 
				result="sent";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the mail is not sent="+e);
			}
    	finally{
    		try {
				conn.close();
				rs.close();
				pt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
    	}
    	return result;
    }
    public static String chlogin(String user, String password)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        chairmaninfobean obj=new chairmaninfobean();
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from chairmaninfo where user_name=?");
            ptst.setString(1, user);
            rs=ptst.executeQuery();
            while(rs.next())
            {
            	obj.setChairmanname(rs.getString("name"));             	
                if(password.equals(rs.getString("password")))
                {
                    result="ok";
                }
                else
                {
                    result="wrong";
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally
        {
            try {
                rs.close();
                ptst.close();
                conn.close();
                
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
        return result;
    }
    
    public static studentinfobean getstudentdetail(String user)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        studentinfobean obj=new studentinfobean();
        
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from studentinfo where user_name=?");
            ptst.setString(1, user);
            rs=ptst.executeQuery();
            while(rs.next())
            {
                obj.setUsername(rs.getString("user_name"));
                obj.setPassword(rs.getString("password")); 
                obj.setUnirollno(rs.getString("university_rollno"));
                obj.setBranch(rs.getString("branch"));
                obj.setAddress(rs.getString("address"));
                obj.setGender(rs.getString("gender"));
                obj.setStuname(rs.getString("name"));
                obj.setEmail(rs.getString("email")); 
                result="ok";
            }
            
        } catch (Exception e) {
       System.out.println("the connection to show detail has been denied................."+e);
        }
        finally
        {
            try {
                rs.close();
                ptst.close();
                conn.close();
            } catch (Exception e1) {
       System.out.println("the connection to show detail has been denied in finallization............"+e1);
            }
        }
        return obj;
    }
    
   
    public static chairmaninfobean getchetail(String user)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        chairmaninfobean obj=new chairmaninfobean();
        
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from chairmaninfo where user_name=?");
            ptst.setString(1, user);
            rs=ptst.executeQuery();
            while(rs.next())
            {
                obj.setUsername(rs.getString("user_name"));
                obj.setPassword(rs.getString("password")); 
                obj.setUniversity_rollno(rs.getString("universityrollno"));
                obj.setBranch(rs.getString("branch"));
                obj.setAddress(rs.getString("address"));
                obj.setGender(rs.getString("gender"));
                obj.setChairmanname(rs.getString("name"));
                obj.setEmail(rs.getString("email"));
                result="ok";
            }
            
        } catch (Exception e) {
       System.out.println("the connection to show detail has been denied................."+e);
        }
        finally
        {
            try {
                rs.close();
                ptst.close();
                conn.close();
            } catch (Exception e1) {
       System.out.println("the connection to show detail has been denied in finallization............"+e1);
            }
        }
        return obj;
    }   
    public static String changechpassword(String user, String oldpass, String newpass)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from chairmaninfo where user_name=?");
            ptst.setString(1, user);
            rs=ptst.executeQuery();
            while(rs.next())
            {
                if(oldpass.equals(rs.getString("password")))
                {
                    ptst=conn.prepareStatement("update chairmaninfo set password=? where user_name=?");
                    ptst.setString(1, newpass);
                    ptst.setString(2, user);
                    int i=ptst.executeUpdate();
                    if(i>0)
                    {
                        result="changed";
                        
                    }
                    else
                    {
                        result="notmatched";
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                ptst.close();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1);
                
            }
        }
        return result;
    }
    public static String noticeupdate(InputStream inputstream, String heading)
    {
    	Connection conn=null;
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    	String result="";
    	String path=null;
    	try {
			conn=erpconnection.conect();
			 System.out.print(inputstream);
			System.out.println("the heading of notice is="+heading);
			pt=conn.prepareStatement("insert into noticeupdate (heading, path) values(?,?)");  
		   pt.setString(1, heading); 
		   
	   			pt.setBlob(2, inputstream); 
	    	
	   			int i=pt.executeUpdate();
			if(i>0)
			{
				result="added";
			}
			else
			{
				result="notadded"; 
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("notice is noticeupdate not done"+e.getMessage()); 
		}
    	finally {
			try {
				conn.close();
				pt.close();
				rs.close(); 				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			return result; 
		}
    }
    public static String updatchdetail(String username, String uni_rollno, String branch,String gender,String name, String address)
    {
    	Connection conn=null;
    	String result="";
    	PreparedStatement pt=null;
    	ResultSet rs=null;
    
    	chairmaninfobean obj=new chairmaninfobean();
    	
    	try {
			conn=erpconnection.conect();
			pt=conn.prepareStatement("select * from chairmaninfo where user_name =? ");
			pt.setString( 1, username);
			rs=pt.executeQuery();
			while(rs.next())
			{
				pt=conn.prepareStatement("update chairmaninfo set universityrollno ='"+uni_rollno+"', branch ='"+branch+"', gender='"+gender+"', address='"+address+"', name='"+name+"' where user_name='"+username+"'");
			    
			    int i=pt.executeUpdate();
			    return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("the error in update"+e);
		}
    	finally {
			try {
				pt.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
    	return result; 
    }
    public static String changestupassword(String user, String newpass, String oldpass)
    {
        Connection conn=null;
        PreparedStatement ptst=null;
        ResultSet rs=null;
        String result="";
        
        try {
            conn=erpconnection.conect();
            ptst=conn.prepareStatement("select * from studentinfo where user_name=?");
            ptst.setString(1, user);
            rs=ptst.executeQuery();
            while(rs.next())
            {
                if(oldpass.equals(rs.getString("password")))
                {
                    ptst=conn.prepareStatement("update studentinfo set password=? where user_name=?");
                    ptst.setString(1, newpass);
                    ptst.setString(2, user);
                    int i=ptst.executeUpdate();
                    if(i>0)
                    {
                        result="changed";
                        
                    }
                    else
                    {
                        result="nomatched";
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        finally
        {
            try {
                conn.close();
                rs.close();
                ptst.close();
            } catch (SQLException e1) {
                JOptionPane.showMessageDialog(null, e1);
            }
        }
        return result;
        
    }
   

}
