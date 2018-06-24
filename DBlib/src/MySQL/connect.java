/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class connect {
    public static Connection getConnection()
    {
        Connection con;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos","root","");
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
