package com.keith.reflect;

import java.util.ArrayList;

/**
 * Created by Keith on 8/27/15.
 */
public class NullPersonTest {
    public static void main (String args[]) {
        Staff staff = new Staff("President", "CTO", "HR");
        staff.fillPosition("HR", new Person("Marry", "Wang", "St.5"));
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
    }
    public static final Person NULL = new NullPerson();
}

class Position {
    private String title;
    private Person person;
    public Position (String title, Person person) {
        this.title = title;
        this.person = person;
        if (this.person == null) {
            person = Person.NULL;
        }
    }
    public Position (String title) {
        this.title = title;
        this.person = Person.NULL;
    }

    public String getTitle () {
        return this.title;
    }
    public Person getPerson () {
        return this.person;
    }
    public void setPerson (Person person) {
        this.person = person;
        if (this.person == null) {
            person = Person.NULL;
        }
    }
}

class Staff extends ArrayList<Position> {
    public void add (String title, Person person) {
        add(new Position(title, person));
    }

    public void add (String...titles) {
        for (String title : titles) {
            add(new Position(title));
        }
    }

    public Staff (String... titles) {
        add(titles);
    }

    public boolean positionAvailable (String title) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL) {
                return true;
            }
        }
        return false;
    }

    public void fillPosition (String title, Person hire) {
        for (Position position : this) {
            if (position.getTitle().equals(title) &&
                    position.getPerson() == Person.NULL) {
                position.setPerson(hire);
                return;
            }
            throw new RuntimeException("Position " + "title " + "not available");
        }
    }
}