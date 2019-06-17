package controller;

import dao.PostDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.Post;
import model.Profile;
import ultil.DateTime;


@MultipartConfig(maxFileSize = 1000000000)
public class ProcessAddPost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession sess = request.getSession();
        Profile profile = (Profile) sess.getAttribute("user");
        int iduser = profile.getId();
        String username = profile.getLastName()+" "+profile.getFirstName();
        byte[] useravatar = UserDAO.getImageData(profile.getEmailOrPhone());
        String posttext = request.getParameter("posttext");
        InputStream inputStream = null;
        Part filePart = request.getPart("postimage");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        String email_mobile = profile.getEmailOrPhone();
        String posttime = DateTime.getDateTimeNow();
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/news-feed.jsp");
        if (posttext == null || posttext.trim().equals("") || posttext.equals("")) {
            sess.setAttribute("error", "This post have no text !");
            response.sendRedirect("ProcessNewsFeed");
        } else {
            sess.setAttribute("error", "");
            Post post = new Post(0, iduser, username, useravatar, posttext, email_mobile,posttime);
            boolean result = PostDAO.addPost(post, inputStream);
            response.sendRedirect("ProcessNewsFeed");
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
