/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MySQL; 

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class CRUD {
    public static ResultSet selectUser(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from users");
        return rs;
    }
    
    public static ResultSet selectInventory(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from inventory");
        return rs;
    }
    
    public static ResultSet selectCart(Connection con) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from cart");
        return rs;
    }
    
    public static void insertUser(Connection con,String username,String password,String role) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO users(`Username`, `Password`, `Role`) VALUES('"+username+"','"+password+"','"+role+"')");
    }
    
    public static void deleteUser(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `users` WHERE `users`.`Username`='"+username+"'");
    }
    
    public static void updatePassword(Connection con,String username,String oldpassword,String newpassword) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `users` SET `Password` = '"+newpassword+"' WHERE `users`.`Username` = '"+username+"' AND Password='"+oldpassword+"'");
    }
    
    public static ResultSet selectUserPR(Connection con,String username) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select password,role" + " from users where username='" + username + "'");
        return rs;
    }
    
    public static void insertInventory(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO inventory(`Product`, `Price`, `Quantity`) VALUES('"+product+"','"+price+"','"+quantity+"')");
    }
            
    public static void deleteInventory(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `inventory` WHERE `inventory`.`Product`='"+product+"' AND Price='"+price+"' AND Quantity='"+quantity+"'");
    }
          
    public static void updateInventoryQ(Connection con,int stock,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `inventory` SET `Quantity` = '"+stock+"' WHERE `inventory`.`Product` = '"+product+"'");
    }
    
    public static ResultSet selectInventoryQ(Connection con,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from inventory where Product='" + product + "'");
        return rs;
    }
    
    public static ResultSet selectInventoryP(Connection con,String product,String price,String quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Product" + " from inventory where Product='"+product+"' AND Price='"+price+"' AND Quantity='"+quantity+"'");
        return rs;
    }
    
    public static ResultSet selectInventoryPrc(Connection con,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from inventory where Product='"+product+"'");
        return rs;
    }
    
    public static void insert(Connection con,String name,String product,String price,int quantity) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("INSERT INTO "+name+"(`Product`, `Price`, `Quantity`) VALUES('"+product+"','"+price+"','"+quantity+"')");
    }
    
    public static void updateQ(Connection con,String name,int stock,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
    }
    
    public static void delete(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `"+name+"` WHERE `"+name+"`.`Product`='"+product+"'");
    }
    
    public static ResultSet selectQ(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='"+product+"'");
        return rs;
    }
    
    public static ResultSet selectPrc(Connection con,String name,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Price" + " from "+name+" where Product='"+product+"'");
        return rs;
    }
    
    public static void deductQ(Connection con,String name,int deduction,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='" + product + "'");
        rs.next();
        int stock = rs.getInt("Quantity");
        stock = stock - deduction;
        if(stock >= 0){
            stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
        }
    }
    
    public static void addQ(Connection con,String name,int additional,String product) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity" + " from "+name+" where Product='" + product + "'");
        rs.next();
            int stock = rs.getInt("Quantity");
            stock = stock + additional;
            stmt.executeUpdate("UPDATE `"+name+"` SET `Quantity` = '"+stock+"' WHERE `"+name+"`.`Product` = '"+product+"'");
    }
    
    public static double getTotal(Connection con,String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from "+name);
        double total=0;
        while(rs.next()){
            total = total + (rs.getInt("Quantity")*rs.getDouble("Price"));
        }
        return total;
    }
    
    public static void deleteContents(Connection con,String name) throws SQLException{
        Statement stmt;
        stmt = con.createStatement();
        stmt.executeUpdate("DELETE FROM `"+name+"`");
    }
}