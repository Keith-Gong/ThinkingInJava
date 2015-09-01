package com.keith.innerclass;

/**
 * Created by keith on 8/24/2015.
 */
public class Outer {
    public static void main (String args[]) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.getInner();
    }
    class Inner {

    }
    public Inner getInner () {
        return new Inner();
    }
}
