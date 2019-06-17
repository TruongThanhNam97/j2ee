
package model;

public class Post {
    private int id;
    private int iduser;
    private String username;
    private byte[] useravatar;
    private String posttext;
    private byte[] postimage;
    private String email_mobile;
    private String posttime;

    public Post(int id, int iduser, String username, byte[] useravatar, String posttext, String email_mobile,String posttime) {
        this.id = id;
        this.iduser = iduser;
        this.username = username;
        this.useravatar = useravatar;
        this.posttext = posttext;
        this.email_mobile = email_mobile;
        this.posttime = posttime;
    }

    public Post(int id, int iduser, String username, byte[] useravatar, String posttext, byte[] postimage, String email_mobile,String posttime) {
        this.id = id;
        this.iduser = iduser;
        this.username = username;
        this.useravatar = useravatar;
        this.posttext = posttext;
        this.postimage = postimage;
        this.email_mobile = email_mobile;
        this.posttime = posttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getUseravatar() {
        return useravatar;
    }

    public void setUseravatar(byte[] useravatar) {
        this.useravatar = useravatar;
    }

    public String getPosttext() {
        return posttext;
    }

    public void setPosttext(String posttext) {
        this.posttext = posttext;
    }

    public byte[] getPostimage() {
        return postimage;
    }

    public void setPostimage(byte[] postimage) {
        this.postimage = postimage;
    }

    public String getEmail_mobile() {
        return email_mobile;
    }

    public void setEmail_mobile(String email_mobile) {
        this.email_mobile = email_mobile;
    }

    public String getPosttime() {
        return posttime;
    }

    public void setPosttime(String posttime) {
        this.posttime = posttime;
    }
    
}
