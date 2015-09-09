package com.keith.iooperation;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * Created by Keith on 9/10/15.
 */
public class TestEOF {
    public static void main (String args[]) throws Exception{
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/TestEOF.java")
                )
        );

        while (in.available() != 0) {
            System.out.print((char)in.readByte());
        }
    }
}
