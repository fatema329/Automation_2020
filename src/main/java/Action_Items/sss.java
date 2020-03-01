package Action_Items;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class sss {

    public static void main(String[] args) {

        /*SimpleDateFormat sdf = new SimpleDateFormat("HH");
        Calendar cal = Calendar.getInstance(); // creates calendar
        //cal.setTime(new Date()); // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 1); // adds one hour
        cal.getTime(); // returns new date object, one hour in the future
        System.out.println(cal.getTime());*/
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.add(Calendar.DAY_OF_WEEK,2);
        String abc = sdf.format(cal.getTime());
        System.out.println("Weekday: " + abc);

        String currentHour = dateInHour("h",0);
        String hour2 = dateInHour("h",2 );
        //System.out.println(hour2);
        String hour4 = dateInHour("h",4);
        //System.out.println(hour4);
        String hour6 = dateInHour("h",6);
        //System.out.println(hour6);



    }//end of main

    public static String dateInHour(String dateFormat,int numberOfHour){
        SimpleDateFormat simpDate = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        date.setHours(date.getHours() + numberOfHour);
        String hour = simpDate.format((date)).toString();
        //System.out.println(hour);
        return  hour;
    }

    public static String dateInDays(String dateFormat,int numberOfDays){
        Date date = new Date();
        date.setHours(date.getHours() + numberOfDays);
        SimpleDateFormat simpDate = new SimpleDateFormat(dateFormat); // the day of the week abbreviated
        String day = simpDate.format((date)).toString();
        //System.out.println(simpDate.format(date));
        return  day;
    }




}
