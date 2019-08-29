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
    private static double getDiff(double sunLon, double moonLon) {
        double diff = moonLon - sunLon;
        if (diff < 0)
            diff = diff + 360;
        return diff;
    }
    private static double getSum(double sunLon, double moonLon) {
        double sum = moonLon + sunLon;
        return sum % 360;
    }
    public static String calculateTithi(double diff) {
        int ti = (int) (diff / 12)-1;
        //classical calculation involves adding a one here; stripped because of array positions
        if(ti<0){
            ti=0;
        }
        String[] tithiNames =
                {
                        "1. Pratipat",
                        "2. Dvitiya",
                        "3. Tritiya",
                        "4. Chaturthi",
                        "5. Panchami",
                        "6. Shashti",
                        "7. Saptami",
                        "8. Ashtami",
                        "9. Navami",
                        "10. Dashami",
                        "11. Ekadashi",
                        "12. Dvadashi",
                        "13. Trayodashi",
                        "14. Chaturdashi",
                        "15. Purnima",
                        "1. Pratipat",
                        "2. Dvitiya",
                        "3. Tritiya",
                        "4. Chaturthi",
                        "5. Panchami",
                        "6. Shashti",
                        "7. Saptami",
                        "8. Ashtami",
                        "9. Navami",
                        "10. Dashami",
                        "11. Ekadashi",
                        "12. Dvadashi",
                        "13. Trayodashi",
                        "14. Chaturdashi",
                        "15. Amavasya" };
        if (ti < 15)
            tithi = tithiNames[ti] + ", " + "Shukla paksha";
        else if (15 <= ti)
            tithi = tithiNames[ti] + ", " + "Krishna paksha";
        return tithi;
    }
    public static String calculateKarana(double diff) {
        int ka = (int) (diff / 6);
        //classical calculation involves adding a one here; stripped because of array positions
        if(ka<0){
            ka=0;
        }
        String[] karanaNames =
                {
                        "1. Kinstughna",
                        "2. Bava",
                        "3. Balava",
                        "4. Kaulava",
                        "5. Taitila",
                        "6. Gara",
                        "7. Vanija",
                        "8. Vishti",
                        "9. Bava",
                        "10. Balava",
                        "11. Kaulava",
                        "12. Taitila",
                        "13. Gara",
                        "14. Vanija",
                        "15. Vishti",
                        "16. Bava",
                        "17. Balava",
                        "18. Kaulava",
                        "19. Taitila",
                        "20. Gara",
                        "21. Vanija",
                        "22. Vishti",
                        "23. Bava",
                        "24. Balava",
                        "24. Kaulava",
                        "26. Taitila",
                        "27. Gara",
                        "28. Vanija",
                        "29. Vishti",
                        "30. Bava",
                        "31. Balava",
                        "32. Kaulava",
                        "33. Taitila",
                        "34. Gara",
                        "35. Vanija",
                        "36. Vishti",
                        "37. Bava",
                        "38. Balava",
                        "39. Kaulava",
                        "40. Taitila",
                        "41. Gara",
                        "42. Vanija",
                        "43. Vishti",
                        "44. Bava",
                        "45. Balava",
                        "46. Kaulava",
                        "47. Taitila",
                        "48. Gara",
                        "49. Vanija",
                        "50. Vishti",
                        "51. Bava",
                        "52. Balava",
                        "53. Kaulava",
                        "54. Taitila",
                        "55. Gara",
                        "56. Vanija",
                        "57. Vishti",
                        "58. Shakuni",
                        "Chatushpada",
                        "Naga" };
        return karanaNames[ka];
    }
    public static String calculateYoga(double sum) {
        int yo = (int) (sum / (13 + 1 / 3))-1;
        if(yo<0){
            yo=0;
        }
        String[] yogaNames =
                {
                        "1. Vishkambha",
                        "2. Priti",
                        "3. Ayushman",
                        "4. Saubhagya",
                        "5. Shobhana",
                        "6. Atiganda",
                        "7. Sukarma",
                        "8. Dhriti",
                        "9. Shula",
                        "10. Ganda",
                        "11. Vriddhi",
                        "12. Dhruva",
                        "13. Vyaghata",
                        "14. Harshana",
                        "15. Vajra",
                        "16. Siddhi",
                        "17. Vyatipat",
                        "18. Variyana",
                        "19. Parigha",
                        "20. Shiva",
                        "21. Siddha",
                        "22. Sadhya",
                        "23. Shubha",
                        "24. Shukla",
                        "25. Brahma",
                        "26. Indra",
                        "27. Vaidhriti" };
        return yogaNames[yo];
    }
    public static double calculateAyanamsa(SwissEph sw, double tjd_ut) {
        return sw.swe_get_ayanamsa_ut(tjd_ut);
    }


    public static int calculateNakshatra(double moonlog)
    {

        int i = (int) (moonlog / (13.333333)-1);
        if(i<0){
            i=0;
        }
        return i;
    }

    public static String calculatePada (double lon)//returns nakshatra pada
    {
        String pada = "0";
        lon = lon%13.333333333;
        if (0.0<=lon&&lon<3.333333333)pada = "1";
        if (3.333333333<=lon&&lon<6.666666666)pada = "2";
        if (6.666666666<=lon&&lon<10.0) pada = "3";
        if (10.0<=lon&&lon<13.333333333) pada = "4";
        return pada;
    }

}
