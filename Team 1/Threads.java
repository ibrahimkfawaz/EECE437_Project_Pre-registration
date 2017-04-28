package sample;

import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/27/2017.
 */
public class Threads {
    private String title;
    private int titleid;
    private String message;
    private String initiator;
    private ArrayList<Reply> replies = new ArrayList<>();

    public Threads(){}

    public Threads(String title,int titleid, String message,String initiator){
        this.title= title;
        this.titleid = titleid;
        this.message = message;
        this.initiator = initiator;
    }

    public String getMessage() {
        return message;
    }

    public String getInitiator() {
        return initiator;
    }

    public ArrayList<Reply> getReplies() {
        return replies;
    }

    public  Threads(int tittleid){
        this.titleid = tittleid;
    }

    public void setReplies(ArrayList<Reply> replies) {
        this.replies = replies;
    }

    public String getTitle(){
        return this.title;
    }

    public int getTitleid() {
        return titleid;
    }
}
