package com.keith.innerclass;

/**
 * Created by keith on 8/24/2015.
 */
public class Factory {
    public static void serviceConsumer (ServiceFactory factory) {
        Service service = factory.getService();
        service.method1();
        service.method2();
    }
    public static void main (String args[]) {
        serviceConsumer(ConcreteService1.factory);
    }
}

interface Service {
    void method1 ();
    void method2 ();
}

interface ServiceFactory {
    Service getService ();
}

class ConcreteService1 implements Service {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ConcreteService1();
        }
    };
}

class ConcreteService2 implements Service {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    public static ServiceFactory factory = new ServiceFactory() {
        @Override
        public Service getService() {
            return new ConcreteService2();
        }
    };
}