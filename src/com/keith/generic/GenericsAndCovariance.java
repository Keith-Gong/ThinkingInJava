package com.keith.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by keith on 9/2/2015.
 */
public class GenericsAndCovariance {
    public static void main (String args[]) {
        List<? extends Fruit> fruitsList = new ArrayList<Apple>();
        /*fruitsList.add(new Apple());
        fruitsList.add(new Fruit());
        fruitsList.add(new Banana<>());*/
    }
}

class Banana<T extends Fruit> {

}
