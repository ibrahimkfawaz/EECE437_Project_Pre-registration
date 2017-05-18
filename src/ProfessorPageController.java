package sample;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

import javax.print.DocFlavor;
import javax.swing.*;
import java.io.IOException;

/**
 * handle actions done by the professor.
 */
public class ProfessorPageController extends PageController{
    Professor localprofessor= new Professor();
    private Main main;
    private int modifyingindex;


    @FXML
    private TableView<Course> proposedcourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> Coursename;
    @FXML
    private TableColumn<Course, String> CourseTime;
    @FXML
    private TableColumn<Course, String> Coursedesc;
    @FXML
    private TableView<Course> allcourses = new TableView<>();
    @FXML
    private TableColumn<Course, String> allCoursename;
    @FXML
    private TableColumn<Course, String> allCoursedesc;

    ObservableList<Course> data;
    ObservableList<Course> data1;



    public void setMain(Main main,Professor prof){
        this.main= main;
        this.localprofessor = prof;
        Coursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        CourseTime.setCellValueFactory(new PropertyValueFactory<Course, String>("time_slot"));
        Coursedesc.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseDesc"));
        allCoursename.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCode"));
        allCoursedesc.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseDesc"));
        data = FXCollections.observableArrayList();
        data1 = FXCollections.observableArrayList();

        try {
            main.outToServer.writeBytes("getCourses"+"\n");
            main.outToServer.writeBytes(localprofessor.getUsername()+"\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            System.out.println(count);

            for(int i=0;i<count;i++)
            {
                Course c = new Course();
                c.setCourseCode(main.inFromServer.readLine());
                c.setCourseDesc(main.inFromServer.readLine());
                c.setTime_slot(main.inFromServer.readLine());
                c.setCrn(Integer.parseInt(main.inFromServer.readLine()));
                c.setCourseName(main.inFromServer.readLine());
                localprofessor.getProposedcourses().add(c);
                data.add(i,localprofessor.getProposedcourses().get(i));

            }

            proposedcourses.setItems(data);

            main.outToServer.writeBytes("getCatalog"+"\n");
            showCatalog(this.main,allcourses,data1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onForumClicked(){
        showforum(this.main,this.localprofessor,this);
    }

    public void onNewCourseClicked(){
        try {
            Stage course = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("NewCourse.fxml"));
            AnchorPane newcourse = (AnchorPane) loader.load();
            NewCourseController controller = loader.getController();
            controller.setMain(this.main,this.localprofessor,this);
            Scene scene = new Scene(newcourse);
            course.setScene(scene);
            course.setTitle("New Course");
            course.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void OnDeleteClicked(){
        Course coursetoremove = proposedcourses.getSelectionModel().getSelectedItem();
        data.remove(coursetoremove);
        proposedcourses.setItems(data);
        try {
            main.outToServer.writeBytes("deleteCourse"+"\n");
            main.outToServer.writeBytes(localprofessor.getUsername()+"\n");
            main.outToServer.writeBytes(coursetoremove.getCourseCode()+"\n");
            if(main.inFromServer.readLine().equals("Success")){
                JOptionPane.showMessageDialog(null,"Deleted Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void OnModifyClicked(){
        try {
            Course coursetomodify = proposedcourses.getSelectionModel().getSelectedItem();
            modifyingindex = data.indexOf(coursetomodify);
            Stage modify = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ModifyCourse.fxml"));
            AnchorPane modifycourse = (AnchorPane) loader.load();
            ModifyCourseController controller = loader.getController();
            controller.setMain(this.main, coursetomodify,this);
            Scene scene = new Scene(modifycourse);
            modify.setScene(scene);
            modify.setTitle("Modify Course " + coursetomodify.getCourseCode());
            modify.show();
        }catch (IOException e){

        }
    }

    public void OnLogoutClicked(){
        main.showLogin();
    }

    public void modify(Course course){
        try {
            main.outToServer.writeBytes("getCrn" + "\n" + course.getCourseCode()+"\n");
            course.setCrn(Integer.parseInt(main.inFromServer.readLine()));
            main.outToServer.writeBytes("modifyCourse" + "\n");
            main.outToServer.writeBytes(Integer.toString(course.getCrn())+"\n");
            main.outToServer.writeBytes(course.getCourseCode()+"\n");
            main.outToServer.writeBytes(localprofessor.getUsername()+"\n");
            main.outToServer.writeBytes(course.getTime_slot()+"\n");
            main.outToServer.writeBytes(course.getCourseDesc()+"\n");
            main.outToServer.writeBytes("101"+"\n"); //FIXME
            main.outToServer.writeBytes(course.getCourseName()+"\n");
            localprofessor.getProposedcourses().remove(modifyingindex);
            localprofessor.getProposedcourses().add(course);
            data.remove(modifyingindex);
            data.add(course);
            String Status = main.inFromServer.readLine();
            if(Status.equals("Success")){
                course.setCrn(Integer.parseInt(main.inFromServer.readLine()));
                JOptionPane.showMessageDialog(null,"Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }
            proposedcourses.setItems(data);


        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void update(Course course){
        try {

            //add to database
            main.outToServer.writeBytes("addNewCourse" + "\n");
            main.outToServer.writeBytes(course.getCourseCode()+"\n");
            main.outToServer.writeBytes(localprofessor.getUsername()+"\n");
            main.outToServer.writeBytes(course.getTime_slot()+"\n");
            main.outToServer.writeBytes(course.getCourseDesc()+"\n");
            main.outToServer.writeBytes("101"+"\n"); //FIXME
            main.outToServer.writeBytes(course.getCourseName()+"\n");

            String Status = main.inFromServer.readLine();
            if(Status.equals("Success")){
                JOptionPane.showMessageDialog(null,"Success", "Notification", JOptionPane.INFORMATION_MESSAGE);
            }

            //update the table view
            localprofessor.getProposedcourses().add(course);

            data.add(course);
            proposedcourses.setItems(data);
            boolean flag = false;
            for(int i=0;i<data1.size();i++)
            {
                if(data1.get(i).getCourseCode().equals(course.getCourseCode()))
                    flag=true;
            }

            if(!flag) {
                data1.add(course);
                allcourses.setItems(data1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
