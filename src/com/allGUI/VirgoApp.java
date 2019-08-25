package com.allGUI;

import javax.swing.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;
import org.jdatepicker.*;
import java.util.*;
import org.jdatepicker.impl.JDatePanelImpl;
public class VirgoApp {
    private JTabbedPane tabbedPane1;
    public JPanel Main;
    private JPanel BirthChart;
    private JPanel Details;
    private JPanel Dasa;
    private JPanel Data;
    private JLabel datetimenow;
    private JPanel Compatibility;
    private JPanel About;
    private JTabbedPane TPforINp;
    private JPanel Horoscope;
    private JPanel CompIN;
    private JButton ChartBut;
    private JList list1;
    private JButton Generate;
    private JLabel HName;
    public JTextArea TASingle;


    public VirgoApp() {


        ChartBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VirgoApp virgo = new VirgoApp();
                JFrame Frame = new JFrame("Chart");
                input input = new input();
                //input.HH.setValue(12);
                //input.Year.setValue(1993);
                //input.Month.setValue(9);
                //input.Date.setValue(16);
                //input.MM.setValue(25);
                String str = input.start(virgo);
                TASingle.append(str);
                //Frame.setContentPane(input.Main);
                //Frame.pack()
                //Frame.setVisible(true);

                //waiter(input);
            }
        });
    }

    public static void main(String[] args) {
        VirgoApp virgo = new VirgoApp();
        FileManager Fm = new FileManager();
        Fm.CreateFile("HoroData.txt");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //virgo.datetimenow.setText(dtf.format(now));
        JFrame Frame = new JFrame("Virgo");
        Frame.setContentPane(virgo.Main);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);

        Frame.setVisible(true);

    }
}
