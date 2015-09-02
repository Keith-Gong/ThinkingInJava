package com.keith.array;

/**
 * Created by keith on 9/2/2015.
 */
public class CounterGenerator {
    public static void main (String args[]) {

    }
    public static class Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;
        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {

        private java.lang.Byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("azqwsxedcrfvtgb" + "ADFVCSDWRFSDS").toCharArray();
    public static class Character implements Generator<java.lang.Character> {
        int index = -1;
        @Override
        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }


}

interface Generator<T> {
    T next();
}
