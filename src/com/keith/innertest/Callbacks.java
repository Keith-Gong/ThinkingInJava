package com.keith.innertest;

/**
 * Created by Keith on 8/24/15.
 */
public class Callbacks {
    public static void main (String args[]) {
        Callee1 callee1 = new Callee1();
        Callee2 callee2 = new Callee2();
        MyIncrement.f(callee2);

        Caller caller1 = new Caller(callee1);
        Caller caller2 = new Caller(callee2.getCallbackReference());

        caller1.go();
        caller1.go();
        caller2.go();
    }
}

interface IncrementListener {
    void increment ();
}

class Callee1 implements IncrementListener {
    private int i = 0;
    @Override
    public void increment() {
        i++;
        System.out.println(i);
    }
}

class MyIncrement {
    public void increment () {
        System.out.println("Other operation");
    }
    static void f (MyIncrement increment) {
        increment.increment();
    }
}

class Callee2 extends MyIncrement {
    private int i = 0;
    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }
    private class Closure implements IncrementListener {

        @Override
        public void increment() {
            Callee2.this.increment();
        }
    }
    IncrementListener getCallbackReference () {
        return new Closure();
    }
}

class Caller {
    private IncrementListener callbackReference;
    Caller (IncrementListener listener) {
        this.callbackReference = listener;
    }
    void go () {
        callbackReference.increment();
    }
}
