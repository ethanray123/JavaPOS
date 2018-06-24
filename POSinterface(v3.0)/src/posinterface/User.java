/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posinterface;

/**
 *
 * @author user
 */
public class User {
    private final String username;
    private final String password;
    private final String role;
    
    public User(String Username,String Password,String Role){
        this.username = Username;
        this.password = Password;
        this.role = Role;
    }
    
    
    public String getUsername()
    {
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getRole(){
        return role;
    }
}
