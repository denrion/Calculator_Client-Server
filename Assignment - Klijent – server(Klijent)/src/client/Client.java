package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    static InetAddress host;
    static final int PORT = 1000;

    private static void ignite() {
        GUI gui = new GUI();
        ClientToServer cts = new ClientToServer();
        Pattern p = Pattern.compile("^[0-9]+(\\.[0-9]+)*$");

        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(gui.f, "Host not found");
            System.exit(1);
        }
        gui.startFrame();

        gui.calculate.addActionListener((ActionEvent e) -> {
            boolean canContinue = true;
            Matcher m = p.matcher(gui.op1Entry.getText());
            boolean match1 = m.find();
            m = p.matcher(gui.op2Entry.getText());
            boolean match2 = m.find();
            if (!match1 || !match2) {
                JOptionPane.showMessageDialog(gui.f, "You must enter a number");
                canContinue = false;
            }
            if (canContinue) {
                cts.acessServer(gui.op1Entry.getText(), gui.op2Entry.getText());
                gui.result.setText(cts.getResult());
            } else {
                gui.f.dispose();
                ignite();
            }
        });
    }

    public static void main(String[] args) {
        ignite();
    }
}
