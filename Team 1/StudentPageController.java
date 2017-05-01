package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 4/16/2017.
 */
public class StudentPageController extends PageController {
    Student localstudent= new Student();
    private Main main;

    @FXML
    private ListView<String> depts = new ListView<>();

    @FXML
    private TableView<Course> mycourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> myCoursename;
    @FXML
    private TableColumn<Course, String> myCoursetime;

    private ObservableList<Course> data;


    public void setMain(Main main,Student stud){
        this.main= main;
        this.localstudent = stud;
        depts.getItems().addAll("EECE","MECH","CIVE","INDE","CHEN","PSPA","PHIL","PHYS","CHEM","BIOL","HIST","GEOL","DCSN","ACCT","FINA");
        myCoursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        myCoursetime.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        //TODO


    }

    public void onLogoutClicked(){
        main.showLogin();
    }

    public void onCheckClicked() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Register.fxml"));
            AnchorPane forum = (AnchorPane) loader.load();

            main.rootLayout.setCenter(forum);

            RegisterController controller = loader.getController();
            controller.setMain(this.main, this.localstudent,depts.getSelectionModel().getSelectedItem(),this);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(){
        //TODO update my courses
    }


    public void onForumClicked(){
            showforum();
    }

    public void showforum(){ //TODO: move this to a separate class.
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Forum.fxml"));
            AnchorPane forum = (AnchorPane) loader.load();

            main.rootLayout.setCenter(forum);

            ForumController controller = loader.getController();
            controller.setMain(this.main,this.localstudent,this);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
