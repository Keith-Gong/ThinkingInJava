package com.keith.innertest;

import java.util.Timer;

/**
 * Created by Keith on 8/24/15.
 */
public class InnerExtends {
    public static void main (String args[]) {
        InnerSon innerSon = new InnerSon(new InnerHolder(8));
    }
}

class InnerHolder {
    class Inner {
        public Inner (int i) {
            i++;
            System.out.println("inner " + String.valueOf(i));
        }
    }

    public InnerHolder (int i ) {
        i--;
        System.out.println("InnerHolder " + String.valueOf(i));
    }
    Timer timer;
}

class InnerSon extends InnerHolder.Inner {
    public InnerSon (InnerHolder innerHolder) {
        innerHolder.super(2);
    }
}