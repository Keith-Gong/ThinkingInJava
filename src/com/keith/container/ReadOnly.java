package com.keith.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by keith on 9/7/2015.
 */
public class ReadOnly {
    static Collection<String> data = new ArrayList<String>(Countries.names(6));

    public static void main (String args[]) {
        Collection<String> collection = Collections.unmodifiableList(new ArrayList<String>(data));

        System.out.println(collection);
        collection.add("Add");
    }
}
