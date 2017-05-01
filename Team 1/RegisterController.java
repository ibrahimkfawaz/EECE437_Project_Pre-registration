package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/1/2017.
 */
public class RegisterController {
    private Main main;
    private Student student;
    private StudentPageController s;
    @FXML
    private TableView<Course> availablecourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> Coursename;
    @FXML
    private TableColumn<Course, String> CourseTime;
    @FXML
    private TableColumn<Course, String> Coursedesc;

    private ObservableList<Course> data;

    public void setMain(Main main,Student stud,String dept,StudentPageController s){
        Coursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        CourseTime.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        Coursedesc.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseDesc"));
        this.main=main;
        this.student=stud;
        this.s=s;
        data = FXCollections.observableArrayList();
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
                data.add(i,c);

            }

            availablecourses.setItems(data);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void OnBackClicked(){
        LoginController l = new LoginController();
        l.showStudent(this.student,this.main,this.s);
    }

    public void OnPreregisterClicked(){

    }
}
