package com.allGUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import swisseph.SweConst;
import swisseph.SweDate;
import swisseph.SwissEph;
import swisseph.*;
import swisseph.SwissephException;

public class CalculateDetails {
    int YYYY,MM,DD,HH,MIN,SS,LAT,LON;
    String NAME;
    void CalculateDetails(String NAME,String YYYY,String MM,String DD,String HH,String MIN,String SS,String LAT,String LON){
        this.YYYY = Integer.parseInt(YYYY);
        this.MM = Integer.parseInt(MM);
        this.DD = Integer.parseInt(DD);
        this.HH = Integer.parseInt(HH);
        this.MIN = Integer.parseInt(MIN);
        this.SS = Integer.parseInt(SS);
        this.NAME = NAME;
    }
    public String Name()
    {
        return this.NAME;
    }
    public String DOB()
    {
        String sDate6 = DD+"-"+MM+"-"+YYYY+" "+HH+":"+MIN+":"+SS;//"31-12-1998 23:37:50";
        SimpleDateFormat formatter6=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date DT  = Calendar.getInstance().getTime(); ;
        try {
            DT = formatter6.parse(sDate6);
        }
        catch(Exception e) {
        }
        return formatter6.format(DT);
    }
    private String TZcalc(){
        return "IST";
        //Need to write
    }
    public String SRtime(){
        String input = DD+"-"+MM+"-"+YYYY+" "+HH+":"+MIN+":"+SS;//"31-12-1998 23:37:50";
        DateFormat dfNy = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfNy.setTimeZone(TimeZone.getTimeZone(TZcalc()));
        DateFormat dfUtc = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.ROOT);
        dfUtc.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            return dfUtc.format(dfNy.parse(input));
        } catch (Exception e) {
                         // invalid input
        }return "";
    }
    public String SunRise(SweDate sd,double[] geopos){
        DblObj ret = new DblObj();
        StringBuffer serr =new StringBuffer("");
        SwissEph sw = new SwissEph();
        sw.swe_rise_trans(sd.getJulDay(),SweConst.SE_SUN,null,SweConst.SEFLG_SWIEPH,SweConst.SE_CALC_RISE,geopos,0,0,ret,serr);

        System.out.println(sd.getDate(ret.val));
        return sd.getDate(ret.val).toString();

        //Need to write
    }
    public String SunSet(SweDate sd,double[] geopos){
        DblObj ret = new DblObj();
        StringBuffer serr =new StringBuffer("");
        SwissEph sw = new SwissEph();
        sw.swe_rise_trans(sd.getJulDay(),SweConst.SE_SUN,null,SweConst.SEFLG_SWIEPH,SweConst.SE_CALC_SET,geopos,0,0,ret,serr);

        System.out.println(sd.getDate(ret.val));
        return sd.getDate(ret.val).toString();

        //Need to write
    }


}
