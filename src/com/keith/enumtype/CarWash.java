package com.keith.enumtype;

import java.util.EnumSet;

/**
 * Created by Keith on 9/21/15.
 */
public class CarWash {
    public static void main (String args[]) {
        CarWash wash = new CarWash();
        System.out.println(wash);
        wash.washCar();

        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.BLOWDRY);
        wash.add(Cycle.PINSE);
        wash.add(Cycle.HOTWAX);
        System.out.println(wash);
        wash.washCar();
    }
    public enum Cycle {
        UNDERBODY {
            void action () {
                System.out.println("underbody");
            }
        },
        WHEELWASH {
            void action () {
                System.out.println("wheelwash");
            }
        },
        PREWASH {
            void action () {
                System.out.println("prewash");
            }
        },
        BASIC {
            void action () {
                System.out.println("basic wash");
            }
        },
        HOTWAX {
            void action () {
                System.out.println("hotwax");
            }
        },
        PINSE {
            void action () {
                System.out.println("pinse");
            }
        },
        BLOWDRY {
            void action () {
                System.out.println("blowdry");
            }
        };
        abstract void action ();
    }
    EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.PINSE);
    public void add(Cycle cycle) {
        cycles.add(cycle);
    }
    public void washCar () {
        for (Cycle c : cycles) {
            c.action();
        }
    }
    public String toString () {
        return cycles.toString();
    }
}
