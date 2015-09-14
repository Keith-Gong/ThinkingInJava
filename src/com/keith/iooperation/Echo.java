package com.keith.iooperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Keith on 9/12/15.
 */
public class Echo {
    public static void main (String args[]) throws IOException{
        BufferedReader sdin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while ((s = sdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
