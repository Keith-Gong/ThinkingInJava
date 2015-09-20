package com.keith.enumtype;

/**
 * Created by Keith on 9/20/15.
 */
public class Meal {
    public static void main (String args[]) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("-----");
        }
    }
}

enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;
    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }
    public Food randomSelection () {
        return Enums.random(values);
    }
}

enum Test1 {
    TEST_1(1),
    TEST_2("11");
    private <T> Test1 (T t) {

    }
}
