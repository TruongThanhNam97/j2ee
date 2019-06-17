
package model;

public class Comment {
    private int id;
    private int idpost;
    private int iduser;
    private String email_mobile;
    private String commenttext;
    private String username;
    private String commenttime;

    public Comment(int id, int idpost, int iduser, String email_mobile, String commenttext, String username, String commenttime) {
        this.id = id;
        this.idpost = idpost;
        this.iduser = iduser;
        this.email_mobile = email_mobile;
        this.commenttext = commenttext;
        this.username = username;
        this.commenttime = commenttime;
    }

    public Comment(int idpost, int iduser, String email_mobile, String commenttext, String username, String commenttime) {
        this.idpost = idpost;
        this.iduser = iduser;
        this.email_mobile = email_mobile;
        this.commenttext = commenttext;
        this.username = username;
        this.commenttime = commenttime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getEmail_mobile() {
        return email_mobile;
    }

    public void setEmail_mobile(String email_mobile) {
        this.email_mobile = email_mobile;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime;
    }
    
}
