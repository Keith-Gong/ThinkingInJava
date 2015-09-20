package com.keith.enumtype;

import java.util.EnumSet;
import static com.keith.enumtype.AlarmPoints.*;

/**
 * Created by Keith on 9/20/15.
 */
public class EnumSets {
    public static void main (String args[]) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }
}

enum AlarmPoints {
    STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
    OFFICE4, BATHROOM, UTILITY, KITCHEN,COMMAND;
}