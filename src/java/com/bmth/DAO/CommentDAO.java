/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bmth.DAO;

import com.bmth.Database.DatabaseConnect;
import com.bmth.bean.Comment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quangbach
 */
public class CommentDAO {
    public boolean addComment(Comment c){
        boolean result = false;
        String sql = "insert into depvl.COMMENT value( ?,?,?,?)";
        if( checkUserId(c.getUserId()) && checkImageId(c.getImageId())){
            Connection con = DatabaseConnect.getDBConnection();
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, c.getId());
                ps.setInt(2, c.getUserId());
                ps.setInt(3, c.getUserId());
                ps.setString(4, c.getComment());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
                result = false;
            }
            result = true;
        }
        return result;
    }
    
    public Comment getComment(int id){
        Comment comment = new Comment();
        String sql = "select * from depvl.COMMENT where id=?";
        Connection con = DatabaseConnect.getDBConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                comment.setId(id);
                comment.setImageId(rs.getInt(2));
                comment.setUserId(rs.getInt(3));
                comment.setComment(rs.getString(4));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comment;
    }
    
     public List<Comment> getAllCommentByImageId(int id){
        List<Comment> list = new ArrayList<>();
        Comment comment;
        String sql = "select * from depvl.COMMENT where imgid=?";
        Connection con = DatabaseConnect.getDBConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                comment = new Comment();
                comment.setId(id);
                comment.setImageId(rs.getInt(2));
                comment.setUserId(rs.getInt(3));
                comment.setComment(rs.getString(4));
                list.add(comment);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     
     public boolean checkUserId(int id){
         boolean check = true;
        String sql = "select * from depvl.USER where id=?";
        Connection con = DatabaseConnect.getDBConnection();
        ResultSet rs = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs == null) check =false;
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
     }
     
     public boolean checkImageId(int id){
         boolean check = true;
        String sql = "select * from depvl.IMAGE where id=?";
        Connection con = DatabaseConnect.getDBConnection();
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs == null) check =false;
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
     }
}
