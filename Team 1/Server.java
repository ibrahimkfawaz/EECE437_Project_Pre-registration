package sample;

import java.io.*;
import java.net.Socket;
import java.sql.*;

/**
 * Created by Hasan Fakih on 4/16/2017.
 */
public class Server extends Thread {
    private Socket clientSocket = null;
    private Connection connection = null;
    private Statement statement = null;
    private static final String dbURL = "jdbc:mysql://localhost:3306/registration";
    private static final String username = "root";
    private static final String password = "H@123456+";
    private OutputStream out = null;
    private DataOutputStream DataOut = null;
    private BufferedReader input = null;
    public ObjectInputStream objInput = null;
    public ObjectOutputStream objToClient = null;


    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            out = clientSocket.getOutputStream();
            DataOut = new DataOutputStream(out);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            objToClient = new ObjectOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean connectMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //set driver for mysql j connector
            connection = DriverManager.getConnection(dbURL, username, password);
            statement = connection.createStatement();
            return true;
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
            return false;
        }
    }

    public void run() {
        boolean finished = false;
        connectMySQL();

        while(!finished)
        {
            try {
                String method = input.readLine();
                switch (method){
                    case "Login":
                        login(input);
                        break;
                    case "Cancel":
                        System.exit(0);  //TODO: sould be removed
                        break;
                    case "getMessages":
                        break;
                    case "setNewThread":
                        NewThread(input);
                        break;
                    case "replyToThread":
                        break;
                    case "closeThread":
                        break;

                }

            }catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

    public void login(BufferedReader in) {
        try {
            String usertype = input.readLine();
            String username = input.readLine();
            String password = input.readLine();
            ResultSet resultSet=null;
            try {

                if(usertype.equals("professor")) {
                    resultSet = statement.executeQuery("select * from professors where (username=\"" + username + "\" ) and password= \"" + password + "\";");
                }
                else if(usertype.equals("student")){
                    resultSet = statement.executeQuery("select * from students where (username=\"" + username + "\" ) and password= \"" + password + "\";");
                }
                else{
                    resultSet = statement.executeQuery("select * from admins where (username=\"" + username + "\" ) and password= \"" + password + "\";");

                }
                if (!resultSet.next()) {    //means no result
                    DataOut.writeBytes("Failed: 1\n"); // Failed with code 1 means invalid credentials
                } else {
                    String out = "Success" + resultSet.getString(1) + "\n";
                    DataOut.writeBytes(out);
                }
            }catch (SQLException e)
            {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NewThread(BufferedReader in){

    }
}


