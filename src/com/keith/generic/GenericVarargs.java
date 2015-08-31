package com.keith.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 8/29/15.
 */
public class GenericVarargs {
    public static void main (String args[]) {
        List<String> list = makeList("A","b");
        List<Integer> list1 = makeList(1,2,3,4);
        System.out.println(list1);
    }

    public static <T> List<T> makeList (T...args) {
        List<T> result = new ArrayList<T>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }
}
