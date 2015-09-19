package com.keith.typeinformation;

/**
 * Created by Keith on 8/26/15.
 */

/**
 * Simple proxy pattern
 */
public class ProxyDemo {
    public static void main (String args[]) {
        //consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
    public static void consumer (Callback callback) {
        callback.doSomething();
        callback.somethingElse();
    }
}

interface Callback {
    void doSomething ();
    void somethingElse ();
}

class RealObject implements Callback {

    @Override
    public void doSomething() {
        System.out.println("Real do");
    }

    @Override
    public void somethingElse() {
        System.out.println("Real something else");
    }
}

class SimpleProxy implements Callback {
    private Callback callback;
    public SimpleProxy (Callback callback) {
        this.callback = callback;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy do");
        callback.doSomething();
    }

    @Override
    public void somethingElse() {
        System.out.println("SimpleProxy something else");
        callback.somethingElse();
    }
}
