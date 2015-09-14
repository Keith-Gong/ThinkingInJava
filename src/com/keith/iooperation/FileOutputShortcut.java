package com.keith.iooperation;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * Created by Keith on 9/12/15.
 */
public class FileOutputShortcut {
    static String file = "/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/FileOutputShortcut.out";
    public static void main (String args[]) {
        try {
            BufferedReader in = new BufferedReader(
                    new StringReader(
                            BufferedInputFile.read("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/FileOutputShortcut.java")
                    )
            );
            PrintWriter out = new PrintWriter(file);
            int lineCount = 1;
            String s;
            while ((s = in.readLine()) != null) {
                out.println(lineCount ++ + ": " + s);
            }
            out.close();
            System.out.println(BufferedInputFile.read(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
