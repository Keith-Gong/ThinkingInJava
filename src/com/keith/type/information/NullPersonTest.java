package com.keith.type.information;

/**
 * Created by Keith on 8/27/15.
 */
public class NullPersonTest {
    public static void main (String args[]) {

    }
}

interface Null {

}

class Person {
    public final String FIRST;
    public final String LAST;
    public final String ADDRESS;

    public Person (String first, String last, String address) {
        this.FIRST = first;
        this.LAST = last;
        this.ADDRESS  = address;
    }

    @Override
    public String toString() {
        return "Person : " + LAST + " " + FIRST + " / " + ADDRESS;
    }

    public static class NullPerson extends Person implements Null {

        public NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "Null Person";
        }

        public static final Person NULL = new NullPerson();
    }
}
