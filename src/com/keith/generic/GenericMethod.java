package com.keith.generic;

/**
 * Created by Keith on 8/29/15.
 */
public class GenericMethod {
    public static void main (String args[]) {
        GenericMethod gm = new GenericMethod();
        gm.f("");
        gm.f(1);
        gm.f(1f);
        gm.f(1.0);
        gm.f(gm);
    }

    public <T> void f (T x) {
        System.out.println(x.getClass().getSimpleName());
    }
}

