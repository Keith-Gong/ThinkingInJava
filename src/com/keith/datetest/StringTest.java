package com.keith.datetest;

/**
 * Created by keith on 8/28/2015.
 */
public class StringTest {
    public static void main (String args[]) {
        String a = "ABC";
        String b = "ABC";
        a.intern();
        if (a == b) {
            System.out.println("%d, true");
        } else {
            System.out.println("%d, false");
        }
    }
}
