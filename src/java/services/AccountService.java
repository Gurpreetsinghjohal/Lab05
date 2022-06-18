/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import models.Users;
/**
 *
 * @author ASUS
 */
public class AccountService {
    public Users login(String username, String password){
        if((username.equals("abe") || username.equals("barb")) &&  password.equals("password")){
            return new Users(username,null);
        }
        return null;        
    }
    
}
