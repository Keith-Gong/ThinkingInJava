package com.keith.interfacetest;

/**
 * Created by Keith on 8/24/15.
 */
public class ExtentTest {
}

interface IPerson {
    void canFly ();
    void canCry ();
}

interface IPerson1 {
    void canFly1 ();
}

interface ISuperman extends IPerson, IPerson1{
    void iaiai();
}

class FatherBird {
    public void canFly () {
        System.out.println("1111");
    }
}

class SonBird extends FatherBird implements IPerson {

    @Override
    public void canCry() {

    }
}

class SonMan implements ISuperman {

    @Override
    public void canFly() {

    }

    @Override
    public void canCry() {

    }

    @Override
    public void canFly1() {

    }

    @Override
    public void iaiai() {

    }
}
