package com.keith.typeinformation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Keith on 8/27/15.
 */
public class SelectingMethod {
    public static void main (String args[]) {
        CallbackFunction proxy = (CallbackFunction) Proxy.newProxyInstance(
                CallbackFunction.class.getClassLoader(),
                new Class[] {CallbackFunction.class},
                new MethodSelector(new ConcreteFunction()));
        proxy.fun1();
        proxy.fun2();
        proxy.fun3();
    }
}

class MethodSelector implements InvocationHandler {
    private Object proxied;
    public MethodSelector (Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy : " + proxy.getClass() + ", method : " + method + ", args : " + args);
        if (method.getName().equals("fun1")) {
            System.out.println("Catch fun1");
        }
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}

interface CallbackFunction {
    void fun1();
    void fun2();
    void fun3();
}

class ConcreteFunction implements CallbackFunction {

    @Override
    public void fun1() {
        System.out.println("fun1~~~~~");
    }

    @Override
    public void fun2() {
        System.out.println("fun2~~~~~");
    }

    @Override
    public void fun3() {
        System.out.println("fun3~~~~~");
    }
}
