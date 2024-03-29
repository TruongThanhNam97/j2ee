
package dao;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Profile;

public class UserDAO {
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
//            conn = DriverManager.getConnection(DBConfig.url,DBConfig.user,DBConfig.password);
            conn = DriverManager.getConnection(DBConfig.url, pro);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return conn;
    }
    public static Profile getProfile(String emailOrPhone,String password)
    {
        Profile profile = null;
        String select = "select * from tbl_profile where email_mobile = ? and password = ?";
        try ( Connection c = openConnection() )
        {
            PreparedStatement ps = c.prepareStatement(select);
            ps.setString(1, emailOrPhone);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if ( rs.next() )
            {
                profile = new Profile(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"),rs.getString("email_mobile"),rs.getString("password"),rs.getString("birthday"),rs.getString("sex"));
            }
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
        return profile;
    }
    public static Profile getProfileByEmail(String emailOrPhone)
    {
        Profile profile = null;
        String select = "select * from tbl_profile where email_mobile = ?";
        try ( Connection c = openConnection() )
        {
            PreparedStatement ps = c.prepareStatement(select);
            ps.setString(1, emailOrPhone);
            ResultSet rs = ps.executeQuery();
            if ( rs.next() )
            {
                profile = new Profile(rs.getInt("id"),rs.getString("first_name"), rs.getString("last_name"),rs.getString("email_mobile"),rs.getString("password"),rs.getString("birthday"),rs.getString("sex"));
            }
        }
        catch ( Exception ex)
        {
            ex.printStackTrace();
        }
        return profile;
    }
    public static Profile checkLogin (String emailOrPhone, String password )
    {
        return getProfile(emailOrPhone, password);
    }
    public static boolean isDuplicateEmailOrPhone(String emailOrPhone)
    {
        try ( Connection c = openConnection() )
        {
            String select = "select id from tbl_profile where email_mobile = ?";
            PreparedStatement ps = c.prepareStatement(select);
            ps.setString(1, emailOrPhone);
            return ps.executeQuery().next();
        }
        catch ( Exception ex )
        {
            
        }
        return false;
    }
    public static boolean addNewUser(Profile profile)
    {
        try ( Connection c = openConnection() )
        {
            String insert = "insert into tbl_profile values(null,?,?,?,?,?,?,null)";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.setString(1, profile.getFirstName());
            ps.setString(2, profile.getLastName());
            ps.setString(3, profile.getEmailOrPhone());
            ps.setString(4, profile.getPassword());
            ps.setString(5, profile.getBirthday());
            ps.setString(6, profile.getSex());
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
    public static boolean updateUser ( Profile profile, String emailOrPhone )
    {
        try ( Connection c = openConnection() ) 
        {
            String update = "update tbl_profile set first_name=?, last_name=?, email_mobile=?, password=?, birthday=?, sex=? where email_mobile=?";
            PreparedStatement ps = c.prepareStatement(update);
            ps.setString(1, profile.getFirstName());
            ps.setString(2, profile.getLastName());
            ps.setString(3, profile.getEmailOrPhone());
            ps.setString(4, profile.getPassword());
            ps.setString(5, profile.getBirthday());
            ps.setString(6, profile.getSex());
            ps.setString(7, emailOrPhone);
            ps.executeUpdate();
            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public static byte[] getImageData( String emailOrPhone )
    {
        String select = "select avatar from tbl_profile where email_mobile = ?";
        try ( Connection c = openConnection(); PreparedStatement p = c.prepareStatement(select) )
        {
            p.setString(1, emailOrPhone);
            ResultSet rs = p.executeQuery();
            if ( rs.next() )
            {
                return rs.getBytes("avatar");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean updateUserAvatar(InputStream inputStream, String emailOrPhone)
    {
        String update = "update tbl_profile set avatar = ? where email_mobile = ? ";
        try ( Connection c = openConnection(); PreparedStatement p  = c.prepareStatement(update) ) 
        {
            p.setBlob(1, inputStream);
            p.setString(2, emailOrPhone);
            p.executeUpdate();
            return true;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return false;
    }
    public static Profile getProfileById(int id)
    {
        Profile profile = null;
        String select = "select * from tbl_profile where id=?";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if ( rs.next() )
            {
                profile = new Profile(rs.getInt("id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("email_mobile"),rs.getString("password"),rs.getString("birthday"),rs.getString("sex"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return profile;
    }
    public static List<Profile> getFriendList(int me)
    {
        List<Profile> list = new ArrayList<>();
        String select = "select friend_to from tbl_friends where me = ?";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) )
        {
            ps.setInt(1, me);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                int friendId = rs.getInt("friend_to");
                Profile profile = getProfileById(friendId);
                list.add(profile);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }
    public static List<Profile> getSuggestedFriend(int me)
    {
        List<Profile> list = new ArrayList<>();
        Profile profile = null;
        String select  = "select * from  tbl_profile where id != ? and id not in (select friend_to from tbl_friends where me=?)";
        try ( Connection c = openConnection(); PreparedStatement ps = c.prepareStatement(select) ) 
        {
            ps.setInt(1, me);
            ps.setInt(2, me);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                profile = new Profile(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email_mobile"),rs.getString("password"),rs.getString("birthday"),rs.getString("sex"));
                list.add(profile);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return list;
    }
    public static void addFriend(int me, int friend)
    {
        try ( Connection c = openConnection() )
        {
            String insert = "insert into tbl_friends values(null,?,?)";
            PreparedStatement ps = c.prepareStatement(insert);
            ps.setInt(1, me);
            ps.setInt(2, friend);
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void unFriend(int me, int friend)
    {
        try ( Connection c = openConnection() )
        {
            String delete = "delete from tbl_friends where me=? and friend_to=?";
            PreparedStatement ps = c.prepareStatement(delete);
            ps.setInt(1, me);
            ps.setInt(2, friend);
            ps.executeUpdate();
            ps.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
