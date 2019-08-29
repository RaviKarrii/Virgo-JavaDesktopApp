package com.allGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import swisseph.SweDate;

public class VirgoApp {
    private JTabbedPane tabbedPane1;
    public JPanel Main;
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
    private JButton Generate;
    public JEditorPane ChartTableEditor;
    private JEditorPane DetailsEditor;
    private JTextField NameN;
    private JLabel NameNN;
    private JLabel BDAYN;
    private JLabel CityN;
    private JSpinner YYYYN;
    private JSpinner MMN;
    private JSpinner DDN;
    private JSpinner HHN;
    private JSpinner MINN;
    private JSpinner SSN;
    private JTextField LONN;
    private JTextField LATN;
    private JPanel SDetails;
    private JTextArea Pisces;
    private JTextArea Aries;
    private JTextArea Tarus;
    private JTextArea Gemini;
    private JTextArea Saggittarius;
    private JTextArea Aquarius;
    private JTextArea Capricorn;
    private JTextArea Scorpio;
    private JTextArea Libra;
    private JTextArea Virgo;
    private JTextArea Cancer;
    private JTextArea Leo;
    public JTextArea TASingle;


    public VirgoApp() {

        Generate.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    //FileManager Fm = new FileManager();
                    //String ss = Fm.ReadFile("HoroData.txt");
                    ChartTableEditor.setContentType("text/html");
                    String data = "<html>";
                    ChartMaker cm = new ChartMaker();
                    String[] det = {NameN.getText(),YYYYN.getValue().toString(),MMN.getValue().toString(), DDN.getValue().toString(),HHN.getValue().toString(),MINN.getValue().toString(),SSN.getValue().toString(),LONN.getText(),LATN.getText()};


                    CalculateDetails calDet = new CalculateDetails();
                calDet.CalculateDetails(NameN.getText(),YYYYN.getValue().toString(),MMN.getValue().toString(), DDN.getValue().toString(),HHN.getValue().toString(),MINN.getValue().toString(),SSN.getValue().toString(),LATN.getText(),LONN.getText());
                String[] date = calDet.SRtime().split(" ")[0].split("-");
                    String[] time = calDet.SRtime().split(" ")[1].split(":");
                    System.out.println(calDet.SRtime());
                double time2 = cm.decimal(Integer.parseInt(time[0]),Integer.parseInt(time[1]),Integer.parseInt(time[2]));
                    SweDate sd=new SweDate(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]),time2);
                     SweDate sd_forSR=new SweDate(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0])-1,time2);
                    double[] geopos = {Float.valueOf(LATN.getText()),Float.valueOf(LONN.getText()),0};
                    //data+="<p>Details for "+det[0]+"";
                    data+="<center><table style='border: 1px solid black;' >";
                    data+="<tr><th>NAME</th><th>RAASI</th><th>ACTUAL DEGREES</th><th>DERIVED DEGREES</th></tr>";
                    String mRasi = "";
                    for(int number:cm.planets){
                        //System.out.println(number);
                        String PLDET = cm.getPlanetPos(number,sd);
                        String[] arr = PLDET.split(":");
                        String raasi = cm.RaasiFinder(Integer.parseInt(arr[1].trim()));
                        if (number == 1){
                            mRasi = raasi;
                        }
                        PlacePlanet(raasi,arr[0]);
                        data+="<tr><td>"+cm.plNams[number]+"</td><td>"+raasi+"</td><td>"+arr[1]+":"+arr[2]+":"+arr[3]+"</td><td>"+derive(Integer.parseInt(arr[1]))+":"+arr[2]+":"+arr[3]+"</td></tr>";
                    }
                    data+="</table><center>";
                    //data+=ss;
                    data+="</html>";
                    ChartTableEditor.setText(data);
                    DetailsEditor.setContentType("text/html");
                    //data = "<html><body><img src='https://vectr.com/tmp/h4J2DMgQg/a1ctpgbiDD.jpg?width=320&height=320&select=a1ctpgbiDDpage0'/></body></html>";
                    data = "<html><body><center><table style='border: 1px solid black;'>";
                    data += "<tr><td>NAME</td><td>"+calDet.Name()+"</td></tr>";
                data += "<tr><td>Date and Time of Birth</td><td>"+calDet.DOB()+"</td></tr>";
                data += "<tr><td>UTC</td><td>"+calDet.SRtime()+"</td></tr>";
                data += "<tr><td>Sunrise</td><td>"+calDet.SunRise(sd_forSR,geopos)+"</td></tr>";
                data += "<tr><td>Sunset</td><td>"+calDet.SunSet(sd,geopos)+"</td></tr>";
                data += "<tr><td>Nakshatra</td><td>"+calDet.Name()+"</td></tr>";
                data += "<tr><td>Lagna</td><td>"+mRasi+"</td></tr>";
                data += "<tr><td>Yoga</td><td>"+mRasi+"</td></tr>";
                data += "<tr><td>Thithi</td><td>"+mRasi+"</td></tr>";
                data += "<tr><td>Ayamansa</td><td>"+mRasi+"</td></tr>";
                data+="</table>";
                data+="</center></body></html>";



                    DetailsEditor.setText(data);
                }
            });
    }
    public int derive(int a){
        int b = 30;
        while (b <= a){
            a = a-b;
        }
        return a;
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
        virgo.HHN.setValue(17);
        virgo.YYYYN.setValue(1993);
        virgo.MMN.setValue(9);
        virgo.DDN.setValue(16);
        virgo.MINN.setValue(55);
        virgo.LATN.setText("82.2475");
        virgo.LONN.setText("16.9891");
        Frame.setVisible(true);
        virgo.ChartTableEditor.setContentType("text/html");
        String data = "<html>";
        data+="<center>Please Press Generate Button<center>";
        data+="</html>";
        virgo.ChartTableEditor.setText(data);
    }
    public void PlacePlanet(String raasi,String planet){
        if (raasi.equals("Aries")){
            Aries.append(planet);
            Aries.append("\n");
        }
        else if(raasi.equals("Tarus")){
            Tarus.append(planet);
            Tarus.append("\n");
        }
        else if(raasi.equals("Gemini")){
            Gemini.append(planet);
            Gemini.append("\n");
        }
        else if(raasi.equals("Cancer")){
            Cancer.append(planet);
            Cancer.append("\n");
        }
        else if(raasi.equals("Leo")){
            Leo.append(planet);
            Leo.append("\n");
        }
        else if(raasi.equals("Virgo")){
            Virgo.append(planet);
            Virgo.append("\n");
        }
        else if(raasi.equals("Libra")){
            Libra.append(planet);
            Libra.append("\n");
        }
        else if(raasi.equals("Scorpio")){
            Scorpio.append(planet);
            Scorpio.append("\n");
        }
        else if(raasi.equals("Saggittarius")){
            Saggittarius.append(planet);
            Saggittarius.append("\n");
        }
        else if(raasi.equals("Capricorn")){
            Capricorn.append(planet);
            Capricorn.append("\n");
        }
        else if(raasi.equals("Aquarius")){
            Aquarius.append(planet);
            Aquarius.append("\n");
        }
        else if(raasi.equals("Pisces")){
            Pisces.append(planet);
            Pisces.append("\n");
        }

    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
