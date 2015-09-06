package com.keith.container;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by keith on 9/6/2015.
 */
public class IndividualTest {
    public static void main (String args[]) {
        Set<Individual> pets = new TreeSet<Individual>();
        //for (List<? extends Object> lp )
    }
}
class Individual implements Comparable<Individual> {
    private static long counter = 0;
    private final long ID = counter++;
    private String name;
    public Individual(String name) {
        this.name = name;
    }

    public Individual() {}

    public String toString () {
        return getClass().getSimpleName() + (name == null ?
        "" : "" + name);
    }

    public long id() {
        return ID;
    }

    public boolean equals (Object o) {
        return o instanceof Individual &&
                ID == ((Individual) o).ID;
    }

    public int hashCode () {
        int result = 17;
        if (name == null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + name.hashCode();
        return result;
    }

    @Override
    public int compareTo(Individual arg) {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return (arg.ID < ID ? -1 : (arg.ID == ID ? 0 : 1));
    }


}
