package com.keith.interfacetest;

import java.util.Objects;

/**
 * Created by Keith on 8/23/15.
 */
public class Apply {
    public static void process (Process p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static String s = "ABcdEFg";
    public static void main (String args[]) {
        process(new Upcase(), s);
        process(new Downcase(), s);
    }
}

class Process {
    public String name () {
        return getClass().getSimpleName();
    }
    Object process (Object input) {
        System.out.print("Const");
        return input;
    }

}

class Upcase extends Process {
    @Override
    String process (Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Process {
    String process (Object input) {
        return ((String)input).toLowerCase();
    }
}
