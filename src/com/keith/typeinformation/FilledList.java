package com.keith.typeinformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keith on 8/25/15.
 */
public class FilledList<T> {
    private Class<T> type;
    public FilledList(Class<T> type) {
        this.type = type;
    }
    public List<T> create (int nElements) {
        List<T> result = new ArrayList<T>();
        try {
            for (int i = 0; i < nElements; i++) {
                result.add(type.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main (String args[]) {
        FilledList<CountInteger> f1 = new FilledList<>(CountInteger.class);
        System.out.println(f1.create(15));
    }
}

class CountInteger {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return Long.toString(id);
    }
}
