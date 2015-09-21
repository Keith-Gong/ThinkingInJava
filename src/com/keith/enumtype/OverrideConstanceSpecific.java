package com.keith.enumtype;

/**
 * Created by Keith on 9/21/15.
 */
public enum OverrideConstanceSpecific {
    NUT, BOLT;
    /*WASHER {
        void f () {
            System.out.println("Override method");
        }
    };*/
    void f () {
        System.out.println("default");
    }
    public static void main (String args[]) {
        for (OverrideConstanceSpecific overrideConstanceSpecific : values()) {
            System.out.println(overrideConstanceSpecific + ": ");
            overrideConstanceSpecific.f();
        }
    }
}
