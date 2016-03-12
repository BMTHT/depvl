/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.DAO;

import com.bmth.bean.User;
import java.util.Date;

/**
 *
 * @author quangbach
 */
public class UserDAO {
    
    public boolean addUser(User user){
        return true;
    }
    
    public boolean addUser( String fullname, Date birthday, int sex, String email){
        return true;
    }
    public User getUserById(int id){
        User user = null;
        
        return user;
    }
    
    
}
