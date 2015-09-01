package com.keith.generic;

/**
 * Created by keith on 8/31/2015.
 */
public class ClassType<T> {
    Class<T> kind;
    public ClassType(Class<T> kind) {
        this.kind = kind;
    }
    public boolean f (Object arg) {
        return kind.isInstance(arg);
    }
    public static void main (String args[]) {
        ClassType<Building> classType = new ClassType<Building>(Building.class);
        System.out.println(classType.f(new Building()));
        System.out.println(classType.f(new House()));
    }
}

//Use isInstance
class Building {}
class House extends Building {}
