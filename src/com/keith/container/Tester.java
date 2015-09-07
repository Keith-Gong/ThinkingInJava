package com.keith.container;

import java.util.List;
import java.util.Queue;

/**
 * Created by Keith on 9/6/15.
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    protected C container;
    public static TestParam[] defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C initialize(int size) {
        return container;
    }
    private String headLine = "";
    private List<Test<C>> tests;
    private static String stringField() {
        return "%" + fieldWidth + "s";
    }
    private static String numberField() {
        return "%" + fieldWidth + "d";
    }
    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private TestParam[] paramList = defaultParams;
    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null) {
            headLine = container.getClass().getSimpleName();
        }
    }
    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }
    public void setHeadLine(String newHeadLine) {
        headLine = newHeadLine;
    }
    public static <C> void run(C cntnr, List<Test<C>> tests) {
        new Tester<C>(cntnr, tests).timedTest();
    }
    private void displayHeader () {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headLine.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++) {
            head.append('-');
        }
        System.out.println(head);
        System.out.format(sizeField, "size");
        for(Test test : tests) {
            System.out.format(stringField(), test.name);
        }
        System.out.println();
    }
    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.SIZE);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.SIZE);
                long start = System.nanoTime();

                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
abstract class Test<C> {
    String name;
    public Test(String name) {
        this.name = name;
    }
    abstract int test(C container, TestParam tp);
}

class TestParam {
    public final int SIZE;
    public final int LOOPS;
    public TestParam (int size, int loops) {
        this.SIZE = size;
        this.LOOPS = loops;
    }
    public static TestParam[] array(int...values) {
        int size = values.length / 2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++) {
            result[i] = new TestParam(values[n++], values[n++]);
        }
        return result;
    }
    public static TestParam[] array(String[] values) {
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}

