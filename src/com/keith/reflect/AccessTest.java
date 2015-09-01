package com.keith.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by keith on 8/27/2015.
 */
public class AccessTest {
    public static void main (String args[]) {
        A a = HiddenC.makeA();
        a.f();
    }

    static void CallHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException
            , IllegalAccessException {
        Method method = a.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(a);
    }
}

interface A {
    void f();
}

class C implements A {

    @Override
    public void f() {
        System.out.println("C.f()");
    }
    public void g() {
        System.out.println("C.g()");
    }
    void u() {
        System.out.println("C.u()");
    }
    private void v() {
        System.out.println("private C.v()");
    }
}

class HiddenC {
    public static A makeA () {
        return new C();
    }
}
