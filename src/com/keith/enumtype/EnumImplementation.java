package com.keith.enumtype;

import java.util.Random;

/**
 * Created by Keith on 9/20/15.
 */
public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg) {
        System.out.println(rg.next() + ": ");
    }
    public static void main (String args[]) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++) {
            printNext(cc);
        }
    }
}

enum CartoonCharacter implements Generator<CartoonCharacter>{
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
    private Random rand = new Random(47);


    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
}

interface Generator<T> {
    T next();
}
