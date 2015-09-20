package com.keith.enumtype;
import static com.keith.enumtype.Spiciness.*;

/**
 * Created by Keith on 9/20/15.
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) {
        this.degree = degree;
    }
    public String toString() {
        return "Burrito is " + degree;
    }
    public static void main (String args[]) {
        System.out.println(new Burrito(HOT));
        System.out.println(new Burrito(MILD));
        System.out.println(new Burrito(FLAMING));
    }
}


