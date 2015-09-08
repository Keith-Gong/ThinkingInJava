package com.keith.container;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by keith on 9/8/2015.
 */
public class Stacks {
    public static void main(String args[]) {
        Stack<String> stack = new Stack<String>();
        for (Month m : Month.values()) {
            stack.push(m.toString());
        }
        System.out.println("Stack = " + stack);
        stack.addElement("-----The Last Line-----");
        System.out.println("Popping elements");
        while (!stack.empty()) {
            System.out.println(stack.pop() + " ");
        }


        //Using a LinkedList as a Stack
        LinkedList<String> listStack = new LinkedList<String>();
        for (Month m : Month.values()) {
            listStack.addFirst(m.toString());
        }
        System.out.println("listStack = " + listStack);
        while (!listStack.isEmpty()) {
            System.out.println(listStack.removeFirst() + " ");
        }

    }
}

enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER
}
