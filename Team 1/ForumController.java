package sample;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;


/**
 * Created by Hasan Fakih on 4/9/2017.
 */
public class ForumController {
    private Main main;
    private User localuser;

    @FXML
    private Button newmessage;

    @FXML
    private Button back;

    @FXML
    private ListView<Threads> received = new ListView<>();
    @FXML
    private ListView<Student> init = new ListView<>();

    private List<Threads> recmsgs = new LinkedList<Threads>();
    private List<Student> initiators = new LinkedList<Student>();

    private int titleid;
    private String title;
    private String message;
    private String initiator;

    public ForumController(){}

    public void setMain(Main main,User u){
        this.main= main;
        if(u instanceof Student)
            this.localuser = (Student) u;
        else if(u instanceof Professor)
            this.localuser = (Professor) u;
        else
            this.localuser = (Admin) u;

        try {
            main.outToServer.writeBytes("getMessages"+"\n");
            int msgcount = Integer.parseInt(main.inFromServer.readLine());
            for (int i=0; i<msgcount; i++){

                title = main.inFromServer.readLine();
                titleid = Integer.parseInt(main.inFromServer.readLine());
                initiator = main.inFromServer.readLine();
                message = main.inFromServer.readLine();
                recmsgs.add(i,new Threads(title,titleid,message,initiator));
                initiators.add(i,new Student(initiator));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        ObservableList<Student> data = FXCollections.observableArrayList(initiators);
        ObservableList<Threads> data2 = FXCollections.observableArrayList(recmsgs);


        received.setCellFactory(param -> new ListCell<Threads>() {
            @Override
            protected void updateItem(Threads item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getTitle() == null) {
                    setText(null);
                } else {
                    setText(item.getTitle());
                }
            }
        });

        init.setCellFactory(param -> new ListCell<Student>() {
            @Override
            protected void updateItem(Student item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getUsername() == null) {
                    setText(null);
                } else {
                    setText(item.getUsername());
                }
            }
        });

        received.setItems(data2);
        init.setItems(data);



    }

    public void onBackClicked(){
        LoginController l = new LoginController();
        l.showStudent((Student)this.localuser,this.main);
    }

    public void onListViewClicked(){
        int id=  received.getSelectionModel().getSelectedItem().getTitleid();
        String title = received.getSelectionModel().getSelectedItem().getTitle();

        for(int i =0;i<recmsgs.size();i++)
        {
            if(recmsgs.get(i).getTitleid()== id && recmsgs.get(i).getTitle().equals(title))
                showthreads(recmsgs.get(i));
                break;
        }

    }

    public void onNewClicked() {
        try {
            Stage message = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("NewMessage.fxml"));
            AnchorPane newmessage = (AnchorPane) loader.load();
            NewMessageController controller = loader.getController();
            controller.setMain(this.main,this.localuser);
            Scene scene = new Scene(newmessage);
            message.setScene(scene);
            message.setTitle("message");
            message.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void showthreads(Threads t){
        try {
            Stage thread = new Stage();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Threads.fxml"));
            AnchorPane threads = (AnchorPane) loader.load();
            ThreadsController controller = loader.getController();
            controller.setMain(this.main,t,this.localuser);
            Scene scene = new Scene(threads);
            thread.setScene(scene);
            thread.setTitle(t.getTitle());
            thread.show();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
