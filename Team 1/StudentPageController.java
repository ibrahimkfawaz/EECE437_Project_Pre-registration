package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Hasan Fakih on 4/16/2017.
 */
public class StudentPageController extends PageController {
    private Student localstudent= new Student();
    private LoginController l;
    private ArrayList<Course> my_courses= new ArrayList<>();
    private Main main;

    @FXML
    private ListView<String> depts = new ListView<>();

    @FXML
    private TableView<Course> mycourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> myCoursename;
    @FXML
    private TableColumn<Course, String> myCoursetime;
    @FXML
    private TableColumn<Petition, String> status;
    @FXML
    private TableColumn<Petition, String> type;
    @FXML
    private TableColumn<Petition, String> details;
    @FXML
    private TableView<Petition> petitions;

    @FXML
    private Button Drop;

    private ObservableList<Course> data;
    private ObservableList<Petition> data1;


    public void setMain(Main main,Student stud,LoginController l){
        this.main= main;
        this.localstudent = stud;
        this.l=l;
        depts.getItems().addAll("EECE","MECH","CIVE","INDE","CHEN","PSPA","PHIL","PHYS","CHEM","BIOL","HIST","GEOL","DCSN","ACCT","FINA");
        myCoursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        myCoursetime.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        status.setCellValueFactory(new PropertyValueFactory<Petition, String>("status"));
        type.setCellValueFactory(new PropertyValueFactory<Petition, String>("type"));
        details.setCellValueFactory(new PropertyValueFactory<Petition, String>("details"));
        data1 = FXCollections.observableArrayList();
        data = FXCollections.observableArrayList();

        my_courses = localstudent.getPre_reg();

            for (int i = 0; i < my_courses.size(); i++) {
                Course c = my_courses.get(i);
                data.add(c);
            }
        mycourses.setItems(data);
        showPetition();
    }

    public void onLogoutClicked(){
//        this.main.showLogin();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Login.fxml"));
            AnchorPane Login = (AnchorPane) loader.load();

            main.rootLayout.setCenter(Login);


            LoginController controller = loader.getController();
            controller.setMain(this.main);
        }catch (IOException e){

        }
    }

    public void onCheckClicked() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Register.fxml"));
            AnchorPane forum = (AnchorPane) loader.load();

            main.rootLayout.setCenter(forum);

            RegisterController controller = loader.getController();
            controller.setMain(this.main, this.localstudent,depts.getSelectionModel().getSelectedItem(),this,l,this.data);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(Course c){
        for(int i =0;i<data.size();i++){
            if(data.get(i).equals(c)){
                data.remove(c);
            }
        }

        mycourses.setItems(data);
    }

    public void addpetition(Petition p){
        data1.add(p);

        petitions.setItems(data1);
    }

    public void OnDropClicked(){
        Course c = mycourses.getSelectionModel().getSelectedItem();
        my_courses.remove(c);
        localstudent.setPre_reg(my_courses);
        localstudent.SaveCourses();
        update(c);
        try{
            main.outToServer.writeBytes("decreasecap"+"\n"+c.getCourseCode()+"\n");
        }catch (IOException e1){
            e1.printStackTrace();
        }

    }

    public void showPetition() {
        try {
            main.outToServer.writeBytes("getMyPetitions"+"\n"+this.localstudent.getUsername()+"\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            for (int i = 0; i < count; i++) {
                Petition p = new Petition();
                p.setDept(this.localstudent.getDept());
                p.setType(main.inFromServer.readLine());
                p.setDetails(main.inFromServer.readLine());
                p.setStatus(main.inFromServer.readLine());
                data1.add(i, p);

            }

            petitions.setItems(data1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnCleanClicked(){
        try {
            main.outToServer.writeBytes("CleanMyPetitions" + "\n" + this.localstudent.getUsername() + "\n");
        }catch (IOException e){
            e.printStackTrace();
        }
        for(int i=0;i<data1.size();i++){
            if(data1.get(i).getStatus().equals("accepted") || data1.get(i).getStatus().equals("rejected"))
                data1.remove(data1.get(i));
        }
        petitions.setItems(data1);

    }

    public void onNewPetitionClicked() {
        try {
            Stage petition = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Petition.fxml"));
            AnchorPane newpetition = (AnchorPane) loader.load();
            NewPetitionController controller = loader.getController();
            controller.setMain(this.main,this.localstudent,petition,this);
            Scene scene = new Scene(newpetition);
            petition.setScene(scene);
            petition.setTitle("message");
            petition.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }



    public void onForumClicked(){
            showforum(this.main,this.localstudent,this);
    }


}
