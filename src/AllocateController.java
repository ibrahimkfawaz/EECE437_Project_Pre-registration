package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/17/2017.
 * Controller for allocate page where the admin could choose a room for each proposed course
 * and if the room is not allocated at that specific time it will accept this new allocation
 * otherwise it will not and it will tell the admin to choose new room
 */
public class AllocateController {
    private Course c;
    private Main main;
    private AdminPageController apc;

    @FXML
    private TableColumn<Room, String> name;
    @FXML
    private TableColumn<Room, String> cap;
    @FXML
    private TableView<Room> rooms;

    ObservableList<Room> data;

    public void setMain(Main main, Course c,AdminPageController p){
        this.main=main;
        this.c=c;
        this.apc=p;
        name.setCellValueFactory(new PropertyValueFactory<Room, String>("name"));
        cap.setCellValueFactory(new PropertyValueFactory<Room, String>("capacity"));
        data = FXCollections.observableArrayList();
        showRooms();


    }

    public void showRooms(){
        try {
            main.outToServer.writeBytes("getRooms" + "\n");
            int count = Integer.parseInt(main.inFromServer.readLine());
            for(int i=0;i<count;i++){
                Room r=new Room();
                r.setName(main.inFromServer.readLine());
                r.setCapacity(Integer.parseInt(main.inFromServer.readLine()));
                data.add(r);
            }

            rooms.setItems(data);

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void onAllocateClicked(){
        Room r = rooms.getSelectionModel().getSelectedItem();
        c.parseslot(c.getTime_slot());
        if(r.addtoRoom(c)) {
            JOptionPane.showMessageDialog(null, "Allocated Successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            c.setRoom(r.getName());
            apc.update(c);
        }
        else
            JOptionPane.showMessageDialog(null,"This Room is already reserved at this time slot Please check other rooms", "Notification", JOptionPane.INFORMATION_MESSAGE);

    }
}
