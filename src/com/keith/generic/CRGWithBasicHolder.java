package com.keith.generic;

/**
 * Created by keith on 9/2/2015.
 */
public class CRGWithBasicHolder {
    public static void main(String args[]) {
        SubType subType1 = new SubType();
        SubType subType2 = new SubType();
        subType1.set(subType2);
        SubType subType3 = subType1.get();
        subType1.f();
    }
}

class BasicHolder<T> {
    T element;
    void set(T arg) {
        element = arg;
    }
    T get() {
        return element;
    }
    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

class SubType extends BasicHolder<SubType> {

}