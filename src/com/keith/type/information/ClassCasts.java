package com.keith.type.information;

/**
 * Created by Keith on 8/25/15.
 */
public class ClassCasts {
    public static void main (String args[]) {
        Building building = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(building);

        h = (House) building;
    }
}

class Building {

}

class House extends Building {

}


