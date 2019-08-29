package com.allGUI;

import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;

public class ChartMaker {
    public int[] planets = { SweConst.SE_SUN,
            SweConst.SE_MOON,
            SweConst.SE_MARS,
            SweConst.SE_MERCURY,
            SweConst.SE_JUPITER,
            SweConst.SE_VENUS,
            SweConst.SE_SATURN,
            SweConst.SE_MEAN_NODE };	// Some systems prefer SE_MEAN_NODE
    //String plNams[] = {"Sun","Moon","Mars","Mercury","Jupiter","Venus","Saturn","","","","Rahu"};
    public static final String planetShortNames[] = {"SU", "MO", "ME", "VE", "MA", "JU", "SA", "UR", "NE", "PL", "RA", "KE"};
    /**
     *  Description of the Field
     */
    public static final String plNams[] = {"Sun", "Moon", "Mercury", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto", "Rahu", "Ketu"};

    public String plNams_tel[] = {"సన్", "మూన్", "మార్స్", "మెర్క్యురీ", "బృహస్పతి", "శుక్రుడు", "సాటర్న్", "", "", "", "రాహు"};
    int flags = SweConst.SEFLG_SWIEPH | SweConst.SEFLG_SPEED  | SweConst.SEFLG_SIDEREAL;
    //boolean retrograde = false;

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
    public String getPlanetPos(int planet, SweDate sd){
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


}
