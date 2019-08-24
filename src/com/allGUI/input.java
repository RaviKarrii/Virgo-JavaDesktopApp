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
    public int Y,M,D,Hh,Mm,Ss;

    public input() {
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VirgoApp va = new VirgoApp();
                JFrame Frame2 = new JFrame("Virgo");
                Frame2.setContentPane(va.Main);
                //Frame2.pack();
                Frame2.setExtendedState(JFrame.MAXIMIZED_BOTH);
                //Frame2.setUndecorated(true);
                Frame2.setVisible(true);
            }
        });
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame Frame2 = new JFrame("Chart");
                D = (Integer)Date.getValue();
                Y = (Integer)Year.getValue();
                M = (Integer)Month.getValue();
                Hh = (Integer)HH.getValue();
                Mm = (Integer)MM.getValue();
                Ss = (Integer)SS.getValue();
                //System.out.println(Mm);
                Chart chart = new Chart(Name.getText(),Y,M,D,Hh,Mm,Ss);
                chart.start();
                Frame2.setContentPane(chart.Main);
                Frame2.pack();
                Frame2.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame Frame = new JFrame("input");
        input in = new input();
        in.HH.setValue(12);
        in.Year.setValue(1993);
        in.Month.setValue(9);
        in.Date.setValue(16);
        in.MM.setValue(25);
        Frame.setContentPane(in.Main);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);

    }
}
