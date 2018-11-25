package client;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class ClientToServer {

    private String result;

    String acessServer(String op1, String op2) {
        try (Socket link = new Socket(Client.host, Client.PORT);
                Scanner input = new Scanner(link.getInputStream());
                PrintWriter output = new PrintWriter(link.getOutputStream(), true)) {

            output.println(op1);
            output.println(op2);
            result = input.nextLine();

        } catch (ConnectException ex) {
            System.out.println("Connection to server could not be established");
            JOptionPane.showMessageDialog(new GUI().f, "Connection to server could not be established");
        } catch (NumberFormatException nfex) {
            System.out.println("You must enter a number. Try again!"); 
            JOptionPane.showMessageDialog(new GUI().f, "You must enter a number. Try again!");
        } catch (IOException ex) {
            System.out.println("Connection error" + ex.getMessage());
            JOptionPane.showMessageDialog(new GUI().f, "Connection error");
        }
        return result;
    }


    public String getResult() {
        return result;
    }

}
