/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Book;
import entity.BookCase;
import entity.Contain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import context.DBContext;

/**
 *
 * @author NHD
 */
public class ContainDAO {

    DBContext dbCon = new DBContext();
    Connection con;

    public ContainDAO() throws Exception {
        this.con = dbCon.getConnection();
    }

    public List<Book> getAllBookByBookCaseId(int bookCaseId, int id) {
        List<Book> books = new ArrayList<>();
        String sql = "select b.book_id, b.book_title from book as b, contain as c, bookcase as bc "
                + "where bc.book_case_id = c.book_case_id and c.book_id = b.book_id "
                + "and c.book_case_id = ? and bc.id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, bookCaseId);
            pre.setInt(2, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setBook_id(rs.getInt("book_id"));
                book.setBook_title(rs.getString("book_title"));
                books.add(book);
            }
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return books;
    }

    public int addContain(Contain contain) {
        int n = 0;
        String sql = "insert into Contain(book_case_id,book_id,create_date) values(?,?,?)";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, contain.getBookCaseId());
            pre.setInt(2, contain.getBookId());
            pre.setDate(3, new java.sql.Date(contain.getCreateDate().getTime()));
            n = pre.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public int delateBookCaseById(int id, int bookCaseId) {
        int n = 0;
        String sql = "delete from Contain where book_id = ? and book_case_id = ?";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            pre.setInt(2, bookCaseId);
            n = pre.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(BookCaseDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        ContainDAO dao = new ContainDAO();
        List<Book> books = dao.getAllBookByBookCaseId(19,1);
        for (Book book : books) {
            System.out.println(book.getBook_title());
        }
        int n = dao.addContain(new Contain(2, 1, new Date()));
        System.out.println(n);
    }
}
