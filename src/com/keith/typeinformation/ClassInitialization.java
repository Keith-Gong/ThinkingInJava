package com.keith.typeinformation;

import java.util.Random;

/**
 * Created by keith on 8/25/2015.
 */
public class ClassInitialization {
    public static Random rand = new Random(47);
    public static void main (String args[]) {
        Class initable = Initable.class;
        System.out.println("After creating initable ref");
        System.out.format("%d\n", Initable.STATIC_FINAL);
        System.out.format("%d\n", Initable.STATIC_FINAL_2);
        System.out.format("%d\n", Initable2.staticNonFinal);
        try {
            Class initable3 = Class.forName("typeinformation.Initable3");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("After creating initable3 ref");
        System.out.format("%d\n", Initable3.staticNonFinal);
    }
}

class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL_2 =
            ClassInitialization.rand.nextInt(100);
    static {
        System.out.format("Initializing Initable\n");
    }
}

class Initable2 {
    static int staticNonFinal = 147;
    static {
        System.out.format("Initializing Initable2\n");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.format("Initializing Initable3\n");
    }
}


