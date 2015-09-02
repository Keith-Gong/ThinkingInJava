package com.keith.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by keith on 9/2/2015.
 */
public class ContainerComparison {
    public static void main (String args[]) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[10];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }

        System.out.println(Arrays.toString(berylliumSpheres));
        System.out.println(berylliumSpheres[1]);
        List<BerylliumSphere> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new BerylliumSphere());
        }

        System.out.println(list);
    }
}

class BerylliumSphere {
    private static long counter;
    private final long ID = counter++;
    public String toString () {
        return "Sphere " + ID;
    }
}
