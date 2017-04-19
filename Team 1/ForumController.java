package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public class ForumController {
    private Main main;
    private User user;

    @FXML
    private Button newmessage;

    @FXML
    private Button back;

    @FXML
    private ListView<String> received = new ListView<String>();
    public List<String> recmsgs = new LinkedList<String>();


   // public ForumController(User u){}
    public void setMain(Main main,User u){ //TODO: not finished need to add handler on the list and to fill list from database by messages.
        this.main= main;
        if(u instanceof Student)
            this.user = (Student) u;
        else if(u instanceof Professor)
            this.user = (Professor) u;
        else
            this.user = (Admin) u;

//        recmsgs.add(0,"Question");
//        recmsgs.add(1,"Poll");
//        recmsgs.add(2,"Answer");
//        recmsgs.add(3,"New Here");
//        recmsgs.add(4,"New Here");
//        recmsgs.add(5,"New Here");
//        recmsgs.add(6,"New Here");
//        recmsgs.add(7,"New Here");
//        recmsgs.add(8,"New Here");
//        recmsgs.add(9,"New Here");
//        recmsgs.add(10,"New Here");
//        recmsgs.add(11,"New Here");
//        recmsgs.add(12,"New Here");
//        recmsgs.add(13,"New Here");
//        recmsgs.add(14,"New Here");
//        recmsgs.add(15,"New Here");

        ObservableList<String> data = FXCollections.observableArrayList(recmsgs);
        received.setItems(data);
    }

    public void onBackClicked(){
        LoginController l = new LoginController();
        //l.setMain(this.main);
        l.showStudent(this.user,this.main);
    }

    public void onNewClicked() {
        try {
            Stage message = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("NewMessage.fxml"));
            AnchorPane newmessage = (AnchorPane) loader.load();
            NewMessageController controller = loader.getController();
            controller.setMain(this.main);
            Scene scene = new Scene(newmessage);
            message.setScene(scene);
            message.setTitle("message");
            message.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
