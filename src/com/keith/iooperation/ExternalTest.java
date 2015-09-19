package com.keith.iooperation;

import java.io.*;

/**
 * Created by Keith on 9/19/15.
 */
public class ExternalTest {
    public static void main (String args[]) throws Exception{
        System.out.println("Constructing objects: ");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Blips.out")
        );
        System.out.println("saving objects");
        out.writeObject(b1);
        out.writeObject(b2);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out")
        );
        System.out.println("Recovering b1");
        b1 = (Blip1) in.readObject();
        //System.out.println("Recovering b2");
        //b2 = (Blip2) in.readObject();

        System.out.println("--------Handling Blip3--------");
        Blip3 blip3 = new Blip3("A String", 3);
        System.out.println(blip3);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("Blip3.out")
        );
        System.out.println("Saving Blip3");
        objectOutputStream.writeObject(blip3);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("Blip3.out")
        );
        System.out.println("Recovering Blip3");
        blip3 = (Blip3) objectInputStream.readObject();
        System.out.println(blip3);


    }
}

class Blip1 implements Externalizable {
    public Blip1 () {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2 () {
        System.out.println("Blip2 Constructor");
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2.readExternal");
    }
}

class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3 () {
        System.out.println("Blip3 Constructor");
    }
    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    @Override
    public String toString() {
        return s + i;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        s = (String) in.readObject();
        i = in.readInt();
    }
}
