package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 4/27/2017.
 */
public class ReplyController {
    private Main main;
    private User localuser;
    private Threads t;
    ThreadsController tc;
    @FXML
    private TextArea message;

    @FXML
    private Button send;


    public void setMain(Main main, User user,Threads t,ThreadsController tc){
        this.localuser = user;
        this.main = main;
        this.t = t;
        this.tc=tc;
    }

    public void OnSendCLicked(){
        try {
            if(message.getText().equals(null))
            {
                JOptionPane.showMessageDialog(null,"Please enter some text in the message", "Notification", JOptionPane.INFORMATION_MESSAGE);

            }
            Reply  r = new Reply(localuser.getUsername(),t.getTitle()+Integer.toString(t.getTitleid()),message.getText());
            main.outToServer.writeBytes("replyToThread"+"\n");
            main.outToServer.writeBytes(r.getThreadid()+"\n");
            main.outToServer.writeBytes(r.getReplier()+"\n");
            main.outToServer.writeBytes(r.getMessage()+"\n");

            if(main.inFromServer.readLine().equals("Success"))
            {
                JOptionPane.showMessageDialog(null,"Message sent", "Notification", JOptionPane.INFORMATION_MESSAGE);
                tc.update(r);
            }
            else
                JOptionPane.showMessageDialog(null,"Something went wrong, Please try again", "Notification", JOptionPane.INFORMATION_MESSAGE);





        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
