package com.keith.container;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by keith on 9/6/2015.
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception {
        Constructor<T> hog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
        for (int i = 0; i < 10; i++) {
            map.put(hog.newInstance(i), new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog groundhog = hog.newInstance(3);
        System.out.println("Looking up prediction for " + groundhog);
        if (map.containsKey(groundhog)) {
            System.out.println(map.get(groundhog));
        } else {
            System.out.println("Key not found: " + groundhog);
        }
    }
    public static void main (String args[]) throws Exception {
        detectSpring(Groundhog.class);
    }
}

class Groundhog {
    protected int number;
    public Groundhog(int n) {
        this.number = n;
    }
    public String toString () {
        return "Grounding #" + number;
    }
}

class Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;
    public String toString () {
        if (shadow) {
            return "Six more weeks of winter";
        } else {
            return "Early Spring";
        }
    }
}
