/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author NHD
 */
public class BookCase {
    private int bookCaseId;
    private int id;
    private String bookCaseName;

    public BookCase() {
    }

    public BookCase(int id, String bookCaseName) {
        this.id = id;
        this.bookCaseName = bookCaseName;
    }
    
    public BookCase(int bookCaseId,int id, String bookCaseName) {
        this.bookCaseId = bookCaseId;
        this.id = id;
        this.bookCaseName = bookCaseName;
    }

    public int getBookCaseId() {
        return bookCaseId;
    }

    public void setBookCaseId(int bookCaseId) {
        this.bookCaseId = bookCaseId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCaseName() {
        return bookCaseName;
    }

    public void setBookCaseName(String bookCaseName) {
        this.bookCaseName = bookCaseName;
    }

    @Override
    public String toString() {
        return "BookCase{" + "bookCaseId=" + bookCaseId + ", id=" + id + ", bookCaseName=" + bookCaseName + '}';
    }

  


    
    
}
