/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ajp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class loginmaker {
    public boolean dologin(String username,String password)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","root","root");
            Statement st=con.createStatement();
            
    String query="Select * from logininfo where username='"+username+"'and password='"+password+"'";
        ResultSet rs=st.executeQuery(query);
        if(rs.next())
                    flag=true;
        else
            flag=false;
        con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=false;
        }
        return flag;
    }   
    
}
