
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Like;

public class LikeDAO {
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
    public static void addLike(int idpost,int iduser)
    {
        try ( Connection c = openConnection() )
        {
            String insert = "insert into tbl_likes values(null,?,?)";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.setInt(1, idpost);
            ps.setInt(2, iduser);
            ps.executeUpdate();
            ps.close();
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void deleteLike(int idpost,int iduser)
    {
        try ( Connection c = openConnection() )
        {
            String delete = "delete from tbl_likes where idpost=? and iduser=?";
            PreparedStatement ps = c.prepareStatement(delete);
            ps.setInt(1, idpost);
            ps.setInt(2, iduser);
            ps.executeUpdate();
            ps.close();
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static int getLike(int idpost)
    {
        List<Like> list = new ArrayList<>();
        String select = "select * from tbl_likes where idpost=?";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ps.setInt(1, idpost);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                Like profile = new Like(rs.getInt("id"),rs.getInt("idpost"), rs.getInt("iduser"));
                list.add(profile);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list.size();
    }
    public static boolean checkLiked(int idpost,int iduser)
    {
        String select = "select * from tbl_likes where idpost=? and iduser=?";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ps.setInt(1, idpost);
            ps.setInt(2, iduser);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
               return true;
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
}
