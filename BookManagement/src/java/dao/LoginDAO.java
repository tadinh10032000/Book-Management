/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author win
 */
public class LoginDAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public User checkLogin(String user, String pass){
        try {
            String query ="SELECT * FROM [User] where user_name=? and password=?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                User a = new User(rs.getString("user_name"), rs.getString("password"), rs.getString("role_id"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
        
    }
    public static void main(String[] args) {
        LoginDAO login = new LoginDAO();
        User user = login.checkLogin("NGOCDK1", "123");
        System.out.println(user.getRole_id());
    }
}
