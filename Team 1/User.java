package sample;

/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public abstract class User {
    private int id;
    private String username;
    private String password;
    public void setUsername(String username){this.username = username;}
    public void getUsername(String username){this.username = username;}
    public void setPassword(String username){this.username = username;}
    public void getPassword(String username){this.username = username;}
    public void setid(int id){this.id=id;}
    public int getid(){return this.id;}
}
