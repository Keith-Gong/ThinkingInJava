package com.keith.enumtype;

/**
 * Created by Keith on 9/20/15.
 */
public class RandomTest {
    public static void main (String args[]) {
        for (int i = 0; i < 20; i++) {
            System.out.print(Enums.random(Activity.class) + " ");
        }

    }
}

enum Activity {
    SITTING, LTING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING;
    String test;
    Activity(String test) {
        this.test = test;
    }
    public String getTest() {
        return this.test;
    }

    Activity() {

    }
}
