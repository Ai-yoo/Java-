package util;

import domain.User;

import java.util.Calendar;
import java.util.Date;

public class T {
    public static void main(String[] args) {
        String str = "a";
        String s1 = new String("b");
        System.out.println(s1);
        Date date = new Date();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println(date1.getTime()/1000);

        System.out.println(date.getTime()/1000-(date1.getTime()/1000));
        System.out.println(3*60*60);

        Calendar calendar = Calendar.getInstance();
        calendar.getTimeInMillis();
        int hour =calendar.get(Calendar.HOUR_OF_DAY);
        int minute =calendar.get(Calendar.MINUTE);
        int seconds =calendar.get(Calendar.SECOND);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(seconds);
    }
}
