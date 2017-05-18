package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 4/17/2017.
 */
public class NewMessageController {
    private Main main;
    private String msg;
    private String t;
    private User localuser;
    private String Status;
    private Stage  stage;
//    private Student localstudent;
//    private Professor localprofessor;
//    private Admin localadmin;

    @FXML
    private TextField title;

    @FXML
    private TextArea message;

    public void setMain(Main main,User user,Stage stage){
        this.stage=stage;
        this.main = main;
        this.localuser = user;
//        if(user instanceof Student)
//            this.localuser = (Student) user;
//        else if(user instanceof Professor)
//            this.localprofessor = (Professor) user;
//        else
//            this.localadmin = (Admin) user;

    }
    public void onSendClicked(){
        if(title.getText().equals(null) || message.getText().equals(null))
            JOptionPane.showMessageDialog(null,"The title and message can't be empty", "Notification", JOptionPane.INFORMATION_MESSAGE);

        else{
            try{
                main.outToServer.writeBytes("setNewThread\n");
                main.outToServer.writeBytes(message.getText()+"\n");
                main.outToServer.writeBytes(title.getText() + "\n");
                main.outToServer.writeBytes(localuser.getUsername() + "\n");
                Status = main.inFromServer.readLine();
                if(Status.equals("Success"))
                {
                    JOptionPane.showMessageDialog(null,"Sending Succeeded", "Notification", JOptionPane.INFORMATION_MESSAGE);

                }else
                {
                    JOptionPane.showMessageDialog(null,"Sending Failed", "Notification", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(IOException e)
            {
                e.printStackTrace();
            }

        }


    }
}
