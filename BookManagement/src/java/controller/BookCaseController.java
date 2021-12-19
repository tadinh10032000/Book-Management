/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.BookCase;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.BookCaseDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * s
 *
 * @author NHD
 */
@WebServlet(name = "BookCaseController", urlPatterns = {"/BookCaseController"})
public class BookCaseController extends HttpServlet {

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
            BookCaseDAO bookCaseDao = new BookCaseDAO();
            String action = request.getParameter("action");
            RequestDispatcher rd = null;

            HttpSession session = request.getSession();
            Integer id = (Integer) session.getAttribute("id");
            if (id == null) {
                id = 4;
                session.setAttribute("id", id);
            }
            switch (action) {
                case "show":
                    List<BookCase> bookCases = null;
                    bookCases = bookCaseDao.getBookCasesById(id);
                    request.setAttribute("listBookCase", bookCases);
                    request.getRequestDispatcher("showBookCase.jsp").forward(request, response);
                    break;
                case "add":
                    response.sendRedirect("addBookCase.jsp");
                    break;
                case "delete":
                    int bookCaseId = Integer.parseInt(request.getParameter("bookCaseId"));
                    int n = bookCaseDao.deleteBookCaseByBookCaseId(bookCaseId);
                    if (n > 0) {
                        response.sendRedirect("BookCaseController?action=show");
                    }
                    break;
                default:

            }
        } catch (Exception ex) {
            Logger.getLogger(BookCaseController.class.getName()).log(Level.SEVERE, null, ex);
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
            int id = (int) session.getAttribute("id");

            String booCaseName = request.getParameter("bookCaseName");
            BookCase bookCase = new BookCase(id, booCaseName);
            BookCaseDAO bookCaseDAO = new BookCaseDAO();
            int n = bookCaseDAO.addBookCase(bookCase);
            if (n > 0) {
                response.sendRedirect("BookCaseController?action=show");
            }
        } catch (Exception ex) {
            Logger.getLogger(BookCaseController.class.getName()).log(Level.SEVERE, null, ex);
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
