
package db01;

import com.mysql.cj.protocol.Resultset;
import static java.awt.SystemColor.info;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_connection {
    void create_connection(){
        try {
            // these are the 3 line code to create connetion between your database and the java project
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","fa1rw2in3!@#");
            System.out.println("Database connection successfull!!");
            
            //now to retrieve your database's(db1) data here these are the steps
            
            //first create the statement object
            Statement stmt=con.createStatement();
            //write the sql query
            String r_query="select * from users";
            //execute the query
            ResultSet rs =stmt.executeQuery(r_query);
            //display the results
            while(rs.next()){
                String name=rs.getString("Name");
                    System.out.println("name:"+name);
                
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DB_connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
