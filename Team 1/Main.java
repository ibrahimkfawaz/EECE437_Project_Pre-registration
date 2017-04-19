package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.Socket;

public class Main extends Application {

    private Stage primaryStage;
    public BorderPane rootLayout;
    public BufferedReader inFromServer;
    public DataOutputStream outToServer;
    public  Socket socket=null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        socket = new Socket("localhost", 6789);
        outToServer = new DataOutputStream(socket.getOutputStream());

        inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream() ) );
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Pre-Reg");
        initRootLayout();
        showLogin();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event)  {

                try {
                    outToServer.writeBytes("Cancel" + "\n");
                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setWidth(1000);//restrain minimize/maximize
            primaryStage.setHeight(500);
            primaryStage.setMaxHeight(1000);
            primaryStage.setMinHeight(500);
            primaryStage.setMinWidth(1000);
            primaryStage.setMaxWidth(1000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("Login.fxml"));
            AnchorPane Login = (AnchorPane) loader.load();

            rootLayout.setCenter(Login);


            LoginController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
