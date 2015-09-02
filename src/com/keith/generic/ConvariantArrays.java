package com.keith.generic;

/**
 * Created by keith on 9/2/2015.
 */
public class ConvariantArrays {
    public static void main (String args[]) {
        Fruit[] fruits = new Apple[10];
        fruits[0] = new Apple();
        fruits[1] = new Jonathan();
        fruits[2] = new Fruit();
        fruits[3] = new Orange();
    }
}

class Fruit {}

class Apple extends Fruit {}

class Jonathan extends Apple {}

class Orange extends Fruit {}
