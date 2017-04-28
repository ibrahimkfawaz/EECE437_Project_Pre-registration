package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/27/2017.
 */
public class ThreadsController {
    private Main main;
    private Threads thisthread;
    private ArrayList<Reply> replies = new ArrayList<>();
    private User localuser;
    private String replier;
    private String threadid;
    private String message;
    private int count;


    @FXML
    private TextArea texts;

    @FXML
    private Button reply;


    public void setMain(Main main, Threads t,User user) {
        this.thisthread = t;
        this.localuser = user;
        texts.setEditable(false);
        texts.setMouseTransparent(true);
        texts.setFocusTraversable(false);
        texts.setText(t.getInitiator()+":" + "\n" + t.getMessage()+"\n");
        this.main = main;
        try {
            main.outToServer.writeBytes("getReplies" + "\n");
            main.outToServer.writeBytes(t.getTitle() + Integer.toString(t.getTitleid()) + "\n");
            count = Integer.parseInt(main.inFromServer.readLine());

            for (int i = 0; i < count; i++) {

                threadid = main.inFromServer.readLine();
                replier = main.inFromServer.readLine();
                message = main.inFromServer.readLine();

                replies.add(i, new Reply(replier, threadid, message));
                t.setReplies(replies);

                texts.setText(texts.getText() + "\n" + replier + " :" + "\n" + message + "\n");

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnReplyClicked() {
        try {
            Stage thread = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Reply.fxml"));
            AnchorPane r = (AnchorPane) loader.load();
            ReplyController controller = loader.getController();
            controller.setMain(this.main,this.localuser,this.thisthread,this);
            Scene scene = new Scene(r);
            thread.setScene(scene);
            thread.setTitle(this.thisthread.getTitle());
            thread.show();
        }catch (IOException e){

        }
    }

    public void update(Reply r){
        this.texts.setText(this.texts.getText() + "\n" + r.getReplier() + " :" + "\n" + r.getMessage() + "\n");
    }

}