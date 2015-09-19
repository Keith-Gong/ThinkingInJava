package com.keith.iooperation;

import java.io.*;

/**
 * Created by Keith on 9/19/15.
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;
    public SerialCtl(String a, String b) {
        this.a = "No transient " + a;
        this.b = "Transient " + b;
    }
    public String toString () {
        return a + "\n" + b;
    }
    private void writeObject(ObjectOutputStream stream) throws Exception{
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws Exception {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }
    public static void main (String args[]) throws Exception{
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before : \n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(buf);
        out.writeObject(sc);

        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray())
        );
        SerialCtl sc2 = (SerialCtl) in.readObject();
        System.out.println("After : \n" + sc2);
    }
}
