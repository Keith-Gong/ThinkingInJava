package com.keith.iooperation;

import java.io.StringReader;

/**
 * Created by Keith on 9/9/15.
 */
public class MemoryInput{
    public static void main (String args[]) throws Exception{
        StringReader in = new StringReader(
                BufferedInputFile.read("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/MemoryInput.java")
        );
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
    }
}
