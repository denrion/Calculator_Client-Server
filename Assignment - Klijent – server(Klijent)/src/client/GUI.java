package client;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GUI {

    Frame f;
    TextField op1Entry;
    TextField op2Entry;
    TextField result;
    Button calculate;
    Button reset;

    public void startFrame() {
        f = new Frame("Calculator");
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        LayoutManager layOut = new GridBagLayout();
        GridBagConstraints gbc;
        f.setLayout(layOut);

        Label lop1 = new Label("Enter first operand");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 8;
        gbc.gridheight = 4;
        f.add(lop1, gbc);

        op1Entry = new TextField();
        op1Entry.setMinimumSize(new Dimension(60, 20));
        op1Entry.setPreferredSize(new Dimension(60, 20));
        gbc = new GridBagConstraints();
        gbc.gridx = 20;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.gridheight = 4;
        f.add(op1Entry, gbc);

        Label lop2 = new Label("Enter second operand");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 9;
        gbc.gridheight = 5;
        f.add(lop2, gbc);

        op2Entry = new TextField();
        op2Entry.setMinimumSize(new Dimension(60, 20));
        op2Entry.setPreferredSize(new Dimension(60, 20));
        gbc = new GridBagConstraints();
        gbc.gridx = 20;
        gbc.gridy = 5;
        gbc.gridwidth = 7;
        gbc.gridheight = 4;
        f.add(op2Entry, gbc);

        Label res = new Label("Result");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 21;
        gbc.gridwidth = 11;
        gbc.gridheight = 6;
        f.add(res, gbc);

        calculate = new Button("Calculate");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        gbc.gridwidth = 21;
        gbc.gridheight = 7;
        f.add(calculate, gbc);

        reset = new Button("Reset");
        gbc = new GridBagConstraints();
        gbc.gridx = 19;
        gbc.gridy = 12;
        gbc.gridwidth = 21;
        gbc.gridheight = 7;
        f.add(reset, gbc);

        result = new TextField();
        result.setMinimumSize(new Dimension(60, 20));
        result.setPreferredSize(new Dimension(60, 20));
        gbc.gridx = 19;
        gbc.gridy = 22;
        gbc.gridwidth = 8;
        gbc.gridheight = 4;

        calculate.setEnabled(false);
        op1Entry.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                op2Entry.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        calculate.setEnabled(true);
                    }
                });
            }
        });

        reset.addActionListener((ActionEvent e) -> {
            op1Entry.setText("");
            op2Entry.setText("");
            result.setText("");
        });

        f.add(result, gbc);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
