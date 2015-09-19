package com.keith.iooperation;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Keith on 9/19/15.
 */
public class FreezeAlien implements Serializable{
    public static void main (String args[]) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("X.file")
        );
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}

class Alien implements Serializable {}
