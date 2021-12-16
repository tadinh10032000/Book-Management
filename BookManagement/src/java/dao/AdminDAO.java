/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import context.DBContext;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NgocDo
 */
public class AdminDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext db = new DBContext();

    public List<Book> getAll() {
        String query = "select * from Book";
        List<Book> list = new ArrayList<>();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Book getOne(int id) {
        String query = "select * from Book where book_id = ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;

    }

    public boolean update(Book b) throws Exception {
        String query = "update Book set book_title = ?, author = ?,brief = ?,publisher = ?,content = ?,category= ? where book_id = ?";
        int check = 0;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, b.getBook_title());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getBrief());
            ps.setString(4, b.getPublisher());
            ps.setString(5, b.getContent());
            ps.setString(6, b.getCategory());
            ps.setInt(7, b.getBook_id());
            check = ps.executeUpdate();
            System.out.println(check);
        } catch (Exception e) {
            throw e;
        }
        return check > 0;
    }

    public boolean delete(int id) throws Exception {
        String query = " delete from Book where book_id = ? ";
        int check = 0;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
        return check > 0;
    }

    public boolean insertBook(String bookTitle, String author, String brief, String publisher, String content, String category) {
        String query = "insert into Book(book_title,author,brief,publisher,content,category) values (?,?,?,?,?,?)";
        int check = 0;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, bookTitle);
            ps.setString(2, author);
            ps.setString(3, brief);
            ps.setString(4, publisher);
            ps.setString(5, content);
            ps.setString(6, category);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return check > 0;
    }
    public static void main(String[] args) throws Exception {
        AdminDAO dao = new AdminDAO();
        Book b = new Book();
        
    
       
        
        
    }
}
