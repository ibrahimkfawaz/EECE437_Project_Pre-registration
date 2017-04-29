package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Hasan Fakih on 4/16/2017.
 */
public class StudentPageController {
    @FXML
    private Button forum;
    Student localstudent= new Student();
    private Main main;

    public void setMain(Main main,Student stud){
        this.main= main;
        this.localstudent = stud;
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
            controller.setMain(this.main,this.localstudent);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
