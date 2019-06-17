
package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Post;

public class PostDAO {
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
    public static boolean addPost(Post post,InputStream inputStream)
    {
        try ( Connection c = openConnection() )
        {
            String insert = "insert into tbl_posts values(null,?,?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.setInt(1, post.getIduser());
            ps.setString(2, post.getUsername());
            ps.setBytes(3, post.getUseravatar());
            ps.setString(4, post.getPosttext());
            ps.setBlob(5, inputStream);
            ps.setString(6, post.getEmail_mobile());
            ps.setString(7, post.getPosttime());
            ps.executeUpdate();
            ps.close();
            return true;
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
    public static List<Post> getPostList()
    {
        List<Post> list = new ArrayList<>();
        String select = "select * from tbl_posts";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                Post profile = new Post(rs.getInt("id"),rs.getInt("iduser"), rs.getString("username"),rs.getBytes("useravatar"), rs.getString("posttext"),rs.getBytes("postimage"),rs.getString("email_mobile"),rs.getString("posttime"));
                list.add(profile);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }
    public static byte[] getImageData( int id )
    {
        String select = "select postimage from tbl_posts where id = ?";
        try ( Connection c = openConnection(); PreparedStatement p = c.prepareStatement(select) )
        {
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if ( rs.next() )
            {
                return rs.getBytes("postimage");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    public static void deletePost(int id)
    {
        try ( Connection c = openConnection() )
        {
            String delete = "delete from tbl_posts where id=?";
            PreparedStatement ps = c.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
