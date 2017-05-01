package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;

import static sample.Days.*;
import static sample.Days.F;

/**
 * Created by Hasan Fakih on 4/30/2017.
 */
public class ModifyCourseController {
    private  Course course = new Course();
    private Main main;
    private ProfessorPageController pc;

    @FXML
    private TextField coursename;

    @FXML
    private TextField coursecode;

    @FXML
    private TextArea coursedesc;

    @FXML
    private TextField days;

    @FXML
    private TextField start;

    @FXML
    private TextField end;


    @FXML
    private TextField duration;

    @FXML
    private TextField am_pm;

    public void setMain(Main main,Course course,ProfessorPageController pc){
        this.course=course;
        this.main=main;
        this.pc=pc;
        coursecode.setText(course.getCourseCode());
        coursename.setText(course.getCourseName());
        coursedesc.setText(course.getCourseDesc());
//        if(course.getAssigned_slot().getD().equals(MWF))
//        days.setText("MWF");
//        else
//            days.setText("MWF");
//        start.setText(course.getAssigned_slot().getStart());
//        end.setText(course.getAssigned_slot().getEnd());
//        duration.setText(Integer.toString(course.getAssigned_slot().getDuration()));
//        am_pm.setText(course.getAssigned_slot().getAm_pm());

    }

    public void onModifyClicked(){
        TimeSlot t=new TimeSlot();
        boolean f = false;
        //TODO: take care of correct format


        if(coursecode.getText().equals("") || coursedesc.getText().equals("") ||  start.getText().equals("") || end.getText().equals("") ||
                coursename.getText().equals("") ||  am_pm.getText().equals("") || days.getText().equals(""))
        {
            f = true;
            JOptionPane.showMessageDialog(null,"Please fill all the fields ", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }

        switch(days.getText()) {
            case "MWF":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), MWF);
                break;
            case "MW":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), MW);
                break;
            case "TR":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), TR);
                break;
            case "M":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), M);
                break;
            case "T":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), T);
                break;
            case "W":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), W);
                break;
            case "R":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), R);
                break;
            case "F":
                t = new TimeSlot(Integer.parseInt(duration.getText()), start.getText(), end.getText(),am_pm.getText(), F);
                break;
            default:
                f = true;
                JOptionPane.showMessageDialog(null, "Days format is M/T/W/R/F/MWF/MW/TR", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }


         if(f==false){
            course.setCourseCode(coursecode.getText());
            course.setCourseDesc(coursedesc.getText());
            course.setCourseName(coursename.getText());
            course.setTime_slot(days.getText()+" @ "+ start.getText() + " to " + end.getText());
            course.setAssigned_slot(t);
            pc.modify(course);

        }
    }

}

