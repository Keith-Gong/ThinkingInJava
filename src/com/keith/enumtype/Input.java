package com.keith.enumtype;

import java.util.Random;

/**
 * Created by Keith on 9/22/15.
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amount () {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amount () {
            throw new RuntimeException("SHUT_DPWN.amount()");
        }
    };

    int value;
    Input(int value) {
        this.value = value;
    }

    Input (Context context) {
        this.context = context;
    }
    Context context;
    Input () {}
    int amount () {
        return value;
    }
    static Random random = new Random(47);
    public static Input randomSelection () {
        return values()[random.nextInt(values().length - 1)];
    }
}

class Context {

}