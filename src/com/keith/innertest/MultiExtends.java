package com.keith.innertest;

/**
 * Created by Keith on 8/24/15.
 */
public class MultiExtends {
    public static void main(String args[]) {

    }
}

class Father1 {
    void say1 () {

    }
}

class Father2 {
    void say2 () {

    }
}

class Father3 {
    void say3 () {

    }
}

class Father {
    void say () {

    }
}

class Son extends Father {
    private class Closure1 extends Father1 {
        @Override
        void say1() {
            super.say1();
        }
    }
    private Father1 getFather1 () {
        return new Closure1();
    }

    private class Closure2 extends Father2 {
        @Override
        void say2() {
            super.say2();
        }
    }
    private Father2 getFather2 () {
        return new Closure2();
    }
}