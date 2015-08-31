package com.keith.generic;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by Keith on 8/29/15.
 */
public class GeneratorTest {
    public static void main (String args[]) {

    }
}

interface Generator <T> {
    T next ();
}

class Coffee {
    private static long counter = 0;
    private final long id = counter ++;
    public String toString () {
        return getClass().getSimpleName() + " " + id;
    }
}

class Latte extends Coffee {

}

class Mocha extends Coffee {

}

class Cappuccino extends Coffee {

}

class Americano extends Coffee {

}

class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class};
    private static Random rand = new Random(47);
    public CoffeeGenerator () {

    }
    private int size = 0;
    public CoffeeGenerator (int size) {
        this.size = size;
    }


    @Override
    public Coffee next() {
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext () {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }
}

class Fibonacci implements Generator<Integer> {
    private int count = 0;
    @Override
    public Integer next() {
        return fib(count++);
    }

    public int fib (int n) {
        if (n < 2) {
            return 1;
        } else {
          return fib(n-2) + fib(n-1);
        }
    }
}
