package com.keith.container;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Keith on 9/3/15.
 */
public class CollectionDataTest {
    public static void main (String args[]) {
        Set<String> set = new LinkedHashSet<String>(
                new CollectionData<String>(new Government(), 15));
        set.addAll(CollectionData.list(new Government(), 15));
        System.out.println(set);
    }
}
class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(generator.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> generator, int quantity) {
        return new CollectionData<T>(generator, quantity);
    }

    public static void main (String args[]) {

    }
}

interface Generator<T> {
    T next();
}

class Government implements Generator<String> {
    String[] foundation = ("Strange women lying in ponds " + "distributing swords is no basis for a system of " +
    "government").split(" ");
    private int index;

    @Override
    public String next() {
        return foundation[index++];
    }
}
