package com.keith.array;

import java.util.List;

/**
 * Created by keith on 9/2/2015.
 */
public class ParameterizedArrayType {
    public static void main (String args[]) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Integer[] integers12 = new ClassParameter<Integer> ().f(integers);

    }
}

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}


