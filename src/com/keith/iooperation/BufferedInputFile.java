package com.keith.iooperation;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Keith on 9/9/15.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws Exception{
        BufferedReader in = new BufferedReader(
                new FileReader(fileName)
        );
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null)
            sb.append(s + "\n");
        in.close();
        return sb.toString();
    }
    public static void main(String args[]) throws Exception{
        System.out.println(read("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/BufferedInputFile.java"));
    }
}
