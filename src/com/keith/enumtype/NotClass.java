package com.keith.enumtype;

/**
 * Created by Keith on 9/21/15.
 */
public class NotClass {
    public static void main (String args[]) {
        System.out.println(
                LikeClasses.WINKEN.behavior(3));
        System.out.println(LikeClasses.WINKEN.getClass());
    }
}

enum LikeClasses {
    WINKEN {
        String behavior (int i) {
            return "Behavior1" + i;
        }
    },
    BLINKEN {
        String behavior (int i) {
            return "Behavior2" + i;
        }
    },
    NOD {
        String behavior (int i) {
            return "Behavior3" + i;
        }
    };
    abstract String behavior (int i);
}
