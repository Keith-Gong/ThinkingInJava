package com.keith.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by keith on 8/27/2015.
 */
public class SimpleDynamicProxy {
    public static void main (String args[]) {
        IChange proxy = (IChange) Proxy.newProxyInstance(
                IChange.class.getClassLoader(),
                new Class[] {IChange.class},
                new DynamicHandler(new ConcreteChange()));
        proxy.fun1();
    }
}

interface IChange {
    void fun1 ();
    void fun2 ();
}

class DynamicHandler implements InvocationHandler {
    private Object proxied;
    public DynamicHandler (Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(proxied, args);
    }
}

class ConcreteChange implements IChange {

    @Override
    public void fun1() {
        System.out.println("fun1");
    }

    @Override
    public void fun2() {
        System.out.println("fun2");
    }
}
