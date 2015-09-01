package com.keith.datetest;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by keith on 8/26/2015.
 */
public class DateTest {
    public static void main (String args[]) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
       // c1.add(Calendar.DAY_OF_MONTH, 2);
        c1.add(Calendar.MINUTE, -1);
        c1.set(Calendar.MILLISECOND, 0);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        c2.set(Calendar.MILLISECOND, 0);

        System.out.print(String.valueOf(c1.getTimeInMillis() - c2.getTimeInMillis()));
    }
}
