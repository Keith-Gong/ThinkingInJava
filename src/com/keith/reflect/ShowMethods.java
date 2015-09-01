package com.keith.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by keith on 8/26/2015.
 */
public class ShowMethods {
    public static void main (String args[]) {
        /*if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }*/
        int lines = 0;
        try {
            Class<?> c = Class.forName("java.util.List");
            Method[] methods = c.getMethods();
            /*Constructor[] constructors = c.getConstructors();
            if (args.length == 1) {
                for (Method method : methods) {
                    System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                }
                for (Constructor constructor : constructors) {
                    System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method method : methods) {
                    if (method.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(method.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor constructor : constructors) {
                    if (constructor.toString().indexOf(args[1]) != -1) {
                        System.out.println(pattern.matcher(constructor.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }*/
            for (Method method : methods) {
                System.out.println(String.valueOf(method));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


