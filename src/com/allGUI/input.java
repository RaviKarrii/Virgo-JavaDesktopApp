package com.allGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class input {

    public JTextField Name;
    public JSpinner Year;
    public JSpinner Month;
    public JSpinner Date;
    public JSpinner HH;
    public JSpinner MM;
    private JTextField City;
    private JButton Save;
    public JSpinner SS;
    //public Boolean flag;
    public JPanel Main;
    private JButton generateButton;
    private JTextField Lon;
    private JTextField Lat;
    public int Y,M,D,Hh,Mm,Ss;


    public input() {
        //flag = true;
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VirgoApp va = new VirgoApp();
                //va.TASingle.append("Ravi");
                FileManager Fm = new FileManager();
                Fm.WriteFile("HoroData.txt",Name.getText()+";"+Year.getValue().toString()+";"+Month.getValue().toString()+";"+Date.getValue().toString()+";"+HH.getValue().toString()+";"+MM.getValue().toString()+";"+SS.getValue().toString()+";"+Lon.getText()+";"+Lat.getText());


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
                //flag = false;
            }
        });
    }

    String start(VirgoApp va) {
        JFrame Frame = new JFrame("input");
        input in = new input();
        in.HH.setValue(12);
        in.Year.setValue(1993);
        in.Month.setValue(9);
        in.Date.setValue(16);
        in.MM.setValue(25);
        //ModelClass abc  =  new ModelClass("shikher", "mshikher","mishra" );
        Frame.setContentPane(in.Main);
        //Frame.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Frame.pack();
        Frame.setVisible(true);

        va.TASingle.append("Ravi");
        return "Ravi";
    }
}
