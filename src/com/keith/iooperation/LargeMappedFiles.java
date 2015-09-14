package com.keith.iooperation;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Keith on 9/12/15.
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF;
    public static void main (String args[]) throws Exception{
        MappedByteBuffer out = new RandomAccessFile("/Users/Keith/GitHub/ThinkingInJava/src/com/keith/iooperation/rtest.dat", "rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for (int i = 0; i < length; i ++) {
            out.put((byte)'x');
        }
        System.out.println("Finished-----");
        for (int i = length/2; i < length/2 + 6; i++) {
            System.out.println(out.get(i));
        }
    }
}
