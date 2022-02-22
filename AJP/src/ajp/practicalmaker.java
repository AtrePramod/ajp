/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ajp;

 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class practicalmaker {
    
   //  rollno, prano, pramarks
    public boolean insertData(String rollno,String prano,String pramarks)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","root","root");
            Statement st=con.createStatement();
//                                        rollno, prano, pramarks
            String query="insert into practical values('"+rollno+"','"+prano+"','"+pramarks+"')";
        int x=st.executeUpdate(query);
        if(x>0)
        
            flag=true;
        else
            flag=false;
        }
        catch(Exception e)
        {
            System.out.println(e);
            flag=false;
        }
        return flag;
    }
}
