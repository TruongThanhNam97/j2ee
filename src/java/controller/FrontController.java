
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dis = null;
        String action = request.getParameter("action");
        if ( action.equals("Login") )
        {
            dis = request.getRequestDispatcher("ProcessLogin");
            dis.forward(request, response);
        }
        else if ( action.equals("Register") )
        {
            dis = request.getRequestDispatcher("ProcessRegister");
            dis.forward(request, response);
        }
        else if ( action.equals("view-profile"))
        {
            response.sendRedirect("ProcessProfile");
        }
        else if ( action.equals("update-profile") )
        {
            dis = request.getRequestDispatcher("ProcessProfile");
            dis.forward(request, response);
        }
        else if ( action.equals("add-post") )
        {
            dis = request.getRequestDispatcher("ProcessAddPost");
            dis.forward(request, response);
        }
        else if ( action.equals("news-feed") )
        {
            response.sendRedirect("ProcessNewsFeed");
        }
        else
        {
            response.sendRedirect("./");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
