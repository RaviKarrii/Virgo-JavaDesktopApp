package com.allGUI;

import javax.swing.*;

import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;

public class Chart {

    int Y,M,D,HH,MM,SS;
    String Name;
    Chart(String Name, int Y,int M,int D,int HH,int MM,int SS){
        this.Y = Y;
        this.M = M;
        this.D = D;
        this.HH = HH;
        this.MM = MM;
        this.SS = SS;
        this.Name = Name;
        System.out.println(SS);
    }
    public JPanel Main;
    private JTextArea Pisces;
    private JTextArea Gemini;
    private JTextArea Aries;
    private JTextArea Saggittarius;
    private JTextArea Aquarius;
    private JTextArea Scorpio;
    private JTextArea Cancer;
    private JTextArea Virgo;
    private JTextArea Tarus;
    private JTextArea Libra;
    private JTextArea Capricorn;
    private JTextArea Leo;
    private JPanel Chart;
    private JTextArea Center;
    public String city;
    int[] planets = { SweConst.SE_SUN,
            SweConst.SE_MOON,
            SweConst.SE_MARS,
            SweConst.SE_MERCURY,
            SweConst.SE_JUPITER,
            SweConst.SE_VENUS,
            SweConst.SE_SATURN,
            SweConst.SE_MEAN_NODE };	// Some systems prefer SE_MEAN_NODE
    String plNams[] = {"Sun","Moon","Mars","Mercury","Jupiter","Venus","Saturn","","","","Rahu"};
    int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED  | SweConst.SEFLG_SIDEREAL;
    //boolean retrograde = false;
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
    public String RaasiFinder(int angle)
    {
        if (angle >= 0 && angle < 30){
            return "Aries";
        }
        else if (angle >= 30 && angle < 60){
            return "Taurus";
        }
        else if (angle >= 60 && angle < 90){
            return "Gemini";
        }
        else if (angle >= 90 && angle < 120){
            return "Cancer";
        }
        else if (angle >= 120 && angle < 150){
            return "Leo";
        }
        else if (angle >= 150 && angle < 180){
            return "Virgo";
        }
        else if (angle >= 180 && angle < 210){
            return "Libra";
        }
        else if (angle >= 210 && angle < 240){
            return "Scorpio";
        }
        else if (angle >= 240 && angle < 270){
            return "Saggittarius";
        }
        else if (angle >= 270 && angle < 300){
            return "Capricorn";
        }
        else if (angle >= 300 && angle < 330){
            return "Aquarius";
        }
        else if (angle >= 330 && angle < 360){
            return "Pisces";
        }
        return "";
    }
    private String dms(double val){
        String res = new String();
        if (val < 0){
            val = Math.abs(val);
            res = res + "-";
        }
        int deg = (int)val;
        //System.out.print(deg+" : ");
        double mindob = (val-deg)* 60;
        int min = (int)(mindob);
        int sec = (int)((mindob - min)*60);
        //System.out.println(min+" : "+sec);
        res = res + deg+":"+min+":"+sec;
        return res;
    }
    public String getPlanetPos(int planet,SweDate sd){
        SwissEph sw = new SwissEph();
        int rc;
        sw.swe_set_sid_mode(1,0,0);
        double[] res=new double[6];
        StringBuffer sbErr=new StringBuffer();
        rc=sw.swe_calc_ut(sd.getJulDay() ,
                planet,
                flags,
                res,
                sbErr);
        System.out.println(plNams[planet]+" - " + dms(res[0]) );
        return plNams[planet]+":" + dms(res[0]);
    }
    public static double decimal( int deg, int min, int sec ) {

        double temp = ( ( ( deg * 60 ) + min ) * 60 ) + sec;
        double res = ( double ) ( temp / 3600 );

        //System.out.println("res " + res);
        return res;

    }

    public void start() {
        //System.out.println("Ravi");
        //double time = (1 + (44.00/60.00)) - 5.5 ;
        double time = decimal(HH,MM,SS);
        //System.out.println(HH);
        SweDate sd=new SweDate(Y,M,D,time);

        for(int number: planets){
            //System.out.println(number);
            String PLDET = getPlanetPos(number,sd);
            String[] arr = PLDET.split(":");
            String raasi = RaasiFinder(Integer.parseInt(arr[1].trim()));
            PlacePlanet(raasi,arr[0]);
        }

        Center.append(Name);
        }
    }

