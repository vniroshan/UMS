     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

/**
 *
 * @author Nirosh
 */

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.istack.internal.logging.Logger;
import java.sql.*;
import java.util.logging.Level;
import sun.util.logging.PlatformLogger;

public class dbconnect {
    
    
     
    public static Connection getConnection()
    {
        Connection con=null;
        
       
        
         try {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/datas","root","");
            
         } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return con;
    }
}
