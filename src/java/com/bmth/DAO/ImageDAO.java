/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.DAO;

import com.bmth.Database.DatabaseConnect;
import com.bmth.bean.Comment;
import com.bmth.bean.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangbach
 */
public class ImageDAO {
   
    public boolean addImage(Image img){
        return true;
                
    }
    
    public Image getImageById(int id){
        Image image = new Image();
        String sql = "select * from depvl.IMAGE where id=?";
        Connection con = DatabaseConnect.getDBConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
               image.setImageId(id);
               image.setUserId(rs.getInt("USERID"));
               image.setCategory(rs.getString("CATEGORY"));
               image.setImageDescribe(rs.getString("IMGDESCRIBE"));
               image.setImageDate(rs.getDate("IMGDATE"));
               image.setUrlImage(rs.getString("IMG"));
               image.setPoint(rs.getFloat("POINT"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }
    
    public List<Image> getAllImageByUserId(int userId){
        List<Image> list = null;
        
        return list;
    }
    
    public List<Image> get10Image(int firstId){
        List<Image> list =null;
        
        return list;
    }
    
    public int getImageCount(){
        int count = 0;
        
        return count;
    }
    
}
