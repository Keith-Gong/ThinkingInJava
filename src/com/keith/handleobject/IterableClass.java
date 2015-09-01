package com.keith.handleobject;

import java.util.Iterator;

/**
 * Created by keith on 8/25/2015.
 */
public class IterableClass implements Iterable<String>{
    public static void main (String args[]) {
        for (String s : new IterableClass()) {

        }
    }

    protected String[] words = ("And that is how" + "we know the Earth to be banana-shaped").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

        };
    }

}
