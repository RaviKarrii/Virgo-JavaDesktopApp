package com.allGUI;

import javax.swing.*;
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
    private JList list1;
    private JList list2;


    public static void main(String[] args) {
        VirgoApp virgo = new VirgoApp();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //virgo.datetimenow.setText(dtf.format(now));
        JFrame Frame = new JFrame("Virgo");
        Frame.setContentPane(virgo.Main);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        //Frame.pack();

        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        Frame.add(datePanel);
        //Frame.pack();
        Frame.setVisible(true);
    }
}
