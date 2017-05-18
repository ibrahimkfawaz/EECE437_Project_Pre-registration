package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.List;

import static sample.Days.*;

/**
 * Created by Hasan Fakih on 4/29/2017.
 */
public class NewCourseController {
    private Professor localprofessor;
    private Main main;
    private Course proposedcourse = new Course();
    private ProfessorPageController pc;

    @FXML
    private TextField coursename;

    @FXML
    private TextField coursecode;

    @FXML
    private TextField duration;

    @FXML
    private TextArea coursedesc;

    @FXML
    private TextField days;

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private TextField am_pm;

    public void setMain(Main main,Professor professor, ProfessorPageController pc) {
        this.main = main;
        this.localprofessor = professor;
        this.pc=pc;
    }

    public void onProposeClicked(){
        boolean flag=false;
        //TODO: take care of correct format

        if(coursecode.getText().equals("") || coursedesc.getText().equals("") ||  start.getText().equals("") || end.getText().equals("") ||
                coursename.getText().equals("") ||  am_pm.getText().equals("") || days.getText().equals(""))
        {
            flag = true;
            JOptionPane.showMessageDialog(null,"Please fill all the fields ", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }

        switch(days.getText()) {
            case "MWF":
                break;
            case "MW":
                break;
            case "TR":
                break;
            case "M":
                break;
            case "T":
                break;
            case "W":
                break;
            case "R":
                break;
            case "F":
                break;
            default:
                flag = true;
                JOptionPane.showMessageDialog(null, "Days format is M/T/W/R/F/MWF/MW/TR", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }


        if(flag==false){
            proposedcourse.setCourseCode(coursecode.getText());
            proposedcourse.setCourseDesc(coursedesc.getText());
            proposedcourse.setCourseName(coursename.getText());
            proposedcourse.setTime_slot(days.getText()+" @ "+ start.getText() + " to " + end.getText());
            proposedcourse.setInstructor(this.localprofessor);
            pc.update(proposedcourse);

            //TODO: update catalog



        }
    }
}
