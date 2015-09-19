package com.keith.iooperation;

import java.io.*;
import java.util.Random;

/**
 * Created by Keith on 9/19/15.
 */
public class SerializableTest {
    public static void main (String args[]) throws Exception{
        Worm worm = new Worm(6, 'a');
        System.out.println("w = " + worm);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Worm out")
        );
        out.writeObject("Worm storage\n");
        out.writeObject(worm);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Worm out")
        );
        String s = (String) in.readObject();
        Worm worm1 = (Worm) in.readObject();
        System.out.println(s + "worm1 = " + worm1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(byteArrayOutputStream);
        out2.writeObject("Worm storage\n");
        out2.writeObject(worm);
        out2.flush();

        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        );
        s = (String) in2.readObject();
        Worm w3 = (Worm) in2.readObject();
        System.out.println(s + "w3 = " + w3);
    }
}

class Data implements Serializable {
    private int n;
    public Data (int n) {
        this.n = n;
    }
    public String toString () {
        return Integer.toString(n);
    }
}

class Worm implements Serializable {
    private static Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;
    public Worm(int i, char x) {
        System.out.println("Worm constructor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char)(x + 1));
    }
    public Worm() {
        System.out.println("Default constructor");
    }
    public String toString () {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d) {
            result.append(data);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }
}