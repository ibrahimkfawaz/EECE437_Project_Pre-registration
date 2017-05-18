package sample;

import com.sun.deploy.panel.RadioPropertyGroup;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

/**
 * This is a class for handling  the login page
 */

public class LoginController {

    public Main main;
//  private User user;
// TODO: set the logged in user.

    private String Status;
    String category;
    String un;
    String dept;


    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;


    public void setMain(Main main) {

        this.main = main;

    }


    @FXML
    public void OnLoginClicked(){

        try{
            main.outToServer.writeBytes("Login\n");
            main.outToServer.writeBytes(username.getText() + "\n");
            main.outToServer.writeBytes(password.getText() + "\n");
            Status = main.inFromServer.readLine();

        if(Status.contains("Success"))
        {
            un = main.inFromServer.readLine();
            category = main.inFromServer.readLine();
            dept = main.inFromServer.readLine();
            if(category.equals("student"))
            {
                Student s = new Student();

                s.setUsername(un);
                s.setDept(dept);

                showStudent(s,this.main,new StudentPageController());

            }
            else if(category.equals("professor"))
            {
                Professor p = new Professor();

                p.setUsername(un);
                p.setDept(dept);

                showProfessor(p,this.main);
            }
            else
            {
                Admin a = new Admin();

                a.setUsername(un);
                a.setDept(dept);
                showAdmin(a,this.main);

            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Incorrect Username or password, please recheck", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }

        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void showStudent(Student s,Main main,StudentPageController controller){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Student.fxml"));
            AnchorPane student = (AnchorPane) loader.load();


            controller = loader.getController();
            controller.setMain(this.main,s,this);

            main.rootLayout.setCenter(student);



        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void showProfessor(Professor p,Main main){ //TODO: fix this
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Professor.fxml"));
            AnchorPane professor = (AnchorPane) loader.load();

            ProfessorPageController controller = new ProfessorPageController();
            controller = loader.getController();
            controller.setMain(main,p);

            main.rootLayout.setCenter(professor);



        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void showAdmin(Admin a,Main main){ //TODO: fix this is not compeleted
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Admin.fxml"));
            AnchorPane admin = (AnchorPane) loader.load();

            AdminPageController controller = new AdminPageController();
            controller = loader.getController();
            controller.setMain(main,a);

            main.rootLayout.setCenter(admin);



        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
