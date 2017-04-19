package sample;

import com.sun.deploy.panel.RadioPropertyGroup;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

public class LoginController {

    public Main main;
    private User user;
    // TODO: set the logged in user.
    private String Status;
    String category;


    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton student;

    @FXML
    private RadioButton professor;

    @FXML
    private RadioButton admin;

    private ToggleGroup t = new ToggleGroup();

    public void setMain(Main main) {

        this.main = main;
        student.setToggleGroup(t);
        professor.setToggleGroup(t);
        admin.setToggleGroup(t);

    }



    public void OnLoginClicked(){
        if(((!student.isSelected()) && (!professor.isSelected())) && (!admin.isSelected()))
        {
            JOptionPane.showMessageDialog(null,"Please Select if you are a student,professor, or an administrator", "Notification", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (student.isSelected())
            category="student";
        else if(professor.isSelected())
            category = "professor";
        else
            category = "admin";

        try{
            main.outToServer.writeBytes("Login\n");
            main.outToServer.writeBytes(category+"\n");
            main.outToServer.writeBytes(username.getText() + "\n");
            main.outToServer.writeBytes(password.getText() + "\n");
            Status = main.inFromServer.readLine();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        if(Status.equals("Success"))
        {
            if(category.equals("student"))
            {
                Student s = (Student) user;
                try {
                    user.setUsername(main.inFromServer.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
                showStudent(s,this.main);

            }
            else if(category.equals("professor"))
            {

            }
            else
            {

            }
        }



    }

    public void showStudent(Student s,Main main){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Student.fxml"));
            AnchorPane student = (AnchorPane) loader.load();

            StudentPageController controller = new StudentPageController();
            controller = loader.getController();
            controller.setMain(main,s);

            main.rootLayout.setCenter(student);



        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
