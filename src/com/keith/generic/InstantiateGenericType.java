package com.keith.generic;

/**
 * Created by keith on 8/31/2015.
 */
public class InstantiateGenericType {
    public static void main (String args[]) {
        ClassAsFactory<Employee> classAsFactory = new ClassAsFactory<Employee>(Employee.class);
    }
}

class ClassAsFactory<T> {
    T x;
    public ClassAsFactory(Class<T> kind) {
        try {
            x = kind.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class Employee {
    //public Employee(int i){}

}
