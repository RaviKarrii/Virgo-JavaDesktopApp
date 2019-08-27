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

    JFrame Frame = new JFrame("input");
    public input() {

        //flag = true;
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VirgoApp va = new VirgoApp();
                //va.TASingle.append("Ravi");
                FileManager Fm = new FileManager();
                Fm.WriteFile("HoroData.txt",Name.getText()+";"+Year.getValue().toString()+";"+Month.getValue().toString()+";"+Date.getValue().toString()+";"+HH.getValue().toString()+";"+MM.getValue().toString()+";"+SS.getValue().toString()+";"+Lon.getText()+";"+Lat.getText());
                Frame.setVisible(false);
                Frame.dispose();

            }
        });

    }

    String start(VirgoApp va) {
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
