package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BackgroundPosition;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/1/2017.
 */
public class RegisterController {
    private Main main;
    private Student student;
    private StudentPageController s;
    private LoginController l;
    private Course c;
    @FXML
    private TableView<Course> availablecourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> Coursename;
    @FXML
    private TableColumn<Course, String> CourseTime;
    @FXML
    private TableColumn<Course, String> Coursedesc;

    private ObservableList<Course> data;
    private ObservableList<Course> co;
    public void setMain(Main main,Student stud,String dept,StudentPageController s,LoginController l,ObservableList<Course> co){
        Coursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        CourseTime.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        Coursedesc.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseDesc"));
        this.main=main;
        this.student=stud;
        this.s=s;
        this.l=l;
        this.co=co;
        data = FXCollections.observableArrayList();
        co = FXCollections.observableArrayList();
        try{
            main.outToServer.writeBytes("getOffered"+"\n");
            main.outToServer.writeBytes(dept+"\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            System.out.println(count);

            for(int i=0;i<count;i++)
            {
                Course c = new Course();
                c.setCourseCode(main.inFromServer.readLine());
                c.setCourseDesc(main.inFromServer.readLine());
                c.setTime_slot(main.inFromServer.readLine());
                c.setAssigned_slot(c.parseslot(c.getTime_slot()));
                data.add(i,c);

            }

            availablecourses.setItems(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void OnBackClicked(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Student.fxml"));
            AnchorPane student = (AnchorPane) loader.load();


            s = loader.getController();
            s.setMain(this.main,this.student,this.l);
           // s.update(co);

            main.rootLayout.setCenter(student);
        }catch (IOException e){

        }

    }

    public void OnPreregisterClicked(){
        c = availablecourses.getSelectionModel().getSelectedItem();
        String s = c.getAssigned_slot().getStart();
        String e = c.getAssigned_slot().getEnd();
        System.out.println(s);
        System.out.println(e);
        boolean flag=false;
        int start = Integer.parseInt(s);
        int end = Integer.parseInt(e);
        for(int i =0;i<co.size();i++){
            if(Integer.parseInt(co.get(i).getAssigned_slot().getStart())==start ||
               Integer.parseInt(co.get(i).getAssigned_slot().getEnd())==end ) {
                flag = true;
                JOptionPane.showMessageDialog(null, "Time Conflict", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(!flag) {
            student.addPre_reg(c);
            student.SaveCourses();
            c.addpre_reg(student);
            co.add(c);
            try{
                main.outToServer.writeBytes("increasecap"+"\n"+c.getCourseCode()+"\n");
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }

   }
}
