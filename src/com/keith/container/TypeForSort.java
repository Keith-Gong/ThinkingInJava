package com.keith.container;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * Created by keith on 9/6/2015.
 */
public class TypeForSort {

    static <T> Set<T> fill(Set<T> set, Class<T> type) {
        for (int i = 0; i < 10; i++) {
            try {
                set.add(type.getConstructor(int.class).newInstance(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return set;
    }
    public static void main (String args[]) {

    }
}

class SetType {
    int i;
    public SetType (int n) {
        i = n;
    }
    public boolean equals (Object o) {
        return o instanceof SetType && (i == ((SetType)o).i);
    }

    public String toString () {
        return Integer.toString(i);
    }
}

class HashType extends  SetType {

    public HashType(int n) {
        super(n);
    }
    public int hashCode () {
        return i;
    }
}

class TreeType extends SetType implements Comparable<TreeType>{

    public TreeType(int n) {
        super(n);
    }

    @Override
    public int compareTo(TreeType arg) {
        return (arg.i < i ? -1 : (arg.i == i ? 0 : 1));
    }
}
