/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ajp;
 
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author PRAMOD
 */
public class studentupdatemaker {
                                     // id, name, dob, email, mono, sem
 public boolean updatedata(String id,String  name,String dob,String email,String mono,String sem)
    {
        boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","root","root");
            Statement st=con.createStatement();
                                        // id, name, dob, email, mono, sem

        String query="update studinfo set name='"+name+"',dob='"+dob+"',email='"+email+"',mono='"+mono+"',sem='"+sem+"' where id='"+id+"'";
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
