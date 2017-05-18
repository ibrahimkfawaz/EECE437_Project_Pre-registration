package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.CORBA.PERSIST_STORE;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/11/2017.
 */
public class AdminPageController extends PageController {
    private Main main;
    private Admin localadmin;

    @FXML
    private TableColumn<Course, String> allCoursename;
    @FXML
    private TableColumn<Course, String> allCoursedesc;
    @FXML
    private TableView<Course> allcourses;

    @FXML
    private TableColumn<Petition, String> petitioner;
    @FXML
    private TableColumn<Petition, String> type;
    @FXML
    private TableColumn<Petition, String> details;
    @FXML
    private TableView<Petition> petitions;

    @FXML
    private TableColumn<Course, String> coursename;
    @FXML
    private TableColumn<Course, String> coursecap;
    @FXML
    private TableColumn<Course, String> time;
    @FXML
    private TableColumn<Course, String> room;
    @FXML
    private TableView<Course> courses;

    ObservableList<Course> data;
    ObservableList<Petition> data1;
    ObservableList<Course> data2;

    public void setMain(Main main,Admin admin){
        this.main= main;
        this.localadmin = admin;
        allCoursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        allCoursedesc.setCellValueFactory(new PropertyValueFactory<Course, String>("courseDesc"));
        coursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        coursecap.setCellValueFactory(new PropertyValueFactory<Course, String>("coursecap"));
        room.setCellValueFactory(new PropertyValueFactory<Course, String>("room"));
        time.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        petitioner.setCellValueFactory(new PropertyValueFactory<Petition, String>("petitioner"));
        type.setCellValueFactory(new PropertyValueFactory<Petition, String>("type"));
        details.setCellValueFactory(new PropertyValueFactory<Petition, String>("details"));

        data1 = FXCollections.observableArrayList();
        data = FXCollections.observableArrayList();
        data2 =  FXCollections.observableArrayList();
        try{

            main.outToServer.writeBytes("getCatalog"+"\n");
            showCatalog(this.main,allcourses,data);
            showPetition();
            showCourses();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnRemoveClicked(){
        Course coursetoremove = allcourses.getSelectionModel().getSelectedItem();
        data.remove(coursetoremove);
        allcourses.setItems(data);
        try {
            main.outToServer.writeBytes("deleteCoursecat"+"\n");
            main.outToServer.writeBytes(coursetoremove.getCourseCode()+"\n");
            if(main.inFromServer.readLine().equals("Success")){
                JOptionPane.showMessageDialog(null,"Deleted Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OnAcceptClicked(){
        Petition acceptedpetition = petitions.getSelectionModel().getSelectedItem();
        acceptedpetition.setAccpeted(true);
        data1.remove(acceptedpetition);
        petitions.setItems(data1);
        try {
            main.outToServer.writeBytes("AcceptPetition"+"\n");
            main.outToServer.writeBytes(acceptedpetition.getType()+"\n"+acceptedpetition.getDetails()+"\n"+acceptedpetition.getPetitioner()+"\n");
            if(main.inFromServer.readLine().equals("Success")){
                JOptionPane.showMessageDialog(null,"Accepted Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRejectClicked(){
        Petition removepetition = petitions.getSelectionModel().getSelectedItem();
        removepetition.setAccpeted(false);
        data1.remove(removepetition);
        petitions.setItems(data1);
        try {
            main.outToServer.writeBytes("RejectPetition"+"\n");
            main.outToServer.writeBytes(removepetition.getType()+"\n"+removepetition.getDetails()+"\n"+removepetition.getPetitioner()+"\n");
            if(main.inFromServer.readLine().equals("Success")){
                JOptionPane.showMessageDialog(null,"Rejected Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showPetition() {
        try {
            main.outToServer.writeBytes("getPetitions"+"\n"+this.localadmin.getDept()+"\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            for (int i = 0; i < count; i++) {
                Petition p = new Petition();
                p.setDept(this.localadmin.getDept());
                p.setType(main.inFromServer.readLine());
                p.setDetails(main.inFromServer.readLine());
                p.setPetitioner(main.inFromServer.readLine());
                data1.add(i, p);

            }

            petitions.setItems(data1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onAllocateClicked(){
        try {
            Course c = courses.getSelectionModel().getSelectedItem();
            Stage allocate = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Allocate.fxml"));
            AnchorPane alloc = (AnchorPane) loader.load();
            AllocateController controller = loader.getController();
            controller.setMain(this.main, c,this);
            Scene scene = new Scene(alloc);
            allocate.setScene(scene);
            allocate.setTitle("Allocate Room For " + c.getCourseCode());
            allocate.show();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(Course c){
        try {
            main.outToServer.writeBytes("updateRoom"+"\n");
            main.outToServer.writeBytes(c.getRoom()+"\n");
            main.outToServer.writeBytes(c.getCourseCode()+"\n");
        }catch (IOException e){
            e.printStackTrace();
        }

        for(int i=0;i<data2.size();i++){
            if(data2.get(i).equals(c)){
                data2.remove(i);
            }
        }

        data2.add(c);
        courses.setItems(data2);


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

    public void showCourses() {
        try {
            main.outToServer.writeBytes("getDeptCourses"+"\n"+this.localadmin.getDept()+"\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            for (int i = 0; i < count; i++) {
                Course c = new Course();
                c.setDept(this.localadmin.getDept());
                c.setCourseCode(main.inFromServer.readLine());
                c.setCoursecap(Integer.parseInt(main.inFromServer.readLine()));
                c.setTime_slot(main.inFromServer.readLine());
                c.setRoom(main.inFromServer.readLine());
                data2.add(i, c);

            }

            courses.setItems(data2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void OnForumClicked(){
        showforum(this.main,this.localadmin,this);
    }
}
