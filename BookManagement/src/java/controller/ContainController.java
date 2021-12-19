/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Book;
import entity.Contain;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.BookDAO;
import dao.ContainDAO;
import context.DBContext;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NHD
 */
@WebServlet(name = "ContainController", urlPatterns = {"/ContainController"})
public class ContainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ContainDAO containDao = new ContainDAO();
            BookDAO bookDao = new BookDAO();
            
            int bookCaseId = Integer.parseInt(request.getParameter("bookCaseId"));
            HttpSession session = request.getSession();
            session.setAttribute("bookCaseId", bookCaseId);
            
            int id = (int) session.getAttribute("id");
            
            String action = request.getParameter("action");
            switch (action) {
                case "show":
                    List<Book> books = containDao.getAllBookByBookCaseId(bookCaseId, id);
                    List<Book> allBook = bookDao.getAllBook();
                    
                    for (int i = 0; i < allBook.size(); ++i) {
                        for (int j = 0; j < books.size(); ++j) {
                            if (allBook.get(i).getBook_id() == books.get(j).getBook_id()) {
                                allBook.remove(i);
                            }
                        }
                    }
                    request.setAttribute("allBook", allBook);
                    request.setAttribute("books", books);
                    request.getRequestDispatcher("containDetail.jsp").forward(request, response);
                    break;
                case "delete":
                    int book_id = Integer.parseInt(request.getParameter("book_id"));
                    int n = containDao.delateBookCaseById(book_id, bookCaseId);
                    if (n > 0) response.sendRedirect("ContainController?action=show&bookCaseId=" + bookCaseId);
                    break;
                    
            }
        } catch (Exception ex) {
            Logger.getLogger(ContainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            int bookCaseId = (int) session.getAttribute("bookCaseId");
            ContainDAO containDao = new ContainDAO();
            int book_id = Integer.parseInt(request.getParameter("book_id"));
            int n = containDao.addContain(new Contain(bookCaseId, book_id, new Date()));
            if (n > 0) response.sendRedirect("ContainController?action=show&bookCaseId=" + bookCaseId);
        } catch (Exception ex) {
            Logger.getLogger(ContainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
