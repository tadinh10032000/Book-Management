/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BookCase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import context.DBContext;

/**
 *
 * @author NHD
 */
public class BookCaseDAO {
    DBContext dbCon = new DBContext();
    Connection con;

    public BookCaseDAO() throws Exception {
        this.con = dbCon.getConnection();
    }
    public List<BookCase> getAllBookCase(){
        List<BookCase> bookCases = new ArrayList<>();
        String sql = "select * from BookCase";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                BookCase bookCase = new BookCase(rs.getInt("book_case_id"),rs.getInt("id"),rs.getString("book_case_name"));
                bookCases.add(bookCase);
            }
            
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return bookCases;
    }
        public List<BookCase> getBookCasesById(int id){
        List<BookCase> bookCases = new ArrayList<>();
        String sql = "select * from BookCase where id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                BookCase bookCase = new BookCase(rs.getInt("book_case_id"),rs.getInt("id"),rs.getString("book_case_name"));
                bookCases.add(bookCase);
            }
            
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return bookCases;
    }
    
    public int addBookCase(BookCase bookCase){
        int n = 0;
        String sql = "insert into BookCase(id,book_case_name) values(?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, bookCase.getId());
            pre.setString(2, bookCase.getBookCaseName());
            n = pre.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
    public int deleteBookCaseByBookCaseId(int id){
        int n = 0;
        String sql = "delete from BookCase where book_case_id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,  id);
            n = pre.executeUpdate();
        } catch (Exception e) {
             Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }
    public static void main(String[] args) throws Exception {
        
        List<BookCase> bookCases = new BookCaseDAO().getBookCasesById(4);
        for (BookCase bookCase : bookCases) {
            System.out.println(bookCase.getBookCaseName());
        }
        
        
    }

}
