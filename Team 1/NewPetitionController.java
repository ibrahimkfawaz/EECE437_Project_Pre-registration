package sample;

import com.sun.deploy.panel.RadioPropertyGroup;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/16/2017.
 */
public class NewPetitionController {
    private Main main;
    private String det;
    private String type;
    private User localuser;
    private String Status;
    private Stage stage;
    private StudentPageController pc;

    @FXML
    private RadioButton overload;

    @FXML
    private RadioButton underload;

    @FXML
    private RadioButton equivalence;

    @FXML
    private TextArea details;

    private ToggleGroup t=new ToggleGroup();


    public void setMain(Main main,User user,Stage stage,StudentPageController pc){
        this.overload.setToggleGroup(t);
        this.underload.setToggleGroup(t);
        this.equivalence.setToggleGroup(t);
        this.stage=stage;
        this.main = main;
        this.localuser = user;
        this.pc=pc;
    }

    public void OnSubmitClicked(){
        if(((!overload.isSelected()) && (!underload.isSelected())) && (!equivalence.isSelected()))
        {
            JOptionPane.showMessageDialog(null,"Please Select if you are a petition type", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(overload.isSelected()){
            type = "Overload";
        }
        else if(underload.isSelected()){
            type = "Underload";
        }
        else
            type = "Course Equivalence";
        try {
            main.outToServer.writeBytes("newPetition"+"\n");
            main.outToServer.writeBytes(type+"\n");
            main.outToServer.writeBytes(localuser.getUsername()+"\n");
            main.outToServer.writeBytes(localuser.getDept()+"\n");
            main.outToServer.writeBytes(details.getText()+"\n");
            Status = main.inFromServer.readLine();
            if(Status.equals("Success"))
            {
                JOptionPane.showMessageDialog(null,"Submitting Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
                Petition p = new Petition();
                p.setType(type);
                p.setDetails(details.getText());
                p.setStatus("pending");
                pc.addpetition(p);

            }else
            {
                JOptionPane.showMessageDialog(null,"Submitting Failed", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
