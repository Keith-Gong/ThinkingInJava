package com.keith.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by keith on 9/7/2015.
 */
public class Synchronization {
    public static void main (String args[]) {
        Collection<String> c = Collections.synchronizedList(new ArrayList<String>());
        Iterator<String> it = c.iterator();
        c.add("a");
        String s = it.next();
    }
}
