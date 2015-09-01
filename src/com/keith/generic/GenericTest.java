package com.keith.generic;

/**
 * Created by keith on 8/18/2015.
 */
public class GenericTest {
    public static void main (String args[]) {
        Point<String, Integer> point = new Point();
        //point.setX();

        Point1 p1 = new Point1();
        Foo f = new Foo();
        p1.setX(f);
        p1.getX();
    }
}

class Point<K,V> {
    private K x;
    private V y;

    public K getX() {
        return x;
    }

    public void setX(K x) {
        this.x = x;
        this.x = x;
    }

    public V getY() {
        return y;
    }

    public void setY(V y) {
        this.y = y;
    }
}

class Point1 {
    private Object x;
    private String y;

    public Object getX() {
        return x;
    }

    public void setX(Object x) {
        this.x = (Integer)x;
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}

class Foo {

}