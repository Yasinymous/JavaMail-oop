package user;

public class User {
    private int uid;
    private String username;
    private String mail;
    private boolean status;

    public User(){
    }

    public User(int uid, String username, String mail, boolean status) {
        this.uid = uid;
        this.username = username;
        this.mail = mail;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

