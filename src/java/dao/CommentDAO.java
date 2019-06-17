
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Comment;

public class CommentDAO {
    public static Connection openConnection()
    {
        Connection conn = null;
        try
        {
            Class.forName(DBConfig.driver);
            Properties pro = new Properties();
            pro.setProperty("user",DBConfig.user);
            pro.setProperty("password",DBConfig.password);
            pro.setProperty("useSSL", "false");
            conn = DriverManager.getConnection(DBConfig.url, pro);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
    public static void addComment(Comment comment)
    {
        try ( Connection c = openConnection() )
        {
            String insert = "insert into tbl_comments values(null,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.setInt(1, comment.getIdpost());
            ps.setInt(2, comment.getIduser());
            ps.setString(3, comment.getEmail_mobile());
            ps.setString(4, comment.getCommenttext());
            ps.setString(5, comment.getUsername());
            ps.setString(6, comment.getCommenttime());
            ps.executeUpdate();
            ps.close();
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static List<Comment> getCommentList(int idpost)
    {
        List<Comment> list = new ArrayList<>();
        String select = "select * from tbl_comments where idpost = ?";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ps.setInt(1, idpost);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                Comment comment = new Comment(rs.getInt("id"),rs.getInt("idpost"), rs.getInt("iduser"),rs.getString("email_mobile"),rs.getString("commenttext"),rs.getString("username"),rs.getString("commenttime"));
                list.add(comment);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }
    public static void deleteComment(int idComment)
    {
        try ( Connection c = openConnection() )
        {
            String delete = "delete from tbl_comments where id=?";
            PreparedStatement ps = c.prepareStatement(delete);
            ps.setInt(1, idComment);
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
