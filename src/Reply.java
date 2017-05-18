package sample;

/**
 * Created by Hasan Fakih on 4/27/2017.
 * represents a reply that has a replier and threadid (unique) and the message
 */
public class Reply {
//    private String replier;
    private User replier;
    private String threadid;
    private String message;

    public Reply(User replier, String threadid, String message) {
        this.replier = replier;
        this.threadid = threadid;
        this.message = message;
    }

    public void setReplier(User replier) {
        this.replier = replier;
    }

    public void setThreadid(String threadid) {
        this.threadid = threadid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getReplier() {
        return replier;
    }

    public String getThreadid() {
        return threadid;
    }

    public String getMessage() {
        return message;
    }
}
