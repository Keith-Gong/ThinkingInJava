package com.keith.generic;

/**
 * Created by Keith on 8/29/15.
 */
public class FooTest<T> {
    public static void main (String args[]) {
        Foo<Cat> foo = new Foo<>();

            if (foo.var instanceof Object) {
                System.out.println("11");
            }
    }
}

class Foo<T> {
    T var;
}
class Cat {

}