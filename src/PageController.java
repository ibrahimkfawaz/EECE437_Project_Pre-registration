package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Hasan Fakih on 5/1/2017.
 * super class for the Professor-Student-AdminController pages
 * it handle common functions between the three pages
 */
public class PageController {

    public void setMain(Main main,User localuser,PageController p){}

    public void showCatalog(Main main, TableView<Course> allcourses, ObservableList<Course> data1)

    {
        try {
            int count = Integer.parseInt(main.inFromServer.readLine());
            for (int i = 0; i < count; i++) {
                Course c1 = new Course();
                c1.setCourseCode(main.inFromServer.readLine());
                c1.setCourseDesc(main.inFromServer.readLine());
                Catalog.getinstance().addCourse(c1.getCourseCode(), c1.getCourseDesc());
                data1.add(i, c1);

            }

            allcourses.setItems(data1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showforum(Main main,User user,PageController p){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Forum.fxml"));
            AnchorPane forum = (AnchorPane) loader.load();

            main.rootLayout.setCenter(forum);

            ForumController controller = loader.getController();
            controller.setMain(main,user,p);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
