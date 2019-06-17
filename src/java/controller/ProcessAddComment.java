package controller;

import dao.CommentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Comment;
import model.Profile;
import ultil.DateTime;

public class ProcessAddComment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String commenttext = request.getParameter("commenttext");
        if (commenttext.trim().equals("") == false) 
        {
            int idpost = Integer.parseInt(request.getParameter("idpost"));
            HttpSession ses = request.getSession();
            Profile current = (Profile) ses.getAttribute("user");
            int idUser = current.getId();
            String email_mobile = current.getEmailOrPhone();
            String username = current.getLastName() + " " + current.getFirstName();
            String commenttime = DateTime.getDateTimeNow();
            Comment cm = new Comment(idpost, idUser, email_mobile, commenttext, username, commenttime);
            CommentDAO.addComment(cm);
            List<Comment> commentList = CommentDAO.getCommentList(idpost);
            request.setAttribute("commentList", commentList);
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/comment-list.jsp");
            dis.forward(request, response);
        } 
        else 
        {
            int idpost = Integer.parseInt(request.getParameter("idpost"));
            List<Comment> commentList = CommentDAO.getCommentList(idpost);
            request.setAttribute("commentList", commentList);
            RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/comment-list.jsp");
            dis.forward(request, response);
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
