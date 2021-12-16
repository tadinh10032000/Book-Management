/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ductd
 */
public class BookDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stm;

    public List<Book> getAllBook() {
        List<Book> list = new ArrayList<>();
        String query = "select * from Book";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt("book_id"),
                        rs.getString("book_title"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        rs.getString("content"),
                        rs.getString("category")
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Book> getBookById(String id) {
        List<Book> list = new ArrayList<>();
        String query = "select * from Book\n"
                + "where book_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt("book_id"),
                        rs.getString("book_title"),
                        rs.getString("author"),
                        rs.getString("brief"),
                        rs.getString("publisher"),
                        rs.getString("content"),
                        rs.getString("category")
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
