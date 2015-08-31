package com.keith.generic;

/**
 * Created by Keith on 8/29/15.
 */
public class InnerTest {
    public static void main(String args[]) {

    }
}
class Consumer {
    private static long counter = 1;
    private final long ID = counter++;
    private Consumer() {}
    public String toString() {
        return "Consumer" + ID;
    }


    public static Generator<Consumer> generator () {
        return new Generator<Consumer>() {
            @Override
            public Consumer next() {
                return new Consumer();
            }
        };
    }
}

class Teller {
    private static long counter = 1;
    private final long ID = counter++;
    public String toString () {
        return "Teller" + String.valueOf(ID);
    }
    private Teller() {}

    public static Generator<Teller> getGenerator = new Generator<Teller>() {
        @Override
        public Teller next() {
            return new Teller();
        }
    };
}
