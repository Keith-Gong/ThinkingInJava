package com.keith.datetest;

/**
 * Created by keith on 8/28/2015.
 */
public class InstanceTest {
    public static void main (String args[]) {
        A a = new B();
        if (a instanceof B) {
            System.out.println("~~~");

        }
    }
}

interface A {
    void a();
}

class B implements A {

    @Override
    public void a() {

    }
    public void b() {

    }
}