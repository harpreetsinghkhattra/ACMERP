package acm_add;

import java.sql.Connection;
import java.sql.DriverManager;

public class erpconnection {
	public static Connection conect()
    {
         Connection con=null;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/erp","root","");
        
        }
        catch(Exception e)
        {
System.out.println("error in connection are occured "+ e);

    }
        return con;
    }
    


}
