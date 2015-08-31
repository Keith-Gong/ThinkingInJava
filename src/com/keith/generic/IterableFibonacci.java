package com.keith.generic;

import java.util.Iterator;

/**
 * Created by Keith on 8/29/15.
 */
public class IterableFibonacci extends Fibonacci implements Iterable<Integer>{
    private int n;
    public IterableFibonacci (int n) {
        this.n = n;
    }

    public static void main (String args[]) {

    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
}


