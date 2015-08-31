package com.keith.generic;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Keith on 8/29/15.
 */
public class LimitOfInference {
    public static void main (String args[]) {
        Map<Integer, List<? extends String>> map = Utils.map();
        f(Utils.map());
    }

    static void f(Map<String, List<? extends String>> map) {

    }
}

class Utils {
    public static <K,V> Map <K,V> map() {
        return new HashMap<K,V> ();
    }
}