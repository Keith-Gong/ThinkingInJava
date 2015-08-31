package com.keith.type.information;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Keith on 8/26/15.
 */
public class DynamicProxy {
    public static void main (String args[]) {
        RealObject realObject = new RealObject();
        consumer(realObject);

        //Insert a proxy and call again
        Callback proxy = (Callback) Proxy.newProxyInstance(
                Callback.class.getClassLoader(),
                new Class[] {Callback.class},
                new DynamicProxyHandler(realObject));
        consumer(proxy);
    }

    public static void consumer (Callback callback) {
        callback.doSomething();
        callback.somethingElse();
    }
}

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;
    public DynamicProxyHandler (Object proxied) {
        this.proxied = proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy : " + proxy.getClass() + ", method : " + method + ", args : " + args);
        if (args != null) {
            for (Object arg : args) {
                System.out.println(" " + arg);
            }
        }
        return method.invoke(proxied, args);
    }
}
