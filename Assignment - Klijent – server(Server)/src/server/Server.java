package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;
    private static final int PORT = 1000;
    private static Socket link;

    private static void bindPort() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Port is opened");
        } catch (IOException ex) {
            System.out.println("Unable to bind port: " + PORT);
            System.exit(1);
        }
    }

    private static void startListening() {
        System.out.println("Server is listening...");
        try {
            link = serverSocket.accept();
        } catch (IOException ex) {
            System.out.println("Connection could not be established");
        }
    }

    public static void main(String[] args) {
        bindPort();
        while (true) {
            startListening();
            new Calculator(link).start();
        }
    }

}
