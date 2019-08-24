package com.allGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class input {
    private JTextField Name;
    private JSpinner Year;
    private JSpinner Month;
    private JSpinner Date;
    private JSpinner HH;
    private JSpinner MM;
    private JTextField City;
    private JButton Save;
    private JSpinner SS;
    private JPanel Main;
    private JButton generateButton;

    public input() {
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame2 = new JFrame("Chart");
                Chart chart = new Chart();
                chart.start();
                Frame2.setContentPane(chart.Main);

                Frame2.pack();
                Frame2.setVisible(true);
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame Frame = new JFrame("input");
        Frame.setContentPane(new input().Main);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);
    }
}
