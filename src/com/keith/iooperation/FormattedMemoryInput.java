package com.keith.iooperation;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * Created by Keith on 9/9/15.
 */
public class FormattedMemoryInput {
    public static void main (String args[]) throws Exception{
        try {
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            BufferedInputFile.read("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/" +
                                    "FormattedMemoryInput.java").getBytes()));
            while(true)
                System.out.print((char)in.readByte());
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
