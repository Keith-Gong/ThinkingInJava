package com.keith.generic;

/**
 * Created by keith on 9/2/2015.
 */
public class Holder <T> {
    private T value;
    public Holder() {}
    public Holder(T val) {
        value = val;
    }
    public void set(T val) {
        this.value = val;
    }
    public T getValue () {
        return this.value;
    }
    public boolean equals(Object obj) {
        return value.equals(obj);
    }
    public static void main (String args[]) {
        Holder<Apple> apple = new Holder<Apple>(new Apple());
        Apple d = apple.getValue();
        apple.set(d);

        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.getValue();
        d = (Apple) fruit.getValue();

        Orange c = (Orange) fruit.getValue();
    }
}
