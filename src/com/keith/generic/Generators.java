package com.keith.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Keith on 8/29/15.
 */
public class Generators {
    public static void main (String args[]) {
        Collection<Coffee> coffee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : coffee) {
            System.out.print(c);
        }
        Collection<Integer> numbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(i + " ");
        }
    }

    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int n) {
        for (int i = 0; i < n; i++) {
            collection.add(generator.next());
        }
        return collection;
    }
}
