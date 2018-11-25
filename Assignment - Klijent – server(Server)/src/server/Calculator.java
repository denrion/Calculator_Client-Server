package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator extends Thread {

    private Socket link;

    Calculator(Socket link) {
        this.link = link;
    }

    @Override
    public void run() {
        super.run();
        try {
            manageClient();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (NoSuchElementException nseex) {
            System.out.println("User " + link.getInetAddress() + " terminated the connection");
        }
    }

    private void manageClient() throws IOException {
        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream(), true);
        double op1 = Double.parseDouble(input.nextLine());
        double op2 = Double.parseDouble(input.nextLine());
        double result;

        result = op1 + op2;
        output.println(result);

    }
}
