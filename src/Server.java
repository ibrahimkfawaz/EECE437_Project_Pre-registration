package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.sql.*;

/**
 * Created by Hasan Fakih on 4/16/2017.
 * this is the database interface it is the class that setup the connection with the database and query the database
 * every client connected to the server will have an instance if this interface
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

        while (!finished) {
            try {
                String method = input.readLine();
                switch (method) {
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
                    case "addNewCourse":
                        addnewcourse(input);
                        break;
                    case "modifyCourse":
                        modifycourse(input);
                        break;
                    case "getCourses":
                        getcourses(input);
                        break;
                    case "deleteCourse":
                        deletecourse(input);
                        break;
                    case "getCatalog":
                        getcatalog(input);
                        break;
                    case "getOffered":
                        getoffered(input);
                        break;
                    case "getCrn":
                        getcrn(input);
                        break;
                    case "deleteCoursecat":
                        deletefromcat(input);
                        break;
                    case "newPetition":
                        newpetition(input);
                        break;
                    case "getPetitions":
                        getpetition(input);
                        break;
                    case "AcceptPetition":
                        acceptpetition(input);
                        break;
                    case "RejectPetition":
                        rejectpetition(input);
                        break;
                    case "getMyPetitions":
                        getmypetitions(input);
                        break;
                    case "CleanMyPetitions":
                        cleanmypetitions(input);
                        break;
                    case "increasecap":
                        increasecap(input);
                        break;
                    case "getDeptCourses":
                        getdeptcourses(input);
                        break;
                    case "getRooms":
                        getrooms(input);
                        break;
                    case "decreasecap":
                         decreasecap(input);
                         break;
                    case "updateRoom":
                        updateroom(input);
                        break;
                    case "closeThread":
                        break;

                }

            } catch (IOException e) {

            }

        }
    }


    public void login(BufferedReader in) {
        try {
            String username = input.readLine();
            String password = input.readLine();
            ResultSet resultSet = null;
            try {

                resultSet = statement.executeQuery("select * from users where (username=\"" + username + "\" ) and password= \"" + password + "\";");

                if (!resultSet.next()) {    //means no result
                    DataOut.writeBytes("Failed: 1\n"); // Failed with code 1 means invalid credentials
                } else {
                    String out = "Success" + "\n" + resultSet.getString(2) + "\n" + resultSet.getString(4) + "\n" + resultSet.getString(5) + "\n";
                    DataOut.writeBytes(out);
                }
            } catch (SQLException e) {
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void NewThread(BufferedReader in) {
        try {
            String message = input.readLine();
            String title = input.readLine();
            String intiator = input.readLine();
            ResultSet resultSet = null;

            titleid = 0;
            try {
                resultSet = statement.executeQuery("select idThreads from threads where threadtitle=\"" + title + "\"  ;");


                if (!resultSet.next()) {
                    statement.execute("insert into threads (titleid,threadtitle,message,sender,initiator) values (\" 1 \",\"" + title + "\",\"" + message + "\",\"" + intiator + "\",\"" + intiator + "\");");

                } else {
                    while (resultSet.next()) {
                        titleid++;
                    }
                    titleid = titleid + 2;
                    statement.execute("insert into threads (titleid,threadtitle,message,sender,initiator) values (\"" + titleid + "\",\"" + title + "\",\"" + message + "\",\"" + intiator + "\",\"" + intiator + "\");");

                }


            } catch (SQLException e) {
            }
            String out = "Success" + "\n";
            DataOut.writeBytes(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void GetMessage(BufferedReader in) {
        String query = "select * from threads";
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                count++;
            }
            try {
                DataOut.writeBytes(count + "\n");

                System.out.println(count);

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(3) + "\n" + rs.getString(2) + "\n" + rs.getString(6) + "\n" + rs.getString(4) + "\n"); // Message
                }
            } catch (IOException e) {

            }

        } catch (SQLException e) {

        }
    }

    public void getreplies(BufferedReader in) {
        String tid = null;
        try {
            tid = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String query = "select * from replies where threadid ='" + tid + "';";
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                count++;
            }
            try {
                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(4) + "\n" + rs.getString(5) + "\n");
                }
            } catch (IOException e) {

            }

        } catch (SQLException e) {

        }
    }

    public void replytothread(BufferedReader in) {
        String threadid = null;
        String replier = null;
        String message = null;
        String post;
        try {
            threadid = in.readLine();
            replier = in.readLine();
            message = in.readLine();
            post = in.readLine();


            try {
                statement.execute("insert into replies (threadid,replier,message,post) values (\"" + threadid + "\",\"" + replier + "\",\"" + message + "\",\"" + post + "\");");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DataOut.writeBytes("Success" + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getcourses(BufferedReader in) {
        int count = 0;
        try {
            String professor = in.readLine();
            String query = "select * from courses where professor ='" + professor + "';";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);

                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(4) + "\n" + rs.getString(5) + "\n" + rs.getString(1) + "\n" + rs.getString(9) + "\n");
                    //TODO: room/timeslot
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addnewcourse(BufferedReader in) {
        try {
            String coursename = in.readLine();
            String dept = coursename.substring(0, 4);
            int cap = 0;
            String professor = in.readLine();
            String timeslot = in.readLine();
            String coursedesc = in.readLine();
            String room = in.readLine();
            String coursen = in.readLine();
            ResultSet rs1 = null;

            try {
                statement.execute("insert into courses (coursename,professor,coursedesc,timeslot,room,capacity,dept,coursen) values (\"" + coursename + "\",\"" + professor + "\",\"" + coursedesc + "\",\"" + timeslot + "\",\"" + room + "\",\"" + cap + "\",\"" + dept + "\",\"" + coursen + "\");");
                rs1 = statement.executeQuery("SELECT idcatalog FROM catalogue WHERE coursename = '" + coursename + "';");
                if (!rs1.next()) {
                    statement.execute("insert into catalogue (coursename,coursedesc) values (\"" + coursename + "\",\"" + coursedesc + "\");");

                }

                DataOut.writeBytes("Success" + "\n");

            } catch (SQLException e) {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deletecourse(BufferedReader in) {
        try {
            String prof = in.readLine();
            String coursename = in.readLine();
            System.out.print(prof);
            try {
                String query = "DELETE FROM courses WHERE professor='" + prof + "' and coursename='" + coursename + "';";
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DataOut.writeBytes("Success" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getcrn(BufferedReader in) {
        ResultSet rs = null;
        try {
            try {

                String coursename = in.readLine();
                rs = statement.executeQuery("select idcourses from courses where coursename = '" + coursename + "';");

                rs.next();

                DataOut.writeBytes(rs.getString(1) + "\n");


            } catch (SQLException e) {

            }
        } catch (IOException e) {

        }

    }

    public void modifycourse(BufferedReader in) {
        try {
            int crn = Integer.parseInt(in.readLine());
            String coursename = in.readLine();
            String professor = in.readLine();
            String timeslot = in.readLine();
            String coursedesc = in.readLine();
            String room = in.readLine();
            String coursen = in.readLine();

            try {
                String query = "UPDATE courses SET coursename='" + coursename + "',professor='" + professor + "',timeslot ='" + timeslot + "', coursedesc='" + coursedesc + "', coursen = '" + coursen + "' WHERE idcourses='" + crn + "';";
                statement.executeUpdate(query);

            } catch (SQLException e) {

            }
            DataOut.writeBytes("Success" + "\n" + crn + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getcatalog(BufferedReader in) {
        int count = 0;
        try {
            String query = "select * from catalogue";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);

                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3) + "\n");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getoffered(BufferedReader in) {
        int count = 0;
        try {
            String dept = in.readLine();
            String query = "select * from courses where dept ='" + dept + "';";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);

                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(4) + "\n" + rs.getString(5) + "\n");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletefromcat(BufferedReader in) {
        try {
            String coursecode = in.readLine();

            try {
                String query = "DELETE FROM catalogue WHERE coursename='" + coursecode + "';";
                statement.executeUpdate(query);

            } catch (SQLException e) {

            }
            DataOut.writeBytes("Success" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newpetition(BufferedReader in) {
         try
         {

            String type = in.readLine();
            String petitioner = in.readLine();
            String dept = in.readLine();
            String det = in.readLine();
            String status = "pending";

            try{
               statement.execute("insert into petitions (t,details,dept,petitioner,status) values (\"" + type + "\",\"" + det + "\",\"" + dept + "\",\"" + petitioner + "\",\"" + status + "\");");

            }catch (SQLException e) {
            }

             DataOut.writeBytes("Success" + "\n");


         }catch (IOException e){
             e.printStackTrace();
         }
    }

    public void getpetition(BufferedReader in){
        int count = 0;
        String status = "pending";
        try {
            String dept = in.readLine();
            String query = "select * from petitions where dept ='" + dept + "' and status = '"+status+"';";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);
                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(5) + "\n");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void acceptpetition(BufferedReader in){
        try {
            String type = in.readLine();
            String det = in.readLine();
            String petitioner = in.readLine();
            String status = "accepted";
            try {
                String query = "UPDATE petitions SET status='"+status+"' where t ='" + type + "' and details ='"+det+"' and petitioner ='"+ petitioner +"';";
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            DataOut.writeBytes("Success" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rejectpetition(BufferedReader in){
        try {
            String type = in.readLine();
            String det = in.readLine();
            String petitioner = in.readLine();
            String status = "rejected";
            try {
                String query = "UPDATE petitions SET status='"+status+"' where t ='" + type + "' and details ='"+det+"' and petitioner ='"+ petitioner +"';";
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            DataOut.writeBytes("Success" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getmypetitions(BufferedReader in) {
        int count = 0;
        try {
            String username = in.readLine();
            String query = "select * from petitions where petitioner ='" + username + "';";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);
                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3) + "\n" + rs.getString(6) + "\n");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cleanmypetitions(BufferedReader in){
        try{
            String username = in.readLine();
            try{
                String query = "DELETE FROM petitions WHERE petitioner='" + username + "' and status='" + "accepted" + "';";
                statement.executeUpdate(query);
                String query1 = "DELETE FROM petitions WHERE petitioner='" + username + "' and status='" + "rejected" + "';";
                statement.executeUpdate(query1);
            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void increasecap(BufferedReader in)
    {
        try {
            String coursecode = in.readLine();

            try {
                String query = "UPDATE courses SET capacity=capacity+1 where coursename ='" + coursecode + "';";
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void decreasecap(BufferedReader in)
    {
        try {
            String coursecode = in.readLine();

            try {
                String query = "UPDATE courses SET capacity=capacity-1 where coursename ='" + coursecode + "';";
                statement.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getdeptcourses(BufferedReader in){
        int count = 0;
        try {
            String dept = in.readLine();
            String query = "select * from courses where dept ='" + dept + "';";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);
                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(7)+ "\n"+ rs.getString(5)+ "\n"+rs.getString(6)+ "\n");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getrooms(BufferedReader in) {
        try {
            int count = 0;
            String query = "select * from rooms;";
            ResultSet rs = null;
            try {
                rs = statement.executeQuery(query);
                while (rs.next()) {
                    count++;
                }

                DataOut.writeBytes(count + "\n");

                for (int i = 1; i <= count; i++) {

                    rs.absolute(i);
                    DataOut.writeBytes(rs.getString(2) + "\n" + rs.getString(3)+"\n");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateroom(BufferedReader in){
        try {
            String roomname = in.readLine();
            String coursecode = in.readLine();
            try {
                String query = "UPDATE courses SET room='" + roomname + "' where coursename ='" + coursecode + "';";
                statement.executeUpdate(query);
            }catch (SQLException e){
                e.printStackTrace();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
