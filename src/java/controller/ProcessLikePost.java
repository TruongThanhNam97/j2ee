
package controller;

import com.google.gson.Gson;
import dao.LikeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Profile;

public class ProcessLikePost extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession ses = request.getSession();
        Profile currentUser = (Profile)ses.getAttribute("user");
        int idPost = Integer.parseInt(request.getParameter("idPost"));
        boolean checkLiked = LikeDAO.checkLiked(idPost, currentUser.getId());
        if ( checkLiked )
        {
            LikeDAO.deleteLike(idPost,currentUser.getId());
        }
        else
        {
            LikeDAO.addLike(idPost,currentUser.getId());
        }
        int likes = LikeDAO.getLike(idPost);
        Map<String,String> options = new LinkedHashMap<>();
        options.put("likes", likes+"");
        if ( checkLiked )
        {
            options.put("checkLiked","nolike");
        }
        else
        {
            options.put("checkLiked","liked");
        }
        String json = new Gson().toJson(options);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
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
