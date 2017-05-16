package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Hasan Fakih on 4/16/2017.
 * A singleton
 */
public class TCPServer {

    private TCPServer(){

    }

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(6789);     // creating server socket with Port#: 2015
            System.out.println("Server running...");
            while (true){
                Socket clientSocket=serverSocket.accept();          // waiting for client connections
                (new Server(clientSocket)).start();            // start a new thread per connection and throw to it the client socket
            }                                                       // that includes the IP and port of both server and client
        }
        catch (IOException e){
            System.out.println("Cannot Start Server.");
            System.out.println("Exception Thrown: "+e.toString());
        }
    }
}
