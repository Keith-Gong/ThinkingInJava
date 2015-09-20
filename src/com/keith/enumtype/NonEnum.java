package com.keith.enumtype;

/**
 * Created by Keith on 9/20/15.
 */
public class NonEnum {
    public static void main (String args[]) {
        Class<Integer> intClass = Integer.class;
        for (Object en : intClass.getEnumConstants()) {
            System.out.println(en);
        }
    }
}

enum Test {
    TEST1, TEST2
}
