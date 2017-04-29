package sample;

/**
 * Created by Hasan Fakih on 4/27/2017.
 */
public class Reply {
    private String replier;
    private String threadid;
    private String message;

    public Reply(String replier, String threadid, String message) {
        this.replier = replier;
        this.threadid = threadid;
        this.message = message;
    }

    public void setReplier(String replier) {
        this.replier = replier;
    }

    public void setThreadid(String threadid) {
        this.threadid = threadid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplier() {
        return replier;
    }

    public String getThreadid() {
        return threadid;
    }

    public String getMessage() {
        return message;
    }
}
