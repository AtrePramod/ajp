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
public class viewpractical {
    public void viewAllstudent()
    {
       try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","root","root");
            Statement st1=con.createStatement();
            Statement st2=con.createStatement();
               Statement st3=con.createStatement();  
            String query="Select * from studinfo";
            ResultSet rs1=st1.executeQuery(query);        
            ResultSet rs2=st2.executeQuery(query); 
            String query1="Select * from practical";
            ResultSet rs3=st3.executeQuery(query1);
            
            int row=0;
            while(rs1.next())
            {
                row++;
            }
            int i=0;
            String [][] data=new String[row][17];
           // id, name, dob, email, mono, sem
            //   rollno, prano, pramarks
                while(rs2.next())
                {
                    String rollno=rs2.getString(1);
                    String  name=rs2.getString(2);
                
                    data[i][0]=rollno;
                    data[i][1]= name;
                     i++;
               }       //   rollno, prano, pramarks
                while(rs3.next())
                {
                    String rollno=rs3.getString(1);
                    int p=Integer.parseInt(rollno);  
                    String  prano=rs3.getString(2);
                    int q=Integer.parseInt(prano);
                    if(p!=0)
                    {
                        p--;
                        q++;
                    }    
                    String  pramarks=rs3.getString(3);
                    System.out.println("pramarks="+(pramarks));
                    data[p][q]=pramarks;
                  
                   
                   i++;
               }
                 practicalviewframe.data1=data;
        }
        catch(Exception e)
        {
            System.out.println("Pramod atre="+e);
             
        }
    }
    
}
