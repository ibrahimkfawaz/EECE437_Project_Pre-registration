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
    private int titleid;


    public Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            out = clientSocket.getOutputStream();
            DataOut = new DataOutputStream(out);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            objToClient = new ObjectOutputStream(clientSocket.getOutputStream());

        } catch (IOException e) {

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
                        GetMessage(input);
                        break;
                    case "setNewThread":
                        NewThread(input);
                        break;
                    case "getReplies":
                        getreplies(input);
                        break;
                    case "replyToThread":
                        replytothread(input);
                        break;
                    case "closeThread":
                        break;

                }

            }catch (IOException e)
            {

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
                    String out = "Success" + "\n" + resultSet.getString(2) + "\n";
                    DataOut.writeBytes(out);
                }
            }catch (SQLException e)
            {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NewThread(BufferedReader in){
        try {
            String message = input.readLine();
            String title = input.readLine();
            String intiator = input.readLine();
            ResultSet resultSet=null;

            titleid =0;
            try {
                 resultSet = statement.executeQuery("select idThreads from threads where threadtitle=\"" + title + "\"  ;");


            if (!resultSet.next()){
                statement.execute("insert into threads (titleid,threadtitle,message,sender,initiator) values (\" 1 \",\"" + title + "\",\"" + message + "\",\"" + intiator + "\",\"" + intiator + "\");");

            }else
            {
                while(resultSet.next())
                {
                    titleid++;
                }
                titleid=titleid+2;
                statement.execute("insert into threads (titleid,threadtitle,message,sender,initiator) values (\"" + titleid + "\",\"" + title + "\",\"" + message + "\",\"" + intiator + "\",\"" + intiator + "\");");

            }


            }catch(SQLException e){}
            String out = "Success" + "\n" ;
            DataOut.writeBytes(out);
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void GetMessage(BufferedReader in){
        String query = "select * from threads";
        int count=0;
        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                count++;
            }
            try {
                DataOut.writeBytes(count + "\n");

                System.out.println(count);

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(3) + "\n" + rs.getString(2) + "\n" + rs.getString(6) + "\n" + rs.getString(4) + "\n"); // Message
                }
            }catch (IOException e)
            {

            }

        }catch(SQLException e){

        }
    }

    public void getreplies(BufferedReader in){
        String tid = null;
        try {
           tid = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String query = "select * from replies where threadid ='" + tid +  "';";
        int count=0;
        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                count++;
            }
            try {
                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) + "\n");
                }
            }catch (IOException e)
            {

            }

        }catch(SQLException e){

        }
    }

    public void replytothread(BufferedReader in){
        String threadid = null;
        String replier = null;
        String message = null;
        try {
            threadid = in.readLine();
            replier = in.readLine();
            message = in.readLine();


        try {
            statement.execute("insert into replies (threadid,replier,message) values (\"" + threadid + "\",\"" + replier + "\",\"" + message + "\");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
            DataOut.writeBytes("Success" + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


