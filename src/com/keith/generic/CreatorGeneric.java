package com.keith.generic;

/**
 * Created by Keith on 8/31/15.
 */
public class CreatorGeneric {
    public static void main (String args[]) {
        Creator creator = new Creator();
        creator.f();
    }
}

abstract class GenericWithCreate<T> {
    final T element;
    GenericWithCreate () {
        element = create();
    }
    abstract T create();
}

class X {}

class Creator extends GenericWithCreate<X> {


    void f() {
        System.out.println(element.getClass().getSimpleName());
    }

    @Override
    X create() {
        return new X();
    }
}
