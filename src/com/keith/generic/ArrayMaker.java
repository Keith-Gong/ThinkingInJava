package com.keith.generic;

import java.lang.reflect.Array;

/**
 * Created by Keith on 8/29/15.
 */
public class ArrayMaker<T> {
    private Class<T> kind;
    public ArrayMaker (Class<T> kind) {
        this.kind = kind;
    }

    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }
    public static void main(String args[]) {
        ArrayMaker<String> stringArrayMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringArrayMaker.create(9);
    }
}
