package com.keith.iooperation;

import java.io.*;

/**
 * Created by Keith on 9/10/15.
 */
public class BasicFileOutput {
    static String file = "/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/BasicFileOutput.out";
    public static void main (String args[]) {
        try {
            BufferedReader in  = new BufferedReader(
                    new StringReader(
                            BufferedInputFile.read("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/BasicFileOutput.java")
                    )
            );
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(file))
            );
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount++ + ": " + s);
            }
            out.close();
            System.out.println(BufferedInputFile.read(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
