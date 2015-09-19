package com.keith.iooperation;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Keith on 9/19/15.
 */
public class Logon implements Serializable {
    private Date date = new Date();
    private String userName;
    private transient String password;
    public Logon(String name, String pwd) {
        userName = name;
        password = pwd;
    }
    public String toString () {
        return "logon info: \n username: " + userName + "\n date: " + date + "\n password: " + password;
    }
    public static void main (String args[]) throws Exception{
        Logon logon = new Logon("Hulk", "myLittlePony");
        System.out.println("Logon logan = " + logon);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Logon.out")
        );
        out.writeObject(logon);
        out.close();

        TimeUnit.SECONDS.sleep(1);
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Logon.out")
        );
        System.out.println("Recovering object at " + new Date());
        logon = (Logon) in.readObject();
        System.out.println("logon logon = " + logon);
    }
}
