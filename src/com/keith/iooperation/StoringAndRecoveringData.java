package com.keith.iooperation;

import java.io.*;

/**
 * Created by Keith on 9/12/15.
 */
public class StoringAndRecoveringData {
    public static void main (String args[]) {
        try {
            DataOutputStream out = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/Data.txt"))
            );
            out.writeDouble(3.14159);
            out.writeUTF("That was Pi");
            out.writeDouble(1.41413);
            out.writeUTF("Square root of 2");
            out.close();

            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(new FileInputStream("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/Data.txt"))
            );
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
