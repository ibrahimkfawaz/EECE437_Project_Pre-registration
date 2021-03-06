package sample;

/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public abstract class User {
    private int id;
    protected String username;
    protected String password;
    protected String dept;
    public void setUsername(String username){this.username = username;}
    public String getUsername(){return username;}
    public void setPassword(String username){this.username = username;}
    public String getPassword(){return username;}
    public void setid(int id){this.id=id;}
    public int getid(){return this.id;}

    public void setDept(String dept)
    {
        this.dept = dept;
    }

    public String getDept(){
        return this.dept;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
